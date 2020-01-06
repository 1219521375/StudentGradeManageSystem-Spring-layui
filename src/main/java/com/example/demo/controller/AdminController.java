package com.example.demo.controller;


import com.example.demo.bean.Course;
import com.example.demo.bean.Student;
import com.example.demo.bean.TC;
import com.example.demo.bean.Teacher;
import com.example.demo.bean.tool.AllTsc;
import com.example.demo.bean.tool.MyGrade;
import com.example.demo.service.*;
import com.example.demo.utils.Constant;
import com.example.demo.utils.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/admin")
@RestController //标识为返回类型为Json的控制器
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AllTscService allTscService;

    @Autowired
    private TCService tcService;

    @RequestMapping("/getAllStu")
    public ResultObject<List<Student>> getAllStu(HttpServletRequest request){
        ResultObject<List<Student>> rs = new ResultObject<List<Student>>();
        List<Student> list = studentService.GetAllStudent();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.size());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }

    @RequestMapping("/getTermCourse")
    public ResultObject<List<AllTsc>> getTermCourse(HttpServletRequest request){
        ResultObject<List<AllTsc>> rs = new ResultObject<List<AllTsc>>();
        List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.size());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }

    @RequestMapping("/getAllGrade")
    public ResultObject<List<AllTsc>> getAllGrade(HttpServletRequest request){
        ResultObject<List<AllTsc>> rs = new ResultObject<List<AllTsc>>();
        List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.size());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }

    @RequestMapping("/addStudent")
    public ResultObject<Student> addStudent(HttpServletRequest request,Student student){
        ResultObject<Student> rs = new ResultObject<Student>();
        int s = studentService.InsertStudent(student);
        System.out.println(student.getSname() + "   " + s );
        //List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(student);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/deleteStudent")
    public ResultObject<Student> deleteStudent(HttpServletRequest request,Student student){
        ResultObject<Student> rs = new ResultObject<Student>();
        int s = studentService.DeleteStudentByPrimaryKey(student.getSno());
        System.out.println(student.getSname() + "   " + s );
        //List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("删除成功");
        rs.setData(student);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/UpdateStudent")
    public ResultObject<Student> UpdateStudent(HttpServletRequest request,Student student){
        ResultObject<Student> rs = new ResultObject<Student>();
        int s = studentService.UpdateStudent(student);
        System.out.println(student.getSname() + "   " + s );
        //List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("更新成功");
        rs.setData(student);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/addTeacher")
    public ResultObject<Teacher> addTeacher(HttpServletRequest request,Teacher teacher){
        ResultObject<Teacher> rs = new ResultObject<Teacher>();
        int s = teacherService.InsertTeacher(teacher);
        System.out.println(teacher.getTname() + "   " + s );
        //List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(teacher);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/deleteTeacher")
    public ResultObject<Teacher> deleteTeacher(HttpServletRequest request,Teacher teacher){
        ResultObject<Teacher> rs = new ResultObject<Teacher>();
        int s = teacherService.DeleteTeacherByPrimaryKey(teacher.getTno());
        System.out.println(teacher.getTname() + "   " + s );
        //List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("删除成功");
        rs.setData(teacher);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/UpdateTeacher")
    public ResultObject<Teacher> UpdateTeachert(HttpServletRequest request,Teacher teacher){
        ResultObject<Teacher> rs = new ResultObject<Teacher>();
        int s = teacherService.UpdateTeacher(teacher);
        System.out.println(teacher.getTno() + "   " + s );
        //List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("更新成功");
        rs.setData(teacher);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/addCourse")
    public ResultObject<Course> addCourse(HttpServletRequest request,Course course){
        ResultObject<Course> rs = new ResultObject<Course>();
        int s = courseService.InsertCourse(course);
        System.out.println(course.getCname() + "   " + s );
        //List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(course);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/deleteCourse")
    public ResultObject<Course> deleteCourse(HttpServletRequest request,Course course){
        ResultObject<Course> rs = new ResultObject<Course>();
        int s = courseService.DeleteCourseByPrimaryKey(course.getCno());
        System.out.println(course.getCname() + "   " + s );
        //List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("删除成功");
        rs.setData(course);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/UpdateCourse")
    public ResultObject<Course> UpdateCourse(HttpServletRequest request,Course course){
        ResultObject<Course> rs = new ResultObject<Course>();
        int s = courseService.UpdateCourse(course);
        System.out.println(course.getCno() + "   " + s );
        //List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("更新成功");
        rs.setData(course);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/addCourseTerm")
        public ResultObject<TC> addCourseTerm(HttpServletRequest request,AllTsc allTsc){
        ResultObject<TC> rs = new ResultObject<TC>();
        TC tc = new TC();
        tc.setTno(allTsc.getTno());
        tc.setCno(allTsc.getCno());
        tc.setCmaxnum(allTsc.getCmaxnum());
        tc.setCstate(allTsc.getCstate());
        tc.setCterm(allTsc.getCterm());
        int s = tcService.InsertTC(tc);
        //System.out.println(tc.getCno() + "   " +  tc.getCmaxnum() + "   " +  tc.getCstate());
        //System.out.println(tc.getCname());
        System.out.println(tc.getCstate() + "  " + s);
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(tc);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/deleteCourseTerm")
    public ResultObject<TC> deleteCourseTerm(HttpServletRequest request,TC tc){
        ResultObject<TC> rs = new ResultObject<TC>();
        int s = tcService.DeleteTCByPrimaryKey(tc.getTno(),tc.getCno(),tc.getCterm());
        System.out.println(tc.getTno() + "   " + s );
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("删除成功");
        rs.setData(tc);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/UpdateCourseTerm")
    public ResultObject<TC> UpdateCourseTerm(HttpServletRequest request,TC tc){
        ResultObject<TC> rs = new ResultObject<TC>();
        int s = tcService.UpdateTC(tc);
        System.out.println(tc.getCno() + "   " + s );
        //List<AllTsc> list = allTscService.selectAll();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("更新成功");
        rs.setData(tc);
        rs.setCount(Long.parseLong("1"));
        return rs;
    }

    @RequestMapping("/getAllTea")
    public ResultObject<List<Teacher>> getAllTea(HttpServletRequest request){
        ResultObject<List<Teacher>> rs = new ResultObject<List<Teacher>>();
        List<Teacher> list = teacherService.GetAllTeacher();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.size());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }

    @RequestMapping("/getAllCourse")
    public ResultObject<List<Course>> getAllCourse(HttpServletRequest request){
        ResultObject<List<Course>> rs = new ResultObject<List<Course>>();
        List<Course> list = courseService.GetAllCourse();
        rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        rs.setMsg("查询成功");
        rs.setData(list);
        System.out.println(list.size());
        rs.setCount(Long.parseLong(list.size() + ""));
        return rs;
    }


}
