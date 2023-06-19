package com.turing.wallet.service;

import com.alibaba.fastjson.JSON;
import com.coinbull.cacheclient.model.CacheUser;
import com.turing.wallet.domain.AccountInfo;
import com.turing.wallet.model.*;
import com.turing.wallet.param.KeyStore;
import com.turing.wallet.utils.SnowFlakeGenId;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.turing.wallet.constants.Const.ACCOUNT_PREX;

/**
 * @Author: gaowf
 * @Date: 2023/5/8 下午4:39
 */
@Service
@Slf4j
public class SecretKeyService {

    @Autowired
    private WalletUserAccountService walletUserAccountService;

    @Autowired
    private WalletChainService walletChainService;

    @Autowired
    private WalletCurrencyService walletCurrencyService;

    @Autowired
    private WalletUserChainAddrService walletUserChainAddrService;

    @Autowired
    private WalletUserCurrencyService walletUserCurrencyService;

    private SnowFlakeGenId snowFlakeGenId = new SnowFlakeGenId(1,1);

    @Transactional(rollbackFor = Exception.class)
    public AccountInfo saveKey(String exchLang, CacheUser cacheUser, KeyStore keyStore) throws Exception{
        Long uid = cacheUser.getId();
        WalletUserAccount walletUserAccount = walletUserAccountService.getWalletUserAccountListByLikeAccount(uid);
        String accountName = ACCOUNT_PREX + "1";
        if(walletUserAccount != null && StringUtils.isNotBlank(walletUserAccount.getAccountName())){
            accountName = ACCOUNT_PREX + (Integer.parseInt(walletUserAccount.getAccountName().replaceAll(ACCOUNT_PREX,""))+1);
        }
        WalletUserAccount walletUserAccountNew = new WalletUserAccount();
        walletUserAccountNew.setUid(uid);
        Date curDate = new Date();
        Long accountId = snowFlakeGenId.nextId();
        walletUserAccountNew.setAccountId(accountId);
        walletUserAccountNew.setAccountName(accountName);
        walletUserAccountNew.setCtime(curDate);
        boolean result = walletUserAccountService.insert(walletUserAccountNew);
        if(!result) {
            throw new Exception("save account fail.");
        }
        WalletChain walletChain = walletChainService.getWalletChainByDefault();
        if(walletChain != null){
            Long chainId = walletChain.getId();
            WalletUserChainAddr walletUserChainAddrDb = walletUserChainAddrService.getWalletUserChainAddr(uid,accountId,chainId);
            if(walletUserChainAddrDb == null) {
                WalletUserChainAddr walletUserChainAddrNew = new WalletUserChainAddr();
                walletUserChainAddrNew.setAccountId(accountId);
                walletUserChainAddrNew.setChainId(chainId);
                walletUserChainAddrNew.setStatus((byte)1);
                walletUserChainAddrNew.setUid(uid);
                walletUserChainAddrNew.setCtime(curDate);
                Boolean resultAddr = walletUserChainAddrService.insert(walletUserChainAddrNew);
                if(!resultAddr) {
                    String errMsg = "save account chain address fail.";
                    log.error(errMsg+",uid:{},param:{}",uid,JSON.toJSONString(keyStore));
                    throw new Exception(errMsg);
                }
                Long addressId = walletUserChainAddrNew.getId();
                List<WalletCurrency> walletCurrencyList = walletCurrencyService.queryWalletCurrencyList(Arrays.asList(chainId),1,1);
                if(!CollectionUtils.isEmpty(walletCurrencyList)){
                    for(WalletCurrency walletCurrency:walletCurrencyList){
                        WalletUserCurrency walletUserCurrency = new WalletUserCurrency();
                        walletUserCurrency.setCurrency(walletCurrency.getCurrencyCode());
                        walletUserCurrency.setCurrencyId(walletCurrency.getId());
                        walletUserCurrency.setAddressId(addressId);
                        walletUserCurrency.setAccountId(accountId);
                        walletUserCurrency.setUid(uid);
                        walletUserCurrency.setCtime(curDate);
                        walletUserCurrencyService.insert(walletUserCurrency);
                    }
                }
            }
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountId(String.valueOf(accountId));
        accountInfo.setAccountName(accountName);
        return accountInfo;
    }

    public String getServiceKey(String exchLang, CacheUser cacheUser) {
        return "thisisservicekeytestdata";
    }
}
