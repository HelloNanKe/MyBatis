package com.zt.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by apple on 2017/5/3
 */
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;

    /**
     * sqlSessionFactory的单例
     * @return
     */
    private static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory==null){
            try {
                InputStream inputStream= Resources.getResourceAsStream("Mybatis-config.xml");
                sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 获得session对象进而操作数据库
     * @return
     */

    public static SqlSession openSession(){
        return getSqlSessionFactory().openSession();
    }
}
