package com.turing.wallet.mapper;

import com.turing.wallet.model.v2.common.ConfigLanguage;
import com.turing.wallet.model.v2.common.ConfigLanguageExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mac
 */
@Mapper
public interface ConfigLanguageMapper {

    List<ConfigLanguage> selectByExample(ConfigLanguageExample example);

}
