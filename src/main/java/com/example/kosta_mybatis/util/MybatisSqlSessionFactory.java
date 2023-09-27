package com.example.kosta_mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisSqlSessionFactory {
    // static 변수는 처음 로드될 때 실행됨
    private static SqlSessionFactory sqlSessionFactory;

    // 클래스 변수의 초기화를 위해 static 블럭을 사용
    // static 변수는 하나를 가지고 같이 사용하기 때문에 staic 변수의 초기화는 static 초기화 블럭에서 작성해야 함
    static {
        try{
            String resource = "/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
