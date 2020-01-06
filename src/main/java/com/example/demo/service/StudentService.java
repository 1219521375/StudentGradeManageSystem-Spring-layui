package com.example.demo.service;

import com.example.demo.bean.Student;

import java.util.List;

public interface StudentService {
    public int InsertStudent(Student student);

    public int DeleteStudentByPrimaryKey(String sno);

    public int UpdateStudent(Student student);

    public Student GetStudentByPrimaryKey(String sno);

    public List<Student> GetAllStudent();
}
