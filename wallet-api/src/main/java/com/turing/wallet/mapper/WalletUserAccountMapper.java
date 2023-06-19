package com.turing.wallet.mapper;

import com.turing.wallet.model.WalletUserAccount;
import com.turing.wallet.model.WalletUserAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletUserAccountMapper {
    long countByExample(WalletUserAccountExample example);

    int deleteByExample(WalletUserAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WalletUserAccount record);

    int insertSelective(WalletUserAccount record);

    List<WalletUserAccount> selectByExample(WalletUserAccountExample example);

    WalletUserAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WalletUserAccount record, @Param("example") WalletUserAccountExample example);

    int updateByExample(@Param("record") WalletUserAccount record, @Param("example") WalletUserAccountExample example);

    int updateByPrimaryKeySelective(WalletUserAccount record);

    int updateByPrimaryKey(WalletUserAccount record);
}