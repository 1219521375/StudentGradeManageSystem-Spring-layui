package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.bean.tool.MyGrade;
import com.example.demo.service.MyGradeService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/grade")
@RestController
public class GradeController {
    @Autowired
    private MyGradeService myGradeService;

    @RequestMapping("/getMyGrade")
    public ResultObject<List<MyGrade>> getMyGrade(HttpServletRequest request){
        System.out.println("222");
        Student student = (Student) request.getSession().getAttribute("student");
        ResultObject<List<MyGrade>> rs = new ResultObject<List<MyGrade>>();
        List<MyGrade> list = myGradeService.GetMyGradeBySno(student.getSno());
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(student.getSno() + "  " + list.size());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }

}
