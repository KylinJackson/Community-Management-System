package com.example.example.mapper;

import com.example.example.domain.Repair;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Mapper
public interface RepairMapper extends BaseMapper<Repair>, MySqlMapper<Repair> {
}
