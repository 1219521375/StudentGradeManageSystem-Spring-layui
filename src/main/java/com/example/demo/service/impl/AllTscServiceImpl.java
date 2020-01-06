package com.example.demo.service.impl;

import com.example.demo.bean.tool.AllTsc;
import com.example.demo.dao.AllTscMapper;
import com.example.demo.service.AllTscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllTscServiceImpl implements AllTscService {

    @Autowired
    private AllTscMapper allTscMapper;

    @Override
    public List<AllTsc> selectAll() {
        return allTscMapper.selectAll();
    }

    @Override
    public List<AllTsc> selectByTno(String tno) {
        return allTscMapper.selectByTno(tno);
    }

    @Override
    public List<AllTsc> selectByCno(String cno) {
        return allTscMapper.selectByCno(cno);
    }

    @Override
    public List<AllTsc> selectBySno(String sno) {
        return allTscMapper.selectBySno(sno);
    }

    @Override
    public List<AllTsc> selectByCterm(String cterm) {
        return allTscMapper.selectByCterm(cterm);
    }
}
