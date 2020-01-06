package com.example.demo.service;

import com.example.demo.bean.Course;

import java.util.List;

public interface CourseService {
    public int InsertCourse(Course course);

    public int DeleteCourseByPrimaryKey(String cno);

    public int UpdateCourse(Course course);

    public Course GetCourseByPrimaryKey(String cno);

    public List<Course> GetAllCourse();


}
