package com.example.demo.service.impl;

import com.example.demo.bean.Teacher;
import com.example.demo.dao.TeacherMapper;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int InsertTeacher(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public int DeleteTeacherByPrimaryKey(String tno) {
        return teacherMapper.deleteByPrimaryKey(tno);
    }

    @Override
    public int UpdateTeacher(Teacher teacher) {
        return teacherMapper.updateByPrimaryKey(teacher);
    }

    @Override
    public Teacher GetTeacherByPrimaryKey(String tno) {
        return teacherMapper.selectByPrimaryKey(tno);
    }

    @Override
    public List<Teacher> GetAllTeacher() {
        return teacherMapper.selectAll();
    }
}
