package com.example.demo.service;

import com.example.demo.bean.TC;

import java.util.List;

public interface TCService {
    public int InsertTC(TC tc);

    public int DeleteTCByPrimaryKey(String tno,String cno,String cterm);

    public int UpdateTC(TC tc);

    public TC GetTCByPrimaryKey(String tno,String cno,String cterm);

    public List<TC> GetAllTC();
}
