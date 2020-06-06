package com.example.example.service;

import com.example.example.domain.Resident;
import com.example.example.mapper.ResidentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResidentService {
    @Resource
    private ResidentMapper residentMapper;

    public void insert(Resident resident) {
        residentMapper.insert(resident);
    }

    public boolean selectOne(Resident resident) {
        Resident tmp = residentMapper.selectOne(resident);
        if (tmp != null) {
            resident.update(tmp);
            return true;
        } else {
            return false;
        }
    }

    public List<Resident> select(Resident resident) {
        return residentMapper.select(resident);
    }

    public void delete(Resident resident) {
        residentMapper.delete(resident);
    }

    public void updateById(Resident resident) {
        residentMapper.updateByPrimaryKey(resident);
    }

    public List<Resident> selectAll() {
        return residentMapper.selectAll();
    }
}
