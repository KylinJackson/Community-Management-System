package com.example.example.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "resident")
public class Resident {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private String phone;
    private Long buildingNumber;
    private Long unitNumber;
    private Long roomNumber;

    public void update(Resident resident) {
        id = resident.id;
        name = resident.name;
        phone = resident.phone;
        buildingNumber = resident.buildingNumber;
        unitNumber = resident.unitNumber;
        roomNumber = resident.roomNumber;
    }
}
