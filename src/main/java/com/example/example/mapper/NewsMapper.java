package com.example.example.mapper;

import com.example.example.domain.News;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Mapper
public interface NewsMapper extends BaseMapper<News>, MySqlMapper<News> {
}
