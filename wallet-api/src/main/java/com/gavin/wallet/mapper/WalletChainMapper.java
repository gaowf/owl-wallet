package com.turing.wallet.mapper;

import com.turing.wallet.model.WalletChain;
import com.turing.wallet.model.WalletChainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletChainMapper {
    long countByExample(WalletChainExample example);

    int deleteByExample(WalletChainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WalletChain record);

    int insertSelective(WalletChain record);

    List<WalletChain> selectByExample(WalletChainExample example);

    WalletChain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WalletChain record, @Param("example") WalletChainExample example);

    int updateByExample(@Param("record") WalletChain record, @Param("example") WalletChainExample example);

    int updateByPrimaryKeySelective(WalletChain record);

    int updateByPrimaryKey(WalletChain record);
}