package com.turing.wallet.service;

import com.turing.wallet.domain.ChainInfo;
import com.turing.wallet.domain.CurrencyDO;
import com.turing.wallet.domain.CurrencyInfo;
import com.turing.wallet.domain.PublicConfig;
import com.turing.wallet.mapper.WalletCurrencyMapper;
import com.turing.wallet.model.WalletChain;
import com.turing.wallet.model.WalletCurrency;
import com.turing.wallet.model.WalletCurrencyExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.turing.wallet.constants.Const.INT_0;


@Service
public class WalletCurrencyService {

    @Autowired
    private WalletCurrencyMapper walletCurrencyMapper;

    @Autowired
    private WalletChainService chainService;

    public WalletCurrency getWalletCurrency(Long id) {
        return walletCurrencyMapper.selectByPrimaryKey(id);
    }

    public boolean insert(WalletCurrency walletCurrency) {
        int result = walletCurrencyMapper.insertSelective(walletCurrency);
        return result > INT_0 ? true : false;
    }

    public boolean updateWalletCurrency(WalletCurrency walletCurrency) {
        int result = walletCurrencyMapper.updateByPrimaryKeySelective(walletCurrency);
        return result > INT_0 ? true : false;
    }

    public WalletCurrency getWalletCurrencyByInvitedUid(Long uid) {
        WalletCurrencyExample tInviteRecordExample = new WalletCurrencyExample();
        tInviteRecordExample.createCriteria(); //.andFUidEqualTo(uid)
        List<WalletCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public List<WalletCurrency> queryWalletCurrencyList() {
        WalletCurrencyExample walletCurrencyExample = new WalletCurrencyExample();
        walletCurrencyExample.createCriteria().andStateEqualTo(1).andCurrencyTypeNotEqualTo(2);
        List<WalletCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(walletCurrencyExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords;
    }

    public List<WalletCurrency> queryWalletCurrencyList(List<Long> chainIdList,int state) {
        WalletCurrencyExample walletCurrencyExample = new WalletCurrencyExample();
        walletCurrencyExample.createCriteria().andChainIdIn(chainIdList).andStateEqualTo(state).andCurrencyTypeNotEqualTo(2);
        List<WalletCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(walletCurrencyExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords;
    }

    public List<WalletCurrency> queryWalletCurrencyList(List<Long> chainIdList,Integer currencyType,int state) {
        WalletCurrencyExample walletCurrencyExample = new WalletCurrencyExample();
        walletCurrencyExample.createCriteria().andChainIdIn(chainIdList).andStateEqualTo(state).andCurrencyTypeEqualTo(currencyType);
        List<WalletCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(walletCurrencyExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords;
    }

    public List<WalletCurrency> queryWalletCurrencyList(List<Long> currencyIdList) {
        WalletCurrencyExample walletCurrencyExample = new WalletCurrencyExample();
        walletCurrencyExample.createCriteria().andStateEqualTo(1).andCurrencyTypeNotEqualTo(2).andIdIn(currencyIdList);
        List<WalletCurrency> walletCurrencyList = walletCurrencyMapper.selectByExample(walletCurrencyExample);
        if (CollectionUtils.isEmpty(walletCurrencyList)) {
            return null;
        }
        return walletCurrencyList;
    }

    public WalletCurrency getWalletCurrency(Integer day) {
        WalletCurrencyExample tInviteRecordExample = new WalletCurrencyExample();
        //tInviteRecordExample.createCriteria().andFDiffDayEqualTo(day);
        List<WalletCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public WalletCurrency getLastWalletCurrency() {
        WalletCurrencyExample tInviteRecordExample = new WalletCurrencyExample();
        tInviteRecordExample.setOrderByClause(" f_diff_day desc ");
        List<WalletCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public List<CurrencyDO> queryCurrencyDOList(String exchLang) {
        List<WalletCurrency> walletCurrencyList = queryWalletCurrencyList();
        if(CollectionUtils.isEmpty(walletCurrencyList)){
            return null;
        }
        List<Long> chainIdList =  walletCurrencyList.stream().map(WalletCurrency::getChainId).collect(Collectors.toList());
        List<WalletChain> walletChainList = chainService.queryWalletChainList(chainIdList);
        Map<Long, WalletChain> walletChainMap = walletChainList.stream().collect(Collectors.toMap(WalletChain::getId, a -> a,(k1, k2)->k1));
        List<CurrencyDO> currencyDOList = new ArrayList<>();
        for(WalletCurrency walletCurrency:walletCurrencyList){
            CurrencyDO currencyDO = new CurrencyDO();
            BeanUtils.copyProperties(walletCurrency,currencyDO);
            WalletChain walletChain = walletChainMap.get(walletCurrency.getChainId());
            if(walletChain != null){
                currencyDO.setChainIconAddress(walletChain.getIconAddress());
            }
            currencyDOList.add(currencyDO);
        }
        return currencyDOList;
    }

    public PublicConfig getPublicConfig(String exchLang) {
        List<WalletChain> walletChainList = chainService.queryWalletChainList(1);
        if(CollectionUtils.isEmpty(walletChainList)){
            return null;
        }
        List<Long> chainIdList =  walletChainList.stream().map(WalletChain::getId).collect(Collectors.toList());
        queryWalletCurrencyList(chainIdList,1);
        List<WalletCurrency> walletCurrencyList = queryWalletCurrencyList();
        PublicConfig publicConfig = getPublicConfigDo(walletChainList,walletCurrencyList);
        return publicConfig;
    }

    private PublicConfig getPublicConfigDo(List<WalletChain> walletChainList, List<WalletCurrency> walletCurrencyList) {
        PublicConfig publicConfig = new PublicConfig();
        List<ChainInfo> chainList = getChainList(walletChainList,walletCurrencyList);
        publicConfig.setChainList(chainList);
        return publicConfig;
    }

    private List<ChainInfo> getChainList(List<WalletChain> walletChainList, List<WalletCurrency> walletCurrencyList) {
        List<ChainInfo> chainList = new ArrayList<>();
        for(WalletChain walletChain:walletChainList){
            ChainInfo chainInfo = new ChainInfo();
            BeanUtils.copyProperties(walletChain,chainInfo);
            chainInfo.setChainId(walletChain.getId());
            chainInfo.setChainIconAddress(walletChain.getIconAddress());
            chainInfo.setChainName(!StringUtils.isEmpty(walletChain.getShowName())?walletChain.getShowName():walletChain.getName());
            if(!CollectionUtils.isEmpty(walletCurrencyList)){
                chainInfo.setCurrencyList(convertToCurrencyList(walletCurrencyList));
            }
            chainList.add(chainInfo);
        }
        return chainList;
    }

    private List<CurrencyInfo> convertToCurrencyList(List<WalletCurrency> walletCurrencyList) {
        List<CurrencyInfo> currencyInfoList = new ArrayList<>();
        for(WalletCurrency walletCurrency:walletCurrencyList){
            CurrencyInfo currencyInfo = new CurrencyInfo();
            BeanUtils.copyProperties(walletCurrency,currencyInfo);
            currencyInfoList.add(currencyInfo);
        }
        return currencyInfoList;
    }
}
