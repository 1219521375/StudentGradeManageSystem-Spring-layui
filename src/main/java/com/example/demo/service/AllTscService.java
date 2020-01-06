package com.example.demo.service;

import com.example.demo.bean.tool.AllTsc;

import java.util.List;

public interface AllTscService {

    List<AllTsc> selectAll();

    List<AllTsc> selectByTno(String tno);
    List<AllTsc> selectByCno(String cno);
    List<AllTsc> selectBySno(String sno);
    List<AllTsc> selectByCterm(String cterm);
}
