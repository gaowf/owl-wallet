package com.turing.wallet.controller.app;

import com.turing.wallet.controller.BaseController;
import com.turing.wallet.enums.ApiResultType;
import com.turing.wallet.param.PrivateShares;
import com.turing.wallet.service.WalletBaseService;
import com.turing.wallet.service.common.CommonService;
import com.turing.wallet.wrapper.ResponseWrapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.turing.wallet.constants.Const.EXCH_LANGUAGE;

/**
 * 消息通知轮播
 */
@RequestMapping("/v2")
@RestController
@Slf4j
public class WalletBaseController extends BaseController {

    @Autowired
    private WalletBaseService walletBaseService;

    public WalletBaseController(CommonService commonService) {
        super(commonService);
    }

    /**
     * 存储用户私钥分片
     *
     * @return:
     * @Date: 2023-05-11
     */
    @ApiOperation(value = "存储用户私钥分片")
    @PostMapping("/user/cbs-shares")
    public ResponseEntity<ResponseWrapper> savePrivateShares(@RequestBody PrivateShares privateShares, HttpServletRequest httpRequest) {
        String exchLang = httpRequest.getHeader(EXCH_LANGUAGE);
        Long uid = 0L;
        boolean bResult = walletBaseService.savePrivateShares(uid, privateShares);
        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success, bResult));
    }

    /**
     * 获取用户服务端私钥分片
     *
     * @return:
     * @Date: 2023-05-11
     */
    @ApiOperation(value = "获取用户服务端私钥分片")
    @GetMapping("/user/s-share")
    public ResponseEntity<ResponseWrapper> getPrivateSShare(HttpServletRequest httpRequest) {
        Long uid = 0L;
        String decryptSS = walletBaseService.getServerPrivateShare(uid);
        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success, decryptSS));
    }

}
