package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.bean.Teacher;
import com.example.demo.bean.tool.User;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/user")
@RestController //标识为返回类型为Json的控制器
public class UserController {

    //自动注入服务类
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    //管理员admin admin and 教师

    //标识请求地址
    @RequestMapping("/login")
    public ResultObject<Teacher> getTeacher(User user, HttpServletRequest request) {
        //查询用户列表
        int type = Integer.parseInt(user.getType());
        Teacher teacher = teacherService.GetTeacherByPrimaryKey(user.getUserName());
        ResultObject<Teacher> rs=new ResultObject<Teacher>();
        System.out.println(user.toString());
        if(teacher == null){
            rs.setCode(Constant.FAILURE_RETUEN_CODE);
            //提示
            rs.setMsg("没有该用户！");
        }else{
            if(type == 1){ //教师
                if(teacher.getTpassword().equals(user.getPassword())){
                    //状态码
                    rs.setCode(Constant.SUCCESS_RETUEN_CODE);
                    request.getSession().setAttribute("teacher", teacher);
                    //提示
                    rs.setMsg("登录成功");
                }else{
                    rs.setCode(Constant.FAILURE_RETUEN_CODE);
                    //提示
                    rs.setMsg("登录失败！账号或密码错误");
                }
            }else if(type == 3){//管理员
                if(teacher.getTpassword().equals(user.getPassword())&&user.getUserName().equals("admin")){
                    //状态码
                    rs.setCode(Constant.SUCCESS_RETUEN_CODE);
                    request.getSession().setAttribute("admin", teacher);
                    //提示
                    rs.setMsg("登录成功");
                }else{
                    rs.setCode(Constant.FAILURE_RETUEN_CODE);
                    //提示
                    rs.setMsg("非法用户！");
                }
            }
        }
        rs.setData(teacher);
        return rs;
    }
    @RequestMapping("/loginOut")
    public ResultObject<Object> loginOut(HttpServletRequest request) {
        //查询用户列表
        ResultObject<Object> rs=new ResultObject<Object>();
        request.getSession().removeAttribute("admin");
        //数据
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("退出成功");
        return rs;
    }

    //学生登录请求
    //标识请求地址
    @RequestMapping("/studentLogin")
    public ResultObject<Student> studentLogin(User user, HttpServletRequest request) {
        //查询用户列表
        System.out.println(user.getType() + user.getUserName() + "   " + user.getPassword());
        Student student=studentService.GetStudentByPrimaryKey(user.getUserName());
        ResultObject<Student> rs =new ResultObject<Student>();

        if(student==null) {
            //状态码
            rs.setCode(Constant.FAILURE_RETUEN_CODE);
            //提示
            rs.setMsg("登录失败,查无此人");
        }else {
            //状态码
            if (student.getSpassword().equals(user.getPassword())){
                rs.setCode(Constant.SUCCESS_RETUEN_CODE);
                request.getSession().setAttribute("student", student);
                //提示
                rs.setMsg("登录成功");
            }else{
                rs.setCode(Constant.FAILURE_RETUEN_CODE);
                //提示
                rs.setMsg("登录失败，密码错误！");
            }

        }
        //数据
        rs.setData(student);
        return rs;
    }
    @RequestMapping("/studentloginOut")
    public ResultObject<Object> studentloginOut(HttpServletRequest request) {
        //查询用户列表
        ResultObject<Object> rs=new ResultObject<Object>();
        request.getSession().removeAttribute("student");
        //数据
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("退出成功");
        return rs;
    }



}