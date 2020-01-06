package com.example.demo.service.impl;

import com.example.demo.bean.Student;
import com.example.demo.dao.StudentMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public int InsertStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int DeleteStudentByPrimaryKey(String sno) {
        return studentMapper.deleteByPrimaryKey(sno);
    }

    @Override
    public int UpdateStudent(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public Student GetStudentByPrimaryKey(String sno) {
        return studentMapper.selectByPrimaryKey(sno);
    }

    @Override
    public List<Student> GetAllStudent() {
        return studentMapper.selectAll();
    }
}
