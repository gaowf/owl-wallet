package com.turing.wallet.service.common;

/**
 * 公共服务.
 */
public interface CommonService {


    /**
     * 系统提示.
     *
     * @param configKey
     * @return
     */
    String sysTipMultilingualTemplate(String configKey);


    /**
     * 多语言.
     *
     * @param configKey 配置key
     * @return
     */
    String multilingualTemplate(String configKey);

    /**
     * 多语言.
     *
     * @param configKey 配置key
     * @param values    站位
     * @return
     */
    String multilingualTemplate(String configKey, String... values);


}
