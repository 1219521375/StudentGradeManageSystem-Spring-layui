package com.example.demo.service.impl;

import com.example.demo.bean.TC;
import com.example.demo.dao.TCMapper;
import com.example.demo.service.TCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TCServiceImpl implements TCService {

    @Autowired
    private TCMapper tcMapper;

    @Override
    public int InsertTC(TC tc) {
        return tcMapper.insert(tc);
    }

    @Override
    public int DeleteTCByPrimaryKey(String tno, String cno, String cterm) {
        return tcMapper.deleteByPrimaryKey(tno,cno,cterm);
    }

    @Override
    public int UpdateTC(TC tc) {
        return tcMapper.updateByPrimaryKey(tc);
    }

    @Override
    public TC GetTCByPrimaryKey(String tno, String cno, String cterm) {
        return tcMapper.selectByPrimaryKey(tno,cno,cterm);
    }

    @Override
    public List<TC> GetAllTC() {
        return tcMapper.selectAll();
    }
}
