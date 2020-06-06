package com.example.example.mapper;

import com.example.example.domain.Resident;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Mapper
public interface ResidentMapper extends BaseMapper<Resident>, MySqlMapper<Resident> {
}
