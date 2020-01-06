package com.example.demo.service.impl;

import com.example.demo.bean.SC;
import com.example.demo.dao.SCMapper;
import com.example.demo.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SCServiceImpl implements SCService {

    @Autowired
    private SCMapper scMapper;


    @Override
    public int InsertSC(SC sc) {
        return scMapper.insert(sc);
    }

    @Override
    public int DeleteSCByPrimaryKey(String sno, String cno, String tno) {
        return scMapper.deleteByPrimaryKey(sno,cno,tno);
    }

    @Override
    public int UpdateSC(SC sc) {
        return scMapper.updateByPrimaryKey(sc);
    }

    @Override
    public SC GetSCByPrimaryKey(String sno, String cno, String tno) {
        return scMapper.selectByPrimaryKey(sno,cno,tno);
    }

    @Override
    public List<SC> GetAllSC() {
        return scMapper.selectAll();
    }
}
