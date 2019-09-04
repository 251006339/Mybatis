package com.rl.test;

import com.rl.bean.Employee;
import com.rl.dao.EmployeeMapper;
import com.rl.dao.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author XAIOHU
 * @date 2019/8/24 --10:26
 **/
public class MainTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource ="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(resourceAsStream);

    }
  @Test
    public void test() throws IOException {
      SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
      SqlSession sqlSession = sqlSessionFactory.openSession();
      EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
      Employee empById =mapper.getEmpById(1);
      System.out.println(empById);


  }
    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee empById =mapper.getEmpById(1);
        System.out.println(empById);


    }

}
