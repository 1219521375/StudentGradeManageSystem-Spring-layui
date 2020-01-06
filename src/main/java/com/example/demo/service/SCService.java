package com.example.demo.service;

import com.example.demo.bean.SC;

import java.util.List;

public interface SCService {
    public int InsertSC(SC sc);

    public int DeleteSCByPrimaryKey(String sno,String cno,String tno);

    public int UpdateSC(SC sc);

    public SC GetSCByPrimaryKey(String sno, String cno, String tno);

    public List<SC> GetAllSC();
}
