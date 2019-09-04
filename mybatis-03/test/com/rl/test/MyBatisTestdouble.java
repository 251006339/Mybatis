package com.rl.test;

import com.rl.mybatis.bean.Employee;
import com.rl.mybatis.dao.EmployeeMapper;
import com.rl.mybatis.dao.EmployeeMapperAnnotataion;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author XAIOHU
 * @date 2019/8/24 --14:23
 **/
public class MyBatisTestdouble {


    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test  //查询
    public void test() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();//不会自动提交数据.需要手动提交数据
        EmployeeMapperAnnotataion mapper = sqlSession.getMapper(EmployeeMapperAnnotataion.class);
        Employee empById = mapper.getEmpById(1);
        System.out.println(empById);


    }
    @Test //增加  test1() throws IOException; io流
    public void test1() throws IOException {
         //需要手动提交  需要手动提交
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();//不会自动提交数据.需要手动提交数据
        //需要手动提交,需要手动提交
        EmployeeMapperAnnotataion mapper = sqlSession.getMapper(EmployeeMapperAnnotataion.class);
        Employee employee = new Employee(1, "2", "3", "1");
         mapper.insertEmp(employee);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test //根据xml修改  test1() throws IOException; io流
    public void test2() throws IOException {
        //需要手动提交  需要手动提交
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();//不会自动提交数据.需要手动提交数据
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(1, "4", "3", "1");
        mapper.updateEmp(employee);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test //删除  test1() throws IOException; io流
    public void test3() throws IOException {
        //需要手动提交  需要手动提交

    }

    @Test //增加  test1() throws IOException; io流
    public void test4() throws IOException {
        //需要手动提交  需要手动提交


    }



}
