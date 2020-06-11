package com.example.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.example.domain.User;
import com.example.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public JSONObject add(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        User user = new User();
        userService.insert(user);
        send.put("status", 1);
        return send;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public JSONObject delete(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        User user = new User();
        userService.delete(user);
        send.put("status", 1);
        return send;
    }

    @PostMapping("/get")
    @ResponseBody
    public JSONObject get(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        User user = new User();
        if (userService.selectOne(user)) {
            send.put("status", 1);
            send.put("user", user);
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
        User user = new User();
        List<User> userList = userService.select(user);
        if (userList.isEmpty()) {
            send.put("status", 0);
            send.put("error", "No found.");
        } else {
            send.put("status", 1);
            send.put("userList", userList);
        }
        return send;
    }

    @PutMapping("/update")
    @ResponseBody
    public JSONObject update(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        // receive content
        User user = new User();
        if (userService.selectOne(user)) {
            // set content
            userService.updateById(user);
            send.put("status", 1);
        } else {
            send.put("status", 0);
            send.put("error", "No found.");
        }
        return send;
    }

    @PostMapping("/login")
    @ResponseBody
    public JSONObject login(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        String username = receive.getString("username");
        String password = receive.getString("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (userService.selectOne(user)) {
            send.put("status", 1);
        } else {
            send.put("status", 0);
            send.put("errorMessage", "No found.");
        }
        return send;
    }

    @PostMapping("/register")
    @ResponseBody
    public JSONObject register(@RequestBody JSONObject receive) {
        JSONObject send = new JSONObject();
        String username = receive.getString("username");
        String password = receive.getString("password");
        User user = new User();
        user.setUsername(username);

        if (userService.selectOne(user)) {
            // user exist
            send.put("status", 0);
            send.put("errorMessage", "User already exist.");
            return send;
        }
        user.setPassword(password);
        userService.insert(user);
        send.put("status", 1);
        return send;
    }
}