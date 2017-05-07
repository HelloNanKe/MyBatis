package com.zt.service;

import com.zt.mappers.GradeMapper;
import com.zt.mappers.StudentMapper;
import com.zt.model.Grade;
import com.zt.model.Student;
import com.zt.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by apple on 2017/5/3.
 */

public class GradeTest {
    SqlSession sqlSession=null;
    GradeMapper gradeMapper=null;
    Logger log;
    @Before
    public void TestSetup(){
        sqlSession= SqlSessionFactoryUtil.openSession();
        gradeMapper=sqlSession.getMapper(GradeMapper.class);

        log=Logger.getLogger(GradeTest.class);
    }

    @Test
    public void findById(){
        Grade grade=gradeMapper.getById(1);
        System.out.println(grade);
    }

    @After
    public void afterTest(){
       sqlSession.close();

    }
}
