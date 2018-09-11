package com.print.dao;

import java.util.List;

import com.print.model.Student;

public interface StudentMapper {
    
//添加学生
    int insert(Student record);
//根据id来删除学�?
    int deleteByPrimaryKey(Integer id);
//根据名字来查询学生信�?
   
    List<Student> selectByName(String name);
  //根据Id来查询学生信�?
    
    Student selectStudentByID(int id);
//列出�?有的学生
   
    List<Student> getAllStu();
    //修改学生信息
    int updateStu(Student student);
 
}