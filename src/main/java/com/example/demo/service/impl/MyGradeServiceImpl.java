package com.example.demo.service.impl;

import com.example.demo.bean.tool.MyGrade;
import com.example.demo.dao.MyGradeMapper;
import com.example.demo.service.MyGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyGradeServiceImpl implements MyGradeService {

    @Autowired
    private MyGradeMapper myGradeMapper;

    @Override
    public List<MyGrade> GetAllMyGrade() {
        return myGradeMapper.selectAll();
    }

    @Override
    public List<MyGrade> GetMyGradeBySno(String sno) {
        return myGradeMapper.selectByPrimaryKey(sno);
    }
}
