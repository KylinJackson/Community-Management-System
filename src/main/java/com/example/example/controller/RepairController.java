package com.example.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.example.domain.Repair;
import com.example.example.service.RepairService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/repair")
public class RepairController {
    @Resource
    private RepairService repairService;

    @PostMapping("/add")
    @ResponseBody
    public JSONObject add(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        Long userId = receive.getLong("userId");
        String title = receive.getString("title");
        String content = receive.getString("content");
        String progress = "待处理";
        Date addTime = new Date();
        Repair repair = new Repair();
        repair.setUserId(userId);
        repair.setTitle(title);
        repair.setContent(content);
        repair.setProgress(progress);
        repair.setAddTime(addTime);
        repairService.insert(repair);
        send.put("status", 1);
        return send;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public JSONObject delete(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Repair repair = new Repair();
        repairService.delete(repair);
        send.put("status", 1);
        return send;
    }

    @PostMapping("/get")
    @ResponseBody
    public JSONObject get(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Repair repair = new Repair();
        if (repairService.selectOne(repair)) {
            send.put("status", 1);
            send.put("repair", repair);
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
        Repair repair = new Repair();
        List<Repair> repairList = repairService.select(repair);
        if (repairList.isEmpty()) {
            send.put("status", 0);
            send.put("error", "No found.");
        } else {
            send.put("status", 1);
            send.put("repairList", repairList);
        }
        return send;
    }

    @PutMapping("/update")
    @ResponseBody
    public JSONObject update(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Repair repair = new Repair();
        if (repairService.selectOne(repair)) {
            // set content
            repairService.updateById(repair);
            send.put("status", 1);
        } else {
            send.put("status", 0);
            send.put("error", "No found.");
        }
        return send;
    }
}