package com.turing.wallet.mapper;

import com.turing.wallet.model.WalletCurrency;
import com.turing.wallet.model.WalletCurrencyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletCurrencyMapper {
    long countByExample(WalletCurrencyExample example);

    int deleteByExample(WalletCurrencyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WalletCurrency record);

    int insertSelective(WalletCurrency record);

    List<WalletCurrency> selectByExample(WalletCurrencyExample example);

    WalletCurrency selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WalletCurrency record, @Param("example") WalletCurrencyExample example);

    int updateByExample(@Param("record") WalletCurrency record, @Param("example") WalletCurrencyExample example);

    int updateByPrimaryKeySelective(WalletCurrency record);

    int updateByPrimaryKey(WalletCurrency record);
}