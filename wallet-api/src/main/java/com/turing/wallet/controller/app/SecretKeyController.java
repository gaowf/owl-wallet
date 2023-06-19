package com.turing.wallet.controller.app;

import com.coinbull.cacheclient.model.CacheUser;
import com.turing.wallet.annotation.LoginRequired;
import com.turing.wallet.controller.BaseController;
import com.turing.wallet.domain.AccountInfo;
import com.turing.wallet.enums.ApiResultType;
import com.turing.wallet.param.KeyStore;
import com.turing.wallet.service.SecretKeyService;
import com.turing.wallet.service.common.CommonService;
import com.turing.wallet.utils.JwtUtil;
import com.turing.wallet.wrapper.ResponseWrapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.turing.wallet.constants.Const.EXCH_LANGUAGE;

/**
 * 密钥
 */
@RequestMapping("/v2/ac")
@RestController
@Slf4j
public class SecretKeyController extends BaseController {


    @Autowired
    private SecretKeyService secretKeyService;

    public SecretKeyController(CommonService commonService) {
        super(commonService);
    }

    /**
     * 用户查询私钥分片
     *
     * @return:
     * @Date: 2020-05-11
     */
    @ApiOperation(value = "用户查询私钥分片")
    @GetMapping("/get/key")
    @LoginRequired
    public ResponseEntity<ResponseWrapper> getServiceKey(HttpServletRequest httpRequest) {
        String exchLang = httpRequest.getHeader(EXCH_LANGUAGE);
        CacheUser cacheUser = JwtUtil.getCacheUser(httpRequest);
        String serviceKey = secretKeyService.getServiceKey(exchLang,cacheUser);
        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success,serviceKey));
    }

    /**
     * 用户托管私钥分片
     *
     * @return:
     * @Date: 2020-05-11
     */
    @ApiOperation(value = "用户托管私钥分片")
    @PostMapping("/save/key")
    @LoginRequired
    public ResponseEntity<ResponseWrapper> saveKey(@RequestBody KeyStore keyStore, HttpServletRequest httpRequest) throws Exception{
        String exchLang = httpRequest.getHeader(EXCH_LANGUAGE);
        CacheUser cacheUser = JwtUtil.getCacheUser(httpRequest);
        AccountInfo accountInfo = secretKeyService.saveKey(exchLang,cacheUser,keyStore);
        if(accountInfo == null){
            return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.STORE_FAIL));
        }
        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success,accountInfo));
    }

}
