package com.zt.mappers;

import com.zt.model.Student;

import java.util.List;

/**
 * Created by apple on 2017/5/3.
 */
public interface StudentMapper {
    //增
    public int add(Student student);//int表示影响的记录行数
    //改
    public int update(Student student);
    //删
    public int delete(Integer id);
    //查
    public Student findById(Integer id);
    //查询全部学生
    public List<Student> findAll();

    public Student findStudentWithAddress(Integer id);

    public Student findByGradeId(Integer gradeId);
}
