package com.turing.wallet.service;

import com.alibaba.fastjson.JSON;
import com.turing.wallet.domain.ChainAddrCurrency;
import com.turing.wallet.domain.UserAccountCurrency;
import com.turing.wallet.domain.UserChainAddr;
import com.turing.wallet.mapper.WalletUserAccountMapper;
import com.turing.wallet.model.*;
import com.turing.wallet.param.ChainAddrSetParam;
import com.turing.wallet.param.ChainCurrencyDelParam;
import com.turing.wallet.param.ChainCurrencySetParam;
import com.turing.wallet.param.UserCurrencyQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.turing.wallet.constants.Const.ACCOUNT_PREX;
import static com.turing.wallet.constants.Const.INT_0;


@Service
@Slf4j
public class WalletUserAccountService {

    @Autowired
    private WalletUserAccountMapper userAccountMapper;

    @Autowired
    private WalletUserChainAddrService addrService;

    @Autowired
    private WalletChainService chainService;

    @Autowired
    private WalletCurrencyService currencyService;

    @Autowired
    private WalletUserCurrencyService userCurrencyService;

    @Autowired
    private WalletUserChainAddrService walletUserChainAddrService;

    public WalletUserAccount getWalletUserAccount(Long id) {
        return userAccountMapper.selectByPrimaryKey(id);
    }

    public boolean insert(WalletUserAccount walletUserAccount) {
        int result = userAccountMapper.insertSelective(walletUserAccount);
        return result > INT_0 ? true : false;
    }

    public boolean updateWalletUserAccount(WalletUserAccount walletUserAccount) {
        int result = userAccountMapper.updateByPrimaryKeySelective(walletUserAccount);
        return result > INT_0 ? true : false;
    }

    public WalletUserAccount getWalletUserAccountByInvitedUid(Long uid) {
        WalletUserAccountExample tInviteRecordExample = new WalletUserAccountExample();
        tInviteRecordExample.createCriteria(); //.andFUidEqualTo(uid)
        List<WalletUserAccount> tInviteRecords = userAccountMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public List<WalletUserAccount> queryWalletUserAccountList() {
        WalletUserAccountExample tInviteRecordExample = new WalletUserAccountExample();
        //tInviteRecordExample.setOrderByClause(" id desc ");
        List<WalletUserAccount> tInviteRecords = userAccountMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords;
    }

    public WalletUserAccount getWalletUserAccountListByLikeAccount(Long uid) {
        WalletUserAccountExample walletUserAccountExample = new WalletUserAccountExample();
        walletUserAccountExample.createCriteria().andUidEqualTo(uid).andAccountNameLike(ACCOUNT_PREX+"%");
        walletUserAccountExample.setOrderByClause(" id desc ");
        List<WalletUserAccount> walletUserAccounts = userAccountMapper.selectByExample(walletUserAccountExample);
        if (CollectionUtils.isEmpty(walletUserAccounts)) {
            return null;
        }
        return walletUserAccounts.get(walletUserAccounts.size()-1);
    }

    public List<WalletUserAccount> queryWalletUserAccountList(List<Integer> incomeDayList) {
        WalletUserAccountExample tInviteRecordExample = new WalletUserAccountExample();
        //tInviteRecordExample.createCriteria().andFDiffDayIn(incomeDayList);
        List<WalletUserAccount> tInviteRecords = userAccountMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords;
    }

    public List<WalletUserAccount> queryWalletUserAccountList(Long userId, Long accountId) {
        WalletUserAccountExample walletUserAccountExample = new WalletUserAccountExample();
        walletUserAccountExample.createCriteria().andUidEqualTo(userId).andAccountIdEqualTo(accountId);
        List<WalletUserAccount> walletUserAccountList = userAccountMapper.selectByExample(walletUserAccountExample);
        if (CollectionUtils.isEmpty(walletUserAccountList)) {
            return null;
        }
        return walletUserAccountList;
    }

    public WalletUserAccount getWalletUserAccount(Integer day) {
        WalletUserAccountExample tInviteRecordExample = new WalletUserAccountExample();
        //tInviteRecordExample.createCriteria().andFDiffDayEqualTo(day);
        List<WalletUserAccount> tInviteRecords = userAccountMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public WalletUserAccount getLastWalletUserAccount() {
        WalletUserAccountExample tInviteRecordExample = new WalletUserAccountExample();
        tInviteRecordExample.setOrderByClause(" f_diff_day desc ");
        List<WalletUserAccount> tInviteRecords = userAccountMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

//    public List<UserAccount> queryUserAccountList(UserAccountQuery userCurrencyQuery,String exchLang) {
//        List<WalletUserAccount> walletUserAccountList = queryWalletUserAccountList(userCurrencyQuery.getUserId(),userCurrencyQuery.getAccountId());
//        if(CollectionUtils.isEmpty(walletUserAccountList)){
//            return null;
//        }
//        List<Long> currencyIdList =  walletUserAccountList.stream().map(WalletUserAccount::getCurrencyId).collect(Collectors.toList());
//        List<Long> addressIdList =  walletUserAccountList.stream().map(WalletUserAccount::getAddressId).collect(Collectors.toList());
//        List<WalletUserChainAddr> addrList = addrService.queryWalletUserChainAddrList(addressIdList);
//        List<WalletCurrency> currencyList = currencyService.queryWalletCurrencyList(currencyIdList);
//        Map<Long, WalletUserChainAddr> addrMap = addrList.stream().collect(Collectors.toMap(WalletUserChainAddr::getId, a -> a,(k1, k2)->k1));
//        Map<Long, WalletCurrency> currencyMap = currencyList.stream().collect(Collectors.toMap(WalletCurrency::getId, a -> a,(k1, k2)->k1));
//
//        List<UserAccount> userCurrencyList = new ArrayList<>();
//        for(WalletUserAccount walletUserAccount:walletUserAccountList){
//            UserAccount userCurrency = new UserAccount();
//            BeanUtils.copyProperties(walletUserAccount,userCurrency);
//            WalletCurrency walletUserAccount = currencyMap.get(walletUserAccount.getCurrencyId());
//            // 币种，币图标，币种钱包名称，链id,链名称,地址,地址id,创建时间
//            if(walletUserAccount != null){
//                userCurrency.setIconAddress(walletUserAccount.getIconAddress());
//                userCurrency.setChainId(walletUserAccount.getChainId());
//                userCurrency.setChainName(!StringUtils.isEmpty(walletUserAccount.getChainShowName())?walletUserAccount.getChainShowName():walletUserAccount.getChainName());
//                userCurrency.setChainProtocol(walletUserAccount.getChainProtocol());
//                userCurrency.setContractAddress(walletUserAccount.getContractAddress());
//                userCurrency.setWalletCurrencyName(walletUserAccount.getWalletCurrencyName());
//            }
//            WalletUserChainAddr addr = addrMap.get(walletUserAccount.getAddressId());
//            if(addr != null){
//                userCurrency.setAddress(addr.getAddress());
//            }
//            userCurrencyList.add(userCurrency);
//        }
//        return userCurrencyList;
//    }

    public List<UserAccountCurrency> queryUserAccountChainCurrencyList(Long uid,UserCurrencyQuery userCurrencyQuery, String exchLang) {
        Long accountId = Long.parseLong(userCurrencyQuery.getAccountId());
        List<WalletUserAccount> userAccountList = queryWalletUserAccounts(uid, accountId);
        if (CollectionUtils.isEmpty(userAccountList)) {
            return null;
        }
        List<Long> accountIdList = userAccountList.stream().map(WalletUserAccount::getAccountId).collect(Collectors.toList());
        List<WalletUserChainAddr> addrList = addrService.queryChainAddrList(accountIdList, userCurrencyQuery.getChainId());
        if (CollectionUtils.isEmpty(addrList)) {
            return convertToUserAccountCurrency(userAccountList);
        }
        List<Long> addrIdList = addrList.stream().map(WalletUserChainAddr::getId).collect(Collectors.toList());
        List<WalletUserCurrency> userCurrencyList = userCurrencyService.queryWalletUserCurrencyListByAddrIds(addrIdList);
        if (CollectionUtils.isEmpty(userCurrencyList)) {
            return convertToUserAccountCurrency(userAccountList, addrList);
        }
        List<Long> currencyIdList = userCurrencyList.stream().map(WalletUserCurrency::getCurrencyId).collect(Collectors.toList());
        List<WalletCurrency> walletCurrencyList = currencyService.queryWalletCurrencyList(currencyIdList);
        Map<Long, WalletCurrency> currencyMap = walletCurrencyList.stream().collect(Collectors.toMap(WalletCurrency::getId, a -> a, (k1, k2) -> k1));
        return convertToUserAccountCurrency(userAccountList, addrList, userCurrencyList, currencyMap);
    }

    private List<UserAccountCurrency> convertToUserAccountCurrency(List<WalletUserAccount> userAccountList, List<WalletUserChainAddr> addrList, List<WalletUserCurrency> userCurrencyList, Map<Long, WalletCurrency> currencyMap) {
        List<UserAccountCurrency> userAccountCurrencyList = new ArrayList<>();
        Map<Long, List<WalletUserChainAddr>> map = addrList.stream().collect(Collectors.groupingBy(WalletUserChainAddr::getAccountId));
        List<Long> chainIdList = addrList.stream().map(WalletUserChainAddr::getChainId).collect(Collectors.toList());
        List<WalletChain> walletChainList = chainService.queryWalletChainList(chainIdList);
        Map<Long, WalletChain> walletChainMap = null;
        if (!CollectionUtils.isEmpty(walletChainList)) {
            walletChainMap = walletChainList.stream().collect(Collectors.toMap(WalletChain::getId, a -> a, (k1, k2) -> k1));
        } else {
            walletChainMap = new HashMap<>();
        }

        Map<Long, List<WalletUserCurrency>> userCurrencyMapByAddrIds = userCurrencyList.stream().collect(Collectors.groupingBy(WalletUserCurrency::getAddressId));

        for (WalletUserAccount walletUserAccount : userAccountList) {
            UserAccountCurrency userAccountCurrency = new UserAccountCurrency();
            BeanUtils.copyProperties(walletUserAccount, userAccountCurrency);
            List<WalletUserChainAddr> walletUserChainAddrList = map.get(walletUserAccount.getAccountId());
            if (!CollectionUtils.isEmpty(walletUserChainAddrList)) {
                List<UserChainAddr> chainAddrList = convertToChainAddrList(walletUserChainAddrList, userCurrencyMapByAddrIds, walletChainMap, currencyMap);
                userAccountCurrency.setChainAddrList(chainAddrList);
            }
            userAccountCurrencyList.add(userAccountCurrency);
        }
        return userAccountCurrencyList;
    }

    private List<UserChainAddr> convertToChainAddrList(List<WalletUserChainAddr> walletUserChainAddrList, Map<Long, List<WalletUserCurrency>> userCurrencyMapByAddrIds, Map<Long, WalletChain> walletChainMap, Map<Long, WalletCurrency> currencyMap) {
        List<UserChainAddr> userChainAddrList = new ArrayList<>();
        for (WalletUserChainAddr walletUserChainAddr : walletUserChainAddrList) {
            UserChainAddr userChainAddr = new UserChainAddr();
            BeanUtils.copyProperties(walletUserChainAddr, userChainAddr);
            WalletChain walletChain = walletChainMap.get(walletUserChainAddr.getChainId());
            if (walletChain != null) {
                setUserChainAddr(userChainAddr, walletChain);
            }
            List<WalletUserCurrency> walletUserCurrencyList = userCurrencyMapByAddrIds.get(walletUserChainAddr.getId());
            if (!CollectionUtils.isEmpty(walletUserCurrencyList)) {
                userChainAddr.setCurrencyList(convertToUserAccountCurrencyList(walletUserCurrencyList, currencyMap));
            }
            userChainAddrList.add(userChainAddr);
        }
        return userChainAddrList;
    }

    private List<ChainAddrCurrency> convertToUserAccountCurrencyList(List<WalletUserCurrency> walletUserCurrencyList, Map<Long, WalletCurrency> currencyMap) {
        List<ChainAddrCurrency> chainAddrCurrencyList = new ArrayList<>();
        for (WalletUserCurrency walletUserCurrency : walletUserCurrencyList) {
            ChainAddrCurrency chainAddrCurrency = new ChainAddrCurrency();
            BeanUtils.copyProperties(walletUserCurrency, chainAddrCurrency);
            WalletCurrency walletCurrency = currencyMap.get(walletUserCurrency.getCurrencyId());
            if (walletCurrency != null) {
                setChainAddrCurrency(chainAddrCurrency, walletCurrency);
            }
            chainAddrCurrencyList.add(chainAddrCurrency);
        }
        return chainAddrCurrencyList;
    }

    private void setChainAddrCurrency(ChainAddrCurrency chainAddrCurrency, WalletCurrency walletCurrency) {
        chainAddrCurrency.setContractAddress(walletCurrency.getContractAddress());
        chainAddrCurrency.setCurrencyType(walletCurrency.getCurrencyType());
        chainAddrCurrency.setWalletCurrencyName(walletCurrency.getWalletCurrencyName());
        chainAddrCurrency.setIconAddress(walletCurrency.getIconAddress());
    }

    private List<UserAccountCurrency> convertToUserAccountCurrency(List<WalletUserAccount> userAccountList, List<WalletUserChainAddr> addrList) {
        List<UserAccountCurrency> userAccountCurrencyList = new ArrayList<>();
        Map<Long, List<WalletUserChainAddr>> map = addrList.stream().collect(Collectors.groupingBy(WalletUserChainAddr::getAccountId));
        for (WalletUserAccount walletUserAccount : userAccountList) {
            UserAccountCurrency userAccountCurrency = new UserAccountCurrency();
            BeanUtils.copyProperties(walletUserAccount, userAccountCurrency);
            List<WalletUserChainAddr> walletUserChainAddrList = map.get(walletUserAccount.getAccountId());
            if (!CollectionUtils.isEmpty(walletUserChainAddrList)) {
                List<Long> chainIdList = walletUserChainAddrList.stream().map(WalletUserChainAddr::getChainId).collect(Collectors.toList());
                List<WalletChain> walletChainList = chainService.queryWalletChainList(chainIdList);
                Map<Long, WalletChain> walletChainMap = null;
                if (!CollectionUtils.isEmpty(walletChainList)) {
                    walletChainMap = walletChainList.stream().collect(Collectors.toMap(WalletChain::getId, a -> a, (k1, k2) -> k1));
                } else {
                    walletChainMap = new HashMap<>();
                }
                userAccountCurrency.setChainAddrList(convertToChainAddrList(walletUserChainAddrList, walletChainMap));
            }
            userAccountCurrencyList.add(userAccountCurrency);
        }
        return userAccountCurrencyList;
    }

    private List<UserChainAddr> convertToChainAddrList(List<WalletUserChainAddr> walletUserChainAddrList, Map<Long, WalletChain> walletChainMap) {
        List<UserChainAddr> userChainAddrList = new ArrayList<>();
        for (WalletUserChainAddr walletUserChainAddr : walletUserChainAddrList) {
            UserChainAddr userChainAddr = new UserChainAddr();
            BeanUtils.copyProperties(walletUserChainAddr, userChainAddr);
            WalletChain walletChain = walletChainMap.get(walletUserChainAddr.getChainId());
            if (walletChain != null) {
                setUserChainAddr(userChainAddr, walletChain);
            }
            userChainAddrList.add(userChainAddr);
        }
        return userChainAddrList;
    }

    private void setUserChainAddr(UserChainAddr userChainAddr, WalletChain walletChain) {
        userChainAddr.setChainId(walletChain.getId());
        userChainAddr.setChainName(walletChain.getName());
        userChainAddr.setChainShowName(walletChain.getShowName());
        userChainAddr.setChainProtocol(walletChain.getChainProtocol());
        userChainAddr.setChainBrowserAddress(walletChain.getChainBrowserAddress());
        userChainAddr.setChainIconAddress(walletChain.getIconAddress());
    }

    private List<UserAccountCurrency> convertToUserAccountCurrency(List<WalletUserAccount> userAccountList) {
        List<UserAccountCurrency> userAccountCurrencyList = new ArrayList<>();
        for (WalletUserAccount walletUserAccount : userAccountList) {
            UserAccountCurrency userAccountCurrency = new UserAccountCurrency();
            BeanUtils.copyProperties(walletUserAccount, userAccountCurrency);
            userAccountCurrencyList.add(userAccountCurrency);
        }
        return userAccountCurrencyList;
    }

    private List<WalletUserAccount> queryWalletUserAccounts(Long uid, Long accountId) {
        WalletUserAccountExample userAccountExample = new WalletUserAccountExample();
        WalletUserAccountExample.Criteria criteria = userAccountExample.createCriteria();
        criteria.andUidEqualTo(uid);
        if (accountId != null) {
            criteria.andAccountIdEqualTo(accountId);
        }
        List<WalletUserAccount> userAccountList = userAccountMapper.selectByExample(userAccountExample);
        if (CollectionUtils.isEmpty(userAccountList)) {
            return null;
        }
        return userAccountList;
    }

    public Boolean userChainAddressSet(Long uid, ChainAddrSetParam chainAddrSetParam, String exchLang) {
        Long accountId = Long.parseLong(chainAddrSetParam.getAccountId());
        Long chainId = chainAddrSetParam.getChainId();
        Date curDate = new Date();
        Boolean result = false;
        WalletUserChainAddr walletUserChainAddrDb = walletUserChainAddrService.getWalletUserChainAddr(uid,accountId,chainId);
        if(walletUserChainAddrDb == null){
            WalletUserChainAddr walletUserChainAddr = new WalletUserChainAddr();
            walletUserChainAddr.setAccountId(accountId);
            walletUserChainAddr.setChainId(chainId);
            walletUserChainAddr.setStatus((byte)1);
            walletUserChainAddr.setUid(uid);
            walletUserChainAddr.setCtime(curDate);
            walletUserChainAddr.setAddress(chainAddrSetParam.getAddress());
            result = walletUserChainAddrService.insert(walletUserChainAddr);
        } else {
            if(StringUtils.isEmpty(walletUserChainAddrDb.getAddress())){
                WalletUserChainAddr walletUserChainAddrUpdate = new WalletUserChainAddr();
                walletUserChainAddrUpdate.setId(walletUserChainAddrDb.getId());
                walletUserChainAddrUpdate.setAddress(chainAddrSetParam.getAddress().trim());
                walletUserChainAddrUpdate.setUtime(curDate);
                result = walletUserChainAddrService.updateWalletUserChainAddr(walletUserChainAddrUpdate);
            } else {
                if (!walletUserChainAddrDb.getAddress().equals(chainAddrSetParam.getAddress())) {
                    log.error("address is not match,can't update,param:{}", JSON.toJSONString(chainAddrSetParam));
                    return false;
                }
            }
        }
        return result;
    }

    public Boolean userChainCurrencySet(Long uid, ChainCurrencySetParam chainCurrencySetParam, String exchLang) throws Exception {
        Long accountId = Long.parseLong(chainCurrencySetParam.getAccountId());
        Long chainId = chainCurrencySetParam.getChainId();
        Long currencyId = chainCurrencySetParam.getCurrencyId();
        Date curDate = new Date();
        Boolean result = false;
        WalletUserChainAddr walletUserChainAddrDb = walletUserChainAddrService.getWalletUserChainAddr(uid,accountId,chainId);
        if(walletUserChainAddrDb == null){
            String errorMsg = "user chain not exist.";
            log.error(errorMsg+",uid:{},param:{}",uid,JSON.toJSONString(chainCurrencySetParam));
            throw new Exception(errorMsg);
        }
        WalletUserCurrency walletUserCurrencyDb = userCurrencyService.getWalletUserCurrency(uid,accountId,walletUserChainAddrDb.getId(),currencyId);
        if(walletUserCurrencyDb == null){
            WalletCurrency walletCurrency = currencyService.getWalletCurrency(currencyId);
            WalletUserCurrency walletUserCurrency = new WalletUserCurrency();
            walletUserCurrency.setAccountId(accountId);
            walletUserCurrency.setAddressId(walletUserChainAddrDb.getId());
            walletUserCurrency.setCurrencyId(currencyId);
            walletUserCurrency.setUid(uid);
            walletUserCurrency.setCurrency(walletCurrency.getCurrencyCode());
            walletUserCurrency.setCtime(curDate);
            result = userCurrencyService.insert(walletUserCurrency);
        } else {
            log.info("currency has exist,uid:{},param:{}",uid,JSON.toJSONString(chainCurrencySetParam));
            result = true;
        }
        return result;
    }

    public Boolean userChainCurrencyDel(Long uid, ChainCurrencyDelParam chainCurrencyDelParam, String exchLang) throws Exception{
        Long accountId = Long.parseLong(chainCurrencyDelParam.getAccountId());
        Long chainId = chainCurrencyDelParam.getChainId();
        Long userCurrencyId = chainCurrencyDelParam.getUserCurrencyId();
        Boolean result = false;
        WalletUserCurrency walletUserCurrency = userCurrencyService.getWalletUserCurrency(userCurrencyId);
        if(walletUserCurrency == null){
            String errorMsg = "user Currency not exist.";
            log.error(errorMsg+",uid:{},param:{}",uid,JSON.toJSONString(chainCurrencyDelParam));
            throw new Exception(errorMsg);
        }
        WalletUserChainAddr walletUserChainAddrDb = walletUserChainAddrService.getWalletUserChainAddr(walletUserCurrency.getAddressId());
        if(walletUserChainAddrDb == null){
            String errorMsg = "user chain not exist.";
            log.error(errorMsg+",uid:{},param:{}",uid,JSON.toJSONString(chainCurrencyDelParam));
            throw new Exception(errorMsg);
        }
        if(walletUserChainAddrDb.getChainId().longValue() == chainId.longValue() && walletUserChainAddrDb.getAccountId().longValue() == accountId.longValue()){
            result = userCurrencyService.delete(userCurrencyId);
        }
        return result;
    }
}
