package com.example.example.mapper;

import com.example.example.domain.Dwelling;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Mapper
public interface DwellingMapper extends BaseMapper<Dwelling>, MySqlMapper<Dwelling> {
}
