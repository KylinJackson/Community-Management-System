package com.example.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.example.domain.Resident;
import com.example.example.service.ResidentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/resident")
public class ResidentController {
    @Resource
    private ResidentService residentService;

    @PostMapping("/add")
    @ResponseBody
    public JSONObject add(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Resident resident = new Resident();
        residentService.insert(resident);
        send.put("status", 1);
        return send;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public JSONObject delete(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Resident resident = new Resident();
        residentService.delete(resident);
        send.put("status", 1);
        return send;
    }

    @PostMapping("/get")
    @ResponseBody
    public JSONObject get(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Resident resident = new Resident();
        if (residentService.selectOne(resident)) {
            send.put("status", 1);
            send.put("resident", resident);
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
        Resident resident = new Resident();
        List<Resident> residentList = residentService.select(resident);
        if (residentList.isEmpty()) {
            send.put("status", 0);
            send.put("error", "No found.");
        } else {
            send.put("status", 1);
            send.put("residentList", residentList);
        }
        return send;
    }

    @PutMapping("/update")
    @ResponseBody
    public JSONObject update(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        Resident resident = new Resident();
        if (residentService.selectOne(resident)) {
            // set content
            residentService.updateById(resident);
            send.put("status", 1);
        } else {
            send.put("status", 0);
            send.put("error", "No found.");
        }
        return send;
    }
}