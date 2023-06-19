package com.turing.wallet.controller;

import com.turing.wallet.constants.Const;
import com.turing.wallet.enums.ApiResultType;
import com.turing.wallet.service.common.CommonService;
import com.turing.wallet.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 *
 */
@Slf4j
@Controller
public class BaseController {

    @Autowired
    protected RedisTemplate redisTemplate;

    protected final CommonService commonService;

    public BaseController(CommonService commonService) {
        this.commonService = commonService;
    }


    /**
     * 获取交易所id.
     *
     * @param request HttpServletRequest.
     * @return ex id.
     */
    protected Integer getExchId(HttpServletRequest request) {
        String exchId = request.getHeader(Const.EXCH_ID);
        if (StringUtils.isBlank(exchId)) {
            return 0;
        }
        return Integer.parseInt(exchId);
    }


    protected <T> ResponseWrapper<Object> buildFailResponseWrapper(ApiResultType apiResultType) {
        return ResponseWrapper.fail()
                .code(apiResultType.getCode())
                .message(commonService.sysTipMultilingualTemplate(apiResultType.getConfigKey()))
                .build();
    }

    protected <T> ResponseWrapper<Object> buildFailResponseWrapper(ApiResultType apiResultType, String... value) {
        return ResponseWrapper.fail()
                .code(apiResultType.getCode())
                .message(commonService.multilingualTemplate(apiResultType.getConfigKey(), value))
                .build();
    }

    protected <T> ResponseWrapper<Object> buildSuccessResponseWrapper(ApiResultType apiResultType) {
        return buildSuccessResponseWrapper(apiResultType, new HashMap<>(1));
    }

    protected <T> ResponseWrapper<Object> buildSuccessResponseWrapper(
            ApiResultType apiResultType, T data) {
        return ResponseWrapper.success(data)
                .code(apiResultType.getCode())
                .message(commonService.sysTipMultilingualTemplate(apiResultType.getConfigKey()))
                .build();
    }


}
