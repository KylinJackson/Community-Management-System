package com.example.example.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private Long residentId;
    private String gender;
    private String phone;
    private String email;
    private String token;

    public void update(User user) {
        id = user.id;
        nickname = user.nickname;
        username = user.username;
        password = user.password;
        residentId = user.residentId;
        gender = user.gender;
        phone = user.phone;
        email = user.email;
        token = user.token;
    }
}