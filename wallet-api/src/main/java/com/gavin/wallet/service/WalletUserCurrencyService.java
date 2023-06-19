package com.turing.wallet.service;

import com.turing.wallet.mapper.WalletUserCurrencyMapper;
import com.turing.wallet.model.WalletUserCurrency;
import com.turing.wallet.model.WalletUserCurrencyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.turing.wallet.constants.Const.INT_0;


@Service
public class WalletUserCurrencyService {

    @Autowired
    private WalletUserCurrencyMapper walletCurrencyMapper;

    @Autowired
    private WalletUserChainAddrService addrService;

    @Autowired
    private WalletChainService chainService;

    @Autowired
    private WalletCurrencyService currencyService;

    public WalletUserCurrency getWalletUserCurrency(Long id) {
        return walletCurrencyMapper.selectByPrimaryKey(id);
    }

    public boolean insert(WalletUserCurrency walletCurrency) {
        int result = walletCurrencyMapper.insertSelective(walletCurrency);
        return result > INT_0 ? true : false;
    }

    public boolean updateWalletUserCurrency(WalletUserCurrency walletCurrency) {
        int result = walletCurrencyMapper.updateByPrimaryKeySelective(walletCurrency);
        return result > INT_0 ? true : false;
    }

    public WalletUserCurrency getWalletUserCurrencyByInvitedUid(Long uid) {
        WalletUserCurrencyExample tInviteRecordExample = new WalletUserCurrencyExample();
        tInviteRecordExample.createCriteria(); //.andFUidEqualTo(uid)
        List<WalletUserCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public List<WalletUserCurrency> queryWalletUserCurrencyList() {
        WalletUserCurrencyExample tInviteRecordExample = new WalletUserCurrencyExample();
        //tInviteRecordExample.setOrderByClause(" id desc ");
        List<WalletUserCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords;
    }

    public List<WalletUserCurrency> queryWalletUserCurrencyList(List<Long> idList) {
        WalletUserCurrencyExample userCurrencyExample = new WalletUserCurrencyExample();
        userCurrencyExample.createCriteria().andIdIn(idList);
        List<WalletUserCurrency> userCurrencyList = walletCurrencyMapper.selectByExample(userCurrencyExample);
        if (CollectionUtils.isEmpty(userCurrencyList)) {
            return null;
        }
        return userCurrencyList;
    }

    public List<WalletUserCurrency> queryWalletUserCurrencyListByAddrIds(List<Long> addrIdList) {
        WalletUserCurrencyExample userCurrencyExample = new WalletUserCurrencyExample();
        userCurrencyExample.createCriteria().andAddressIdIn(addrIdList);
        List<WalletUserCurrency> userCurrencyList = walletCurrencyMapper.selectByExample(userCurrencyExample);
        if (CollectionUtils.isEmpty(userCurrencyList)) {
            return null;
        }
        return userCurrencyList;
    }

    public List<WalletUserCurrency> queryWalletUserCurrencyList(Long userId,Long accountId) {
        WalletUserCurrencyExample walletCurrencyExample = new WalletUserCurrencyExample();
        walletCurrencyExample.createCriteria().andUidEqualTo(userId).andAccountIdEqualTo(accountId);
        List<WalletUserCurrency> walletCurrencyList = walletCurrencyMapper.selectByExample(walletCurrencyExample);
        if (CollectionUtils.isEmpty(walletCurrencyList)) {
            return null;
        }
        return walletCurrencyList;
    }

    public WalletUserCurrency getWalletUserCurrency(Integer day) {
        WalletUserCurrencyExample tInviteRecordExample = new WalletUserCurrencyExample();
        //tInviteRecordExample.createCriteria().andFDiffDayEqualTo(day);
        List<WalletUserCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public WalletUserCurrency getLastWalletUserCurrency() {
        WalletUserCurrencyExample tInviteRecordExample = new WalletUserCurrencyExample();
        tInviteRecordExample.setOrderByClause(" f_diff_day desc ");
        List<WalletUserCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public WalletUserCurrency getWalletUserCurrency(Long uid, Long accountId, Long addressId,Long currencyId) {
        WalletUserCurrencyExample walletUserCurrencyExample = new WalletUserCurrencyExample();
        walletUserCurrencyExample.createCriteria().andUidEqualTo(uid).andAccountIdEqualTo(accountId).andAddressIdEqualTo(addressId).andCurrencyIdEqualTo(currencyId);
        List<WalletUserCurrency> tInviteRecords = walletCurrencyMapper.selectByExample(walletUserCurrencyExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public Boolean delete(Long userCurrencyId) {
        int result = walletCurrencyMapper.deleteByPrimaryKey(userCurrencyId);
        return result > INT_0 ? true : false;
    }
}
