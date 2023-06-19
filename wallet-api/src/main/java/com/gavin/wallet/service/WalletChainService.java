package com.turing.wallet.service;

import com.turing.wallet.mapper.WalletChainMapper;
import com.turing.wallet.model.WalletChain;
import com.turing.wallet.model.WalletChainExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.turing.wallet.constants.Const.INT_0;


@Service
public class WalletChainService {

    @Autowired
    private WalletChainMapper walletChainMapper;

    public WalletChain getWalletChain(Long id) {
        return walletChainMapper.selectByPrimaryKey(id);
    }

    public boolean insert(WalletChain walletChain) {
        int result = walletChainMapper.insertSelective(walletChain);
        return result > INT_0 ? true : false;
    }

    public boolean updateWalletChain(WalletChain walletChain) {
        int result = walletChainMapper.updateByPrimaryKeySelective(walletChain);
        return result > INT_0 ? true : false;
    }

    public WalletChain getWalletChainByInvitedUid(Long uid) {
        WalletChainExample tInviteRecordExample = new WalletChainExample();
        tInviteRecordExample.createCriteria(); //.andFUidEqualTo(uid)
        List<WalletChain> tInviteRecords = walletChainMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public WalletChain getWalletChainByDefault() {
        WalletChainExample tInviteRecordExample = new WalletChainExample();
        tInviteRecordExample.createCriteria().andDefaultShowEqualTo(1);
        List<WalletChain> tInviteRecords = walletChainMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public List<WalletChain> queryWalletChainList() {
        WalletChainExample tInviteRecordExample = new WalletChainExample();
        tInviteRecordExample.setOrderByClause(" f_id desc ");
        List<WalletChain> tInviteRecords = walletChainMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords;
    }

    public List<WalletChain> queryWalletChainList(int state) {
        WalletChainExample tInviteRecordExample = new WalletChainExample();
        tInviteRecordExample.createCriteria().andStateEqualTo(state);
        //tInviteRecordExample.setOrderByClause(" f_id desc ");
        List<WalletChain> tInviteRecords = walletChainMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords;
    }

    public List<WalletChain> queryWalletChainList(List<Long> chainIdList) {
        WalletChainExample walletChainExample = new WalletChainExample();
        walletChainExample.createCriteria().andIdIn(chainIdList).andStateEqualTo(1);
        List<WalletChain> tInviteRecords = walletChainMapper.selectByExample(walletChainExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords;
    }

    public WalletChain getWalletChain(Integer day) {
        WalletChainExample tInviteRecordExample = new WalletChainExample();
        //tInviteRecordExample.createCriteria().andFDiffDayEqualTo(day);
        List<WalletChain> tInviteRecords = walletChainMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }

    public WalletChain getLastWalletChain() {
        WalletChainExample tInviteRecordExample = new WalletChainExample();
        tInviteRecordExample.setOrderByClause(" f_diff_day desc ");
        List<WalletChain> tInviteRecords = walletChainMapper.selectByExample(tInviteRecordExample);
        if (CollectionUtils.isEmpty(tInviteRecords)) {
            return null;
        }
        return tInviteRecords.get(INT_0);
    }
}
