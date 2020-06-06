package com.example.example.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "dwelling")
public class Dwelling {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String nickname;
    private Long buildingNumber;
    private Long unitNumber;
    private Long roomNumber;
    private Long numberOfPeople;
    private Double area;
    private Date addTime;
    private Date updateTime;

    public void update(Dwelling dwelling) {
        id = dwelling.id;
        nickname = dwelling.nickname;
        buildingNumber = dwelling.buildingNumber;
        unitNumber = dwelling.unitNumber;
        numberOfPeople = dwelling.numberOfPeople;
        area = dwelling.area;
        addTime = dwelling.addTime;
        updateTime = dwelling.updateTime;
    }
}


