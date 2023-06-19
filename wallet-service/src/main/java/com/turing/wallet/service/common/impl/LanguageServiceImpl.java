package com.turing.wallet.service.common.impl;

import com.turing.wallet.constants.Const;
import com.turing.wallet.enums.ApiResultType;
import com.turing.wallet.enums.Language;
import com.turing.wallet.mapper.ConfigLanguageMapper;
import com.turing.wallet.model.v2.common.ConfigLanguage;
import com.turing.wallet.model.v2.common.ConfigLanguageExample;
import com.turing.wallet.service.common.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
@Slf4j
@Service
public class LanguageServiceImpl implements LanguageService {

    // TODO: 2020/5/13 lc 注入方式参考: https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-setter-injection
    @Autowired
    private ConfigLanguageMapper configLanguageMapper;

    /**
     * 根据条件查询 // TODO: 2020/5/13 lc 不建议提供 example查询入口
     *
     * @param example
     * @return List<ConfigLanguage>
     * @author mfXing
     */
    @Override
    public List<ConfigLanguage> findAll(ConfigLanguageExample example) {
        return configLanguageMapper.selectByExample(example);
    }

    /**
     * 根据Key查询ConfigLanguage
     *
     * @param configKey
     * @param langKey
     * @return ConfigLanguage
     * @author mfXing
     */
    @Override
    public ConfigLanguage selectBykey(String configKey, String langKey) {
        ConfigLanguageExample example = new ConfigLanguageExample();
        example.createCriteria().andConfigKeyEqualTo(configKey).andLangKeyEqualTo(langKey);
        List<ConfigLanguage> configLanguageList = configLanguageMapper.selectByExample(example);
        if (configLanguageList != null && configLanguageList.size() > 0) {
            return configLanguageList.get(0);
        }
        return null;
    }


    @Override
    public String multilingualTemplate(String configKey, String... values) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String langKey = request.getHeader(Const.EXCH_LANGUAGE);
        if (StringUtils.isBlank(langKey)) {
            langKey = Language.English.langType;
        }

        return this.multilingualTemplate(configKey, langKey, values);
    }


    @Override
    public String multilingualTemplate(String configKey, String langKey, String... properties) {
        ConfigLanguage configLanguage = this.selectBykey(configKey, langKey);
        if (configLanguage == null) {
            String message = ApiResultType.getMessageByConfigKey(configKey);
            if (!StringUtils.isBlank(message)) {
                return String.format(message, properties);
            }
            return StringUtils.EMPTY;
        }

        String content = configLanguage.getContent();
        return String.format(content, properties);
    }

}
