package com.example.demo.service.impl;

import com.example.demo.bean.tool.CourseChoose;
import com.example.demo.dao.CourseChooseMapper;
import com.example.demo.service.CourseChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseChooseServiceImpl implements CourseChooseService {

    @Autowired
    CourseChooseMapper courseChooseMapper;


    @Override
    public List<CourseChoose> GetAllCourseChoose() {
        return courseChooseMapper.selectAll();
    }
}
