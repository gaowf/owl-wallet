package com.turing.wallet.service.common.impl;

import com.turing.wallet.service.common.CommonService;
import com.turing.wallet.service.common.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service("v2CommonService")
@Slf4j
public class CommonServiceImpl implements CommonService {


    private final LanguageService languageService;

    public CommonServiceImpl(LanguageService languageService) {
        this.languageService = languageService;
    }


    @Override
    public String sysTipMultilingualTemplate(String configKey) {
        return languageService.multilingualTemplate(configKey);
    }


    @Override
    public String multilingualTemplate(String configKey) {
        return languageService.multilingualTemplate(configKey);
    }

    @Override
    public String multilingualTemplate(String configKey, String... values) {
        return languageService.multilingualTemplate(configKey, values);
    }


}
