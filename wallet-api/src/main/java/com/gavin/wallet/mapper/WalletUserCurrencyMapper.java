package com.turing.wallet.mapper;

import com.turing.wallet.model.WalletUserCurrency;
import com.turing.wallet.model.WalletUserCurrencyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletUserCurrencyMapper {
    long countByExample(WalletUserCurrencyExample example);

    int deleteByExample(WalletUserCurrencyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WalletUserCurrency record);

    int insertSelective(WalletUserCurrency record);

    List<WalletUserCurrency> selectByExample(WalletUserCurrencyExample example);

    WalletUserCurrency selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WalletUserCurrency record, @Param("example") WalletUserCurrencyExample example);

    int updateByExample(@Param("record") WalletUserCurrency record, @Param("example") WalletUserCurrencyExample example);

    int updateByPrimaryKeySelective(WalletUserCurrency record);

    int updateByPrimaryKey(WalletUserCurrency record);
}