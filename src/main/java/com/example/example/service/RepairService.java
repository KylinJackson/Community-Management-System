package com.example.example.service;

import com.example.example.domain.Repair;
import com.example.example.mapper.RepairMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepairService {
    @Resource
    private RepairMapper repairMapper;

    public void insert(Repair repair) {
        repairMapper.insert(repair);
    }

    public boolean selectOne(Repair repair) {
        Repair tmp = repairMapper.selectOne(repair);
        if (tmp != null) {
            repair.update(tmp);
            return true;
        } else {
            return false;
        }
    }

    public List<Repair> select(Repair repair) {
        return repairMapper.select(repair);
    }

    public void delete(Repair repair) {
        repairMapper.delete(repair);
    }

    public void updateById(Repair repair) {
        repairMapper.updateByPrimaryKey(repair);
    }

    public List<Repair> selectAll() {
        return repairMapper.selectAll();
    }
}
