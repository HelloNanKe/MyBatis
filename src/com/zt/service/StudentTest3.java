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

public class StudentTest3 {
    SqlSession sqlSession=null;
    StudentMapper studentMapper=null;
    Student stu;
    Logger log;
    @Before
    public void TestSetup(){
        sqlSession= SqlSessionFactoryUtil.openSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);

        log=Logger.getLogger(StudentTest3.class);
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

    /**
     * 查询学生（带地址）
     * 一对一映射
     */
    @Test
    public void testFindStudentWithAddress(){
        log.info("按照id查找学生！(包括地址)");
        Student s;
         s= studentMapper.findStudentWithAddress(10);
         if(s!=null){
             log.info(s);
         }else{
             log.info("s为空");
         }
    }

    @After
    public void afterTest(){
       sqlSession.close();

    }
}
