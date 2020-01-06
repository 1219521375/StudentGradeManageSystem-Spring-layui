package com.example.demo.service;

import com.example.demo.bean.tool.MyGrade;

import java.util.List;

public interface MyGradeService {
    public List<MyGrade> GetAllMyGrade();
    public List<MyGrade> GetMyGradeBySno(String sno);
}
