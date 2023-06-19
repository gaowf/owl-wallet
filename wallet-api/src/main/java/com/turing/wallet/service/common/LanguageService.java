package com.turing.wallet.service.common;

import com.turing.wallet.model.v2.common.ConfigLanguage;
import com.turing.wallet.model.v2.common.ConfigLanguageExample;

import java.util.List;

/**
 * 语言服务.
 */
public interface LanguageService {

    /**
     * 根据条件查询
     *
     * @param example
     * @return List<ConfigLanguage>
     * @author mfXing
     */
    List<ConfigLanguage> findAll(ConfigLanguageExample example);

    /**
     * 根据Key查询ConfigLanguage
     *
     * @param configKey
     * @param langKey
     * @return ConfigLanguage
     * @author mfXing
     */
    ConfigLanguage selectBykey(String configKey, String langKey);

    /**
     * 多语言模板.
     *
     * @param configKey 配置key.
     * @param values    站位参数.
     * @return
     */
    String multilingualTemplate(String configKey, String... values);

    /**
     * 获取多语言模板内容
     *
     * @param configKey
     * @param langKey
     * @param propertys 按数据库模板中的占位符顺序填写参数
     * @return String
     * @author mfXing
     */
    String multilingualTemplate(String configKey, String langKey, String... propertys);
}
