package com.turing.wallet.mapper;

import com.turing.wallet.model.UserSymbol;
import com.turing.wallet.model.UserSymbolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSymbolMapper {
    long countByExample(UserSymbolExample example);

    int deleteByExample(UserSymbolExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserSymbol record);

    int insertSelective(UserSymbol record);

    List<UserSymbol> selectByExample(UserSymbolExample example);

    UserSymbol selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserSymbol record, @Param("example") UserSymbolExample example);

    int updateByExample(@Param("record") UserSymbol record, @Param("example") UserSymbolExample example);

    int updateByPrimaryKeySelective(UserSymbol record);

    int updateByPrimaryKey(UserSymbol record);
}