package com.turing.wallet.mapper;

import com.turing.wallet.model.WalletUserChainAddr;
import com.turing.wallet.model.WalletUserChainAddrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletUserChainAddrMapper {
    long countByExample(WalletUserChainAddrExample example);

    int deleteByExample(WalletUserChainAddrExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WalletUserChainAddr record);

    int insertSelective(WalletUserChainAddr record);

    List<WalletUserChainAddr> selectByExample(WalletUserChainAddrExample example);

    WalletUserChainAddr selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WalletUserChainAddr record, @Param("example") WalletUserChainAddrExample example);

    int updateByExample(@Param("record") WalletUserChainAddr record, @Param("example") WalletUserChainAddrExample example);

    int updateByPrimaryKeySelective(WalletUserChainAddr record);

    int updateByPrimaryKey(WalletUserChainAddr record);
}