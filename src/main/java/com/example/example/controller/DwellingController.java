package com.example.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.example.domain.Dwelling;
import com.example.example.service.DwellingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/dwelling")
public class DwellingController {
    @Resource
    private DwellingService dwellingService;

    @PostMapping("/add")
    @ResponseBody
    public JSONObject add(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Dwelling dwelling = new Dwelling();
        dwellingService.insert(dwelling);
        send.put("status", 1);
        return send;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public JSONObject delete(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Dwelling dwelling = new Dwelling();
        dwellingService.delete(dwelling);
        send.put("status", 1);
        return send;
    }

    @PostMapping("/get")
    @ResponseBody
    public JSONObject get(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Dwelling dwelling = new Dwelling();
        if (dwellingService.selectOne(dwelling)) {
            send.put("status", 1);
            send.put("dwelling", dwelling);
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
        Dwelling dwelling = new Dwelling();
        List<Dwelling> dwellingList = dwellingService.select(dwelling);
        if (dwellingList.isEmpty()) {
            send.put("status", 0);
            send.put("error", "No found.");
        } else {
            send.put("status", 1);
            send.put("dwellingList", dwellingList);
        }
        return send;
    }

    @PutMapping("/update")
    @ResponseBody
    public JSONObject update(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Dwelling dwelling = new Dwelling();
        if (dwellingService.selectOne(dwelling)) {
            // set content
            dwellingService.updateById(dwelling);
            send.put("status", 1);
        } else {
            send.put("status", 0);
            send.put("error", "No found.");
        }
        return send;
    }
}