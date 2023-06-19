package com.turing.wallet.controller.app;

import com.coinbull.cacheclient.model.CacheUser;
import com.turing.wallet.annotation.LoginRequired;
import com.turing.wallet.controller.BaseController;
import com.turing.wallet.domain.GasFee;
import com.turing.wallet.domain.PublicConfig;
import com.turing.wallet.domain.UserAccountCurrency;
import com.turing.wallet.enums.ApiResultType;
import com.turing.wallet.param.*;
import com.turing.wallet.service.WalletChainService;
import com.turing.wallet.service.WalletCurrencyService;
import com.turing.wallet.service.WalletUserAccountService;
import com.turing.wallet.service.WalletUserCurrencyService;
import com.turing.wallet.service.common.CommonService;
import com.turing.wallet.utils.JwtUtil;
import com.turing.wallet.wrapper.ResponseWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

import static com.turing.wallet.constants.Const.EXCH_LANGUAGE;

/**
 * 钱包接口
 */
@RequestMapping("/v2/wallet")
@RestController
@Slf4j
public class WalletController extends BaseController {

    @Autowired
    private WalletChainService chainService;

    @Autowired
    private WalletCurrencyService currencyService;

    @Autowired
    private WalletUserCurrencyService userCurrencyService;

    @Autowired
    private WalletUserAccountService walletUserAccountService;

    public WalletController(CommonService commonService) {
        super(commonService);
    }

    /**
     * 公用配置信息
     *
     * @return:
     * @Date: 2020-05-11
     */
    @ApiOperation(value = "公用配置信息")
    @GetMapping("/public/config")
    public ResponseEntity<ResponseWrapper> publicConfig(HttpServletRequest httpRequest) {
        String exchLang = httpRequest.getHeader(EXCH_LANGUAGE);
        PublicConfig publicConfig = currencyService.getPublicConfig(exchLang);
        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success, publicConfig));
    }

    /**
     * 查询链gas费
     *
     * @return:
     * @Date: 2020-05-11
     */
    @ApiOperation(value = "查询链gas费")
    @GetMapping("/chain/gasfee")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "chainType", value = "链类型 0: btc链,1:eth链 2：币安链 3：波场链", required = true, paramType = "query", dataType = "int")
    })
    public ResponseEntity<ResponseWrapper> getChainGasfee(@RequestParam Integer chainType, HttpServletRequest httpRequest) {
        String exchLang = httpRequest.getHeader(EXCH_LANGUAGE);
        //GasFee gasFee = GasUtils.getGasFee(chainType);
        //todo 测试阶段先写死
        GasFee gasFee = new GasFee();
        gasFee.setProposeGasPrice(new BigDecimal("74"));
        gasFee.setFastGasPrice(new BigDecimal("78"));
        gasFee.setSlowGasPrice(new BigDecimal("73.7"));

        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success, gasFee));
    }

    /**
     * 查询代币对法币最新行情报价
     *
     * @return:
     * @Date: 2020-05-11
     */
    @ApiOperation(value = "查询代币对法币最新行情报价")
    @PostMapping("/currency/lastPrice")
    public ResponseEntity<ResponseWrapper> getLastPrice(@RequestBody QuotePriceQuery quotePriceQuery, HttpServletRequest httpRequest) {
        String exchLang = httpRequest.getHeader(EXCH_LANGUAGE);
        //String lastPrice = QuoteUtils.getLastPrice(quotePriceQuery.getSymbol(),quotePriceQuery.getConvert());
        //todo 测试阶段先写死
        String lastPrice = "1";
        switch (quotePriceQuery.getSymbol().toLowerCase()){
            case "eth":
                lastPrice = "2816";
                break;
            case "btc":
                lastPrice = "28330";
                break;
        }
        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success,lastPrice));
    }

    /**
     * 查询用户账号币种列表
     *
     * @return:
     * @Date: 2020-05-11
     */
    @ApiOperation(value = "查询用户账号币种列表")
    @PostMapping("/user/currency/list")
    @LoginRequired
    public ResponseEntity<ResponseWrapper> queryUserCurrencyList(@RequestBody UserCurrencyQuery userCurrencyQuery, HttpServletRequest httpRequest) {
        String exchLang = httpRequest.getHeader(EXCH_LANGUAGE);
        //String lastPrice = QuoteUtils.getLastPrice(quotePriceQuery.getSymbol(),quotePriceQuery.getConvert());
        //List<UserCurrency> userCurrencyList = userCurrencyService.queryUserCurrencyList(userCurrencyQuery,exchLang);
        CacheUser cacheUser = JwtUtil.getCacheUser(httpRequest);
        List<UserAccountCurrency> userAccountCurrencyList =  walletUserAccountService.queryUserAccountChainCurrencyList(cacheUser.getId(),userCurrencyQuery,exchLang);
        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success,userAccountCurrencyList));
    }

    /**
     * 设置用户链地址
     *
     * @return:
     * @Date: 2020-05-11
     */
    @ApiOperation(value = "设置用户链地址")
    @PostMapping("/user/chainaddress/set")
    @LoginRequired
    public ResponseEntity<ResponseWrapper> userChainAddressSet(@RequestBody ChainAddrSetParam chainAddrNewParam, HttpServletRequest httpRequest) {
        String exchLang = httpRequest.getHeader(EXCH_LANGUAGE);
        //String lastPrice = QuoteUtils.getLastPrice(quotePriceQuery.getSymbol(),quotePriceQuery.getConvert());
        //List<UserCurrency> userCurrencyList = userCurrencyService.queryUserCurrencyList(userCurrencyQuery,exchLang);
        CacheUser cacheUser = JwtUtil.getCacheUser(httpRequest);
        Boolean result =  walletUserAccountService.userChainAddressSet(cacheUser.getId(),chainAddrNewParam,exchLang);
        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success,result));
    }

    /**
     * 设置用户链币种
     *
     * @return:
     * @Date: 2020-05-11
     */
    @ApiOperation(value = "设置用户链币种")
    @PostMapping("/user/chaincurrency/set")
    @LoginRequired
    public ResponseEntity<ResponseWrapper> userChainCurrencySet(@RequestBody ChainCurrencySetParam chainCurrencySetParam, HttpServletRequest httpRequest) throws Exception{
        String exchLang = httpRequest.getHeader(EXCH_LANGUAGE);
        //String lastPrice = QuoteUtils.getLastPrice(quotePriceQuery.getSymbol(),quotePriceQuery.getConvert());
        //List<UserCurrency> userCurrencyList = userCurrencyService.queryUserCurrencyList(userCurrencyQuery,exchLang);
        CacheUser cacheUser = JwtUtil.getCacheUser(httpRequest);
        Boolean result =  walletUserAccountService.userChainCurrencySet(cacheUser.getId(),chainCurrencySetParam,exchLang);
        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success,result));
    }

    /**
     * 删除用户链币种
     *
     * @return:
     * @Date: 2020-05-11
     */
    @ApiOperation(value = "删除用户链币种")
    @PostMapping("/user/chaincurrency/del")
    @LoginRequired
    public ResponseEntity<ResponseWrapper> userChainCurrencyDel(@RequestBody ChainCurrencyDelParam chainCurrencyDelParam, HttpServletRequest httpRequest) throws Exception{
        String exchLang = httpRequest.getHeader(EXCH_LANGUAGE);
        //String lastPrice = QuoteUtils.getLastPrice(quotePriceQuery.getSymbol(),quotePriceQuery.getConvert());
        //List<UserCurrency> userCurrencyList = userCurrencyService.queryUserCurrencyList(userCurrencyQuery,exchLang);
        CacheUser cacheUser = JwtUtil.getCacheUser(httpRequest);
        Boolean result =  walletUserAccountService.userChainCurrencyDel(cacheUser.getId(),chainCurrencyDelParam,exchLang);
        return ResponseEntity.ok(buildSuccessResponseWrapper(ApiResultType.Success,result));
    }

}
