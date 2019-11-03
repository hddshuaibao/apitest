package com.weixt.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {


    private static SqlSessionFactory testFactory = null;
    private static SqlSessionFactory autoFactory = null;

    static{
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("databaseConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reader readerReal = null;
        try {
            readerReal = Resources.getResourceAsReader("databaseConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        testFactory = new SqlSessionFactoryBuilder().build(reader,"190");
        autoFactory = new SqlSessionFactoryBuilder().build(readerReal,"auto");

    }

    public static SqlSession getTestSession() throws IOException {


        SqlSession sqlSession = testFactory.openSession();

        return sqlSession;

    }

    public  static  SqlSession getAutoSession(){

        SqlSession sqlSession = autoFactory.openSession();

        return sqlSession;

    }
}
