package com.example.example.mapper;

import com.example.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Mapper
public interface UserMapper extends BaseMapper<User>, MySqlMapper<User> {
}
