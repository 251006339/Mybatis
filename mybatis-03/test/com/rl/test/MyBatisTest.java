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
 * 测试增删改
 * 1.mybatis允许曾删改直接定义返回long.  boolean
 * 2.我门需要手动提交数据
 *    openSession(); 手动提交
 *    opensession(true):自动提交
 * 3.
 *
 *
 **/
public class MyBatisTest {


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
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(null, "2", "3", "1");
            mapper.addEmp(employee);
        System.out.println(employee.getId());

        sqlSession.commit();
        sqlSession.close();

    }

    @Test //根据xml修改  test1() throws IOException; io流
    public void test2() throws IOException {
        //需要手动提交  需要手动提交
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();//不会自动提交数据.需要手动提交数据
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(2, "4", "3", "1");
        Integer integer = mapper.updateEmp(employee);
        System.out.println(integer);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test //删除  test1() throws IOException; io流
    public void test3() throws IOException {
        //需要手动提交  需要手动提交
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();//不会自动提交数据.需要手动提交数据
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(1, "4", "3", "1");
        mapper.deleteEmpById(1);
        sqlSession.commit();
        sqlSession.close();

    }





}
