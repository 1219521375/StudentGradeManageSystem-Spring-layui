package com.example.demo.service;

import com.example.demo.bean.tool.TeaMyStu;

import java.util.List;

public interface TeaMyStuService {
    public List<TeaMyStu> GetTeaMyStuByTno(String tno);
}
