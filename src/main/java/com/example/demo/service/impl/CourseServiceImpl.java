package com.example.demo.service.impl;

import com.example.demo.bean.Course;
import com.example.demo.dao.CourseMapper;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int InsertCourse(Course course) {
        return courseMapper.insert(course);
    }

    @Override
    public int DeleteCourseByPrimaryKey(String cno) {
        return courseMapper.deleteByPrimaryKey(cno);
    }

    @Override
    public int UpdateCourse(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public Course GetCourseByPrimaryKey(String cno) {
        return courseMapper.selectByPrimaryKey(cno);
    }

    @Override
    public List<Course> GetAllCourse() {
        return courseMapper.selectAll();
    }
}
