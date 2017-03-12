package com.mybatis.config; /**
 * Created by Administrator on 2017/3/6.
 */

import junit.framework.Assert;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;

public class helloWorldForMybaits {
    public static void main(String args[]){
        System.out.println("你好，张添");
    }
//
//    @Test
//    public void testAdd() throws Exception {
//        Calculator calculator = new Calculator();
//        int sum = calculator.add(1, 2);
//        Assert.assertEquals(3, sum);
//    }
//
//    @Test
//    public void testMultiply() throws Exception {
//        Calculator calculator = new Calculator();
//        int product = calculator.multiply(2, 4);
//        Assert.assertEquals(8, product);
//    }

    @Test
    public void userDaoTest() throws Exception
    {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);

        SqlSession session = factory.openSession();
        int countall = session.selectOne("countAll");
        System.out.println("记录条数："+countall);


        POJO_contact pojo_contact = session.selectOne("selectAll");

        System.out.println("该对象姓名："+pojo_contact.getName());


    }
}
