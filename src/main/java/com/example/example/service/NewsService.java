package com.example.example.service;

import com.example.example.domain.News;
import com.example.example.mapper.NewsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsService {
    @Resource
    private NewsMapper newsMapper;

    public void insert(News news) {
        newsMapper.insert(news);
    }

    public boolean selectOne(News news) {
        News tmp = newsMapper.selectOne(news);
        if (tmp != null) {
            news.update(tmp);
            return true;
        } else {
            return false;
        }
    }

    public List<News> select(News news) {
        return newsMapper.select(news);
    }

    public void delete(News news) {
        newsMapper.delete(news);
    }

    public void updateById(News news) {
        newsMapper.updateByPrimaryKey(news);
    }

    public List<News> selectAll() {
        return newsMapper.selectAll();
    }
}
