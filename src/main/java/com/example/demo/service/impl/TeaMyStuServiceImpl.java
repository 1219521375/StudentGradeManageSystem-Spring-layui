package com.example.demo.service.impl;

import com.example.demo.bean.tool.TeaMyStu;
import com.example.demo.dao.TeaMyStuMapper;
import com.example.demo.service.TeaMyStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaMyStuServiceImpl implements TeaMyStuService {

    @Autowired
    private TeaMyStuMapper teaMyStuMapper;


    @Override
    public List<TeaMyStu> GetTeaMyStuByTno(String tno) {
        return teaMyStuMapper.selectByPrimaryKey(tno);
    }
}
