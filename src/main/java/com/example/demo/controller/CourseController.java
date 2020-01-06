package com.example.demo.controller;


import com.example.demo.bean.SC;
import com.example.demo.bean.Student;
import com.example.demo.bean.Teacher;
import com.example.demo.bean.tool.AllTsc;
import com.example.demo.bean.tool.CourseChoose;
import com.example.demo.bean.tool.TeaMyStu;
import com.example.demo.service.*;
import com.example.demo.utils.Constant;
import com.example.demo.utils.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/course")
@RestController
public class CourseController {

    @Autowired
    private CourseChooseService courseChooseService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private SCService scService;

    @Autowired
    private AllTscService allTscService;

    @Autowired
    private TeaMyStuService teaMyStuService;

    @RequestMapping("/getTeaCourse")
    public ResultObject<List<AllTsc>> getTeaCourse(HttpServletRequest request){
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        ResultObject<List<AllTsc>> rs = new ResultObject<List<AllTsc>>();
        List<AllTsc> list = allTscService.selectByTno(teacher.getTno());
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.get(0).getCname());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }

    @RequestMapping("/getMyTeaStudent")
    public ResultObject<List<TeaMyStu>> getMyTeaStudent(HttpServletRequest request){
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        ResultObject<List<TeaMyStu>> rs = new ResultObject<List<TeaMyStu>>();
        List<TeaMyStu> list = teaMyStuService.GetTeaMyStuByTno(teacher.getTno());
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.get(0).getCname());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }

    @RequestMapping("/updateStuGrade")
    public ResultObject<List<TeaMyStu>> updateStuGrade(HttpServletRequest request,@RequestBody Map<String,Object> jsonData){
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        String sno = jsonData.get("sno").toString();
        String cno = jsonData.get("cno").toString();
        String cgrade = jsonData.get("cgrade").toString();
        System.out.println(sno + "  " + cno + "  " + cgrade);
        ResultObject<List<TeaMyStu>> rs = new ResultObject<List<TeaMyStu>>();
        List<TeaMyStu> list = teaMyStuService.GetTeaMyStuByTno(teacher.getTno());
        SC sc = new SC();
        sc.setCno(cno);
        sc.setSno(sno);
        sc.setTno(teacher.getTno());
        sc.setCgrade(Float.parseFloat(cgrade));
        scService.UpdateSC(sc);
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.get(0).getCname());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }

    @RequestMapping("/getTeaStuUpGrade")
    public ResultObject<List<TeaMyStu>> getTeaStuUpGrade(HttpServletRequest request){
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        ResultObject<List<TeaMyStu>> rs = new ResultObject<List<TeaMyStu>>();
        List<TeaMyStu> list = teaMyStuService.GetTeaMyStuByTno(teacher.getTno());
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.get(0).getCname());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }

    @RequestMapping("/getMyCourse")
    public ResultObject<List<AllTsc>> getMyCourse(HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        ResultObject<List<AllTsc>> rs = new ResultObject<List<AllTsc>>();
        List<AllTsc> list = allTscService.selectBySno(student.getSno());
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.get(0).getCname());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }

    @RequestMapping("/doChoose")
    public ResultObject<SC> doChoose(HttpServletRequest request,CourseChoose courseChoose){
        Student student = (Student) request.getSession().getAttribute("student");

        ResultObject<SC> rs = new ResultObject<SC>();
        //插入 sno cno tno 到选课表sc
        SC sc = new SC();
        sc.setSno(student.getSno());
        sc.setCno(courseChoose.getCno());
        sc.setTno(courseChoose.getTno());
        scService.InsertSC(sc);
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(sc);
        System.out.println("插入" + courseChoose.getCname());
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/getChoosefulCourse")
    public ResultObject<List<CourseChoose>> getChoosefulCourse(HttpServletRequest request, @RequestParam("limit") int limit) {
        Student student = (Student) request.getSession().getAttribute("student");
        List<AllTsc> myCourses = allTscService.selectBySno(student.getSno());
        ResultObject<List<CourseChoose>> rs=new ResultObject<List<CourseChoose>>();
        List<CourseChoose> list=courseChooseService.GetAllCourseChoose();
        List<CourseChoose> remo = new ArrayList<>();
        for (CourseChoose course :
                list) {
            for (AllTsc c :
                    myCourses) {
                if(course.getCno().equals(c.getCno())){
                    remo.add(course);
                    break;
                }
            }
        }
        for (CourseChoose c :
                remo) {
            list.remove(c);
        }
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.get(0).getCmaxnum());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }


}
