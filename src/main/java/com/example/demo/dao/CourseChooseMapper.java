package com.example.demo.dao;

import com.example.demo.bean.tool.CourseChoose;
import java.util.List;

public interface CourseChooseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coursechoose
     *
     * @mbggenerated Fri Jan 03 23:49:17 CST 2020
     */
    int insert(CourseChoose record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coursechoose
     *
     * @mbggenerated Fri Jan 03 23:49:17 CST 2020
     */
    List<CourseChoose> selectAll();
}