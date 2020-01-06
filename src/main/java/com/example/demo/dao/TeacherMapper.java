package com.example.demo.dao;

import com.example.demo.bean.Teacher;
import java.util.List;

public interface TeacherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Thu Jan 02 20:36:18 CST 2020
     */
    int deleteByPrimaryKey(String tno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Thu Jan 02 20:36:18 CST 2020
     */
    int insert(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Thu Jan 02 20:36:18 CST 2020
     */
    Teacher selectByPrimaryKey(String tno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Thu Jan 02 20:36:18 CST 2020
     */
    List<Teacher> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Thu Jan 02 20:36:18 CST 2020
     */
    int updateByPrimaryKey(Teacher record);
}