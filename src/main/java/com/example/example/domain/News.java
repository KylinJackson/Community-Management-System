package com.example.example.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "news")
public class News {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String type;
    private String title;
    private String picture;
    private String pageview;
    private String announcer;
    private Date releaseTime;
    private String status;
    private String overview;
    private String content;

    public void update(News news) {
        id = news.id;
        type = news.type;
        title = news.title;
        picture = news.picture;
        pageview = news.pageview;
        announcer = news.announcer;
        releaseTime = news.releaseTime;
        status = news.status;
        overview = news.overview;
        content = news.content;
    }
}