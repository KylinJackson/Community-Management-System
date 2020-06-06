package com.example.example.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "repair")
public class Repair {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String progress;
    private Date addTime;
    private Date updateTime;

    public void update(Repair repair) {
        id = repair.id;
        userId = repair.userId;
        title = repair.title;
        content = repair.content;
        progress = repair.progress;
        addTime = repair.addTime;
        updateTime = repair.updateTime;
    }
}
