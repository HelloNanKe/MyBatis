package com.zt.service;

import com.zt.mappers.StudentMapper;
import com.zt.model.Student;
import com.zt.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/5/3.
 */

public class StudentTest2 {
    SqlSession sqlSession=null;
    StudentMapper studentMapper=null;
    Student stu;
    Logger log;
    @Before
    public void TestSetup(){
        sqlSession= SqlSessionFactoryUtil.openSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);

        log=Logger.getLogger(StudentTest2.class);
    }
    @Test
    public void TearDown(){
        log.info("添加学生");
        stu=new Student();
        stu.setName("pierkas");
        stu.setAge(23);
        int rows=studentMapper.add(stu);
        sqlSession.commit();
        if(rows>0){
            log.info("添加成功"+rows);
        }
    }

    @Test
    public void testUpdate(){
        log.info("修改学生");
        Student stu1=new Student(9,"kio",21);
        studentMapper.update(stu1);
        sqlSession.commit();
    }
    @Test
    public void findAll(){
        log.info("查询所有");
        List<Student> list=new ArrayList<>();
        list= studentMapper.findAll();

       for(Student s :list){
           log.info("name:"+s.getName()+"   "+"age:"+s.getAge());
       }
    }
    @Test
    public void testFindById(){
        log.info("按照id查找学生！");
        Student s=studentMapper.findById(9);
        log.info("name:"+s.getName()+"   "+"age:"+s.getAge());
    }
    @Test
    public void testDelete(){
        log.info("按照id删除某个学生");
        studentMapper.delete(1);
        sqlSession.commit();
    }
    @After
    public void afterTest(){
       sqlSession.close();

    }
}
