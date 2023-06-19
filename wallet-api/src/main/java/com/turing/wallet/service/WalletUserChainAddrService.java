package com.turing.wallet.service;

import com.turing.wallet.mapper.WalletUserChainAddrMapper;
import com.turing.wallet.model.WalletUserChainAddr;
import com.turing.wallet.model.WalletUserChainAddrExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.turing.wallet.constants.Const.INT_0;


@Service
public class WalletUserChainAddrService {

    @Autowired
    private WalletUserChainAddrMapper walletUserChainAddrMapper;

    public WalletUserChainAddr getWalletUserChainAddr(Long id) {
        return walletUserChainAddrMapper.selectByPrimaryKey(id);
    }

    public boolean insert(WalletUserChainAddr walletUserChainAddr) {
        int result = walletUserChainAddrMapper.insertSelective(walletUserChainAddr);
        return result > INT_0 ? true : false;
    }

    public boolean updateWalletUserChainAddr(WalletUserChainAddr walletUserChainAddr) {
        int result = walletUserChainAddrMapper.updateByPrimaryKeySelective(walletUserChainAddr);
        return result > INT_0 ? true : false;
    }

    public WalletUserChainAddr getWalletUserChainAddrByInvitedUid(Long uid) {
        WalletUserChainAddrExample tInviteRecordExample = new WalletUserChainAddrExample();
        tInviteRecordExample.createCriteria(); //.andFUidEqualTo(uid)
        List<WalletUserChainAddr> tInviteRecords = walletUserChainAddrMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public List<WalletUserChainAddr> queryWalletUserChainAddrList() {
        WalletUserChainAddrExample tInviteRecordExample = new WalletUserChainAddrExample();
        tInviteRecordExample.setOrderByClause(" f_id desc ");
        List<WalletUserChainAddr> tInviteRecords = walletUserChainAddrMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords;
    }

    public List<WalletUserChainAddr> queryWalletUserChainAddrList(List<Long> addrIdList) {
        WalletUserChainAddrExample walletUserChainAddrExample = new WalletUserChainAddrExample();
        walletUserChainAddrExample.createCriteria().andIdIn(addrIdList);
        List<WalletUserChainAddr> userChainAddrList = walletUserChainAddrMapper.selectByExample(walletUserChainAddrExample);
        if (CollectionUtils.isEmpty(userChainAddrList)) {
            return null;
        }
        return userChainAddrList;
    }

    public List<WalletUserChainAddr> queryWalletUserChainAddrList(List<Long> addrIdList,Long chainId) {
        WalletUserChainAddrExample walletUserChainAddrExample = new WalletUserChainAddrExample();
        WalletUserChainAddrExample.Criteria criteria = walletUserChainAddrExample.createCriteria();
        criteria.andIdIn(addrIdList);
        if(chainId != null){
            criteria.andChainIdEqualTo(chainId);
        }
        List<WalletUserChainAddr> userChainAddrList = walletUserChainAddrMapper.selectByExample(walletUserChainAddrExample);
        if (CollectionUtils.isEmpty(userChainAddrList)) {
            return null;
        }
        return userChainAddrList;
    }

    public List<WalletUserChainAddr> queryChainAddrList(List<Long> accountIdList,Long chainId) {
        WalletUserChainAddrExample walletUserChainAddrExample = new WalletUserChainAddrExample();
        WalletUserChainAddrExample.Criteria criteria = walletUserChainAddrExample.createCriteria();
        criteria.andAccountIdIn(accountIdList);
        if(chainId != null){
            criteria.andChainIdEqualTo(chainId);
        }
        List<WalletUserChainAddr> userChainAddrList = walletUserChainAddrMapper.selectByExample(walletUserChainAddrExample);
        if (CollectionUtils.isEmpty(userChainAddrList)) {
            return null;
        }
        return userChainAddrList;
    }

    public WalletUserChainAddr getWalletUserChainAddr(Integer day) {
        WalletUserChainAddrExample tInviteRecordExample = new WalletUserChainAddrExample();
        //tInviteRecordExample.createCriteria().andFDiffDayEqualTo(day);
        List<WalletUserChainAddr> tInviteRecords = walletUserChainAddrMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public WalletUserChainAddr getLastWalletUserChainAddr() {
        WalletUserChainAddrExample tInviteRecordExample = new WalletUserChainAddrExample();
        tInviteRecordExample.setOrderByClause(" f_diff_day desc ");
        List<WalletUserChainAddr> tInviteRecords = walletUserChainAddrMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public WalletUserChainAddr getWalletUserChainAddr(Long uid, Long accountId, Long chainId) {
        WalletUserChainAddrExample walletUserChainAddrExample = new WalletUserChainAddrExample();
        walletUserChainAddrExample.createCriteria().andUidEqualTo(uid).andAccountIdEqualTo(accountId).andChainIdEqualTo(chainId);
        List<WalletUserChainAddr> walletUserChainAddrList = walletUserChainAddrMapper.selectByExample(walletUserChainAddrExample);
        if (CollectionUtils.isEmpty(walletUserChainAddrList)) {
            return null;
        }
        return walletUserChainAddrList.get(INT_0);
    }
}
