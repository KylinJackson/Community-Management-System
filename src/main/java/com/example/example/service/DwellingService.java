package com.example.example.service;

import com.example.example.domain.Dwelling;
import com.example.example.mapper.DwellingMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DwellingService {
    @Resource
    private DwellingMapper dwellingMapper;

    public void insert(Dwelling dwelling) {
        dwellingMapper.insert(dwelling);
    }

    public boolean selectOne(Dwelling dwelling) {
        Dwelling tmp = dwellingMapper.selectOne(dwelling);
        if (tmp != null) {
            dwelling.update(tmp);
            return true;
        } else {
            return false;
        }
    }

    public List<Dwelling> select(Dwelling dwelling) {
        return dwellingMapper.select(dwelling);
    }

    public void delete(Dwelling dwelling) {
        dwellingMapper.delete(dwelling);
    }

    public void updateById(Dwelling dwelling) {
        dwellingMapper.updateByPrimaryKey(dwelling);
    }

    public List<Dwelling> selectAll() {
        return dwellingMapper.selectAll();
    }
}
