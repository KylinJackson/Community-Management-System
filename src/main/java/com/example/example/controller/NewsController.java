package com.example.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.example.domain.News;
import com.example.example.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService newsService;

    @PostMapping("/add")
    @ResponseBody
    public JSONObject add(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        News news = new News();
        newsService.insert(news);
        send.put("status", 1);
        return send;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public JSONObject delete(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        News news = new News();
        newsService.delete(news);
        send.put("status", 1);
        return send;
    }

    @PostMapping("/get")
    @ResponseBody
    public JSONObject get(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        News news = new News();
        if (newsService.selectOne(news)) {
            send.put("status", 1);
            send.put("news", news);
        } else {
            send.put("status", 0);
            send.put("error", "No found.");
        }
        return send;
    }

    @PostMapping("/getList")
    @ResponseBody
    public JSONObject getList(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        News news = new News();
        List<News> newsList = newsService.select(news);
        if (newsList.isEmpty()) {
            send.put("status", 0);
            send.put("error", "No found.");
        } else {
            send.put("status", 1);
            send.put("newsList", newsList);
        }
        return send;
    }

    @PutMapping("/update")
    @ResponseBody
    public JSONObject update(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        News news = new News();
        if (newsService.selectOne(news)) {
            // set content
            newsService.updateById(news);
            send.put("status", 1);
        } else {
            send.put("status", 0);
            send.put("error", "No found.");
        }
        return send;
    }
}
