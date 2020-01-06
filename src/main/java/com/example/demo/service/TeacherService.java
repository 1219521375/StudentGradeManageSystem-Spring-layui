package com.example.demo.service;

import com.example.demo.bean.Teacher;

import java.util.List;

public interface TeacherService {
    public int InsertTeacher(Teacher teacher);

    public int DeleteTeacherByPrimaryKey(String tno);

    public int UpdateTeacher(Teacher teacher);

    public Teacher GetTeacherByPrimaryKey(String tno);

    public List<Teacher> GetAllTeacher();
}
