package com.example.example.service;

import com.example.example.domain.User;
import com.example.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public void insert(User user) {
        userMapper.insert(user);
    }

    public boolean selectOne(User user) {
        User tmp = userMapper.selectOne(user);
        if (tmp != null) {
            user.update(tmp);
            return true;
        } else {
            return false;
        }
    }

    public List<User> select(User user) {
        return userMapper.select(user);
    }

    public void delete(User user) {
        userMapper.delete(user);
    }

    public void updateById(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
