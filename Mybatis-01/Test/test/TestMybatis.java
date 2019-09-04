package test;

import com.rl.bean.Employee;
import com.rl.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author XAIOHU
 * @date 2019/8/24 --9:56
 * 1、接口式编程
 *  * 	原生：		Dao		====>  DaoImpl
 *  * 	mybatis：	Mapper	====>  xxMapper.xml
 *  *
 *  * 2、SqlSession代表和数据库的一次会话；用完必须关闭；
 *  * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。
 *  * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
 *  * 		（将接口和xml进行绑定）
 *  * 		EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);
 *  * 5、两个重要的配置文件：
 *  * 		mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息
 *  * 		sql映射文件：保存了每一个sql语句的映射信息：
 *  * 					将sql抽取出来。
 *
 *
 *
 **/
public class TestMybatis {

        //获取sqlSessionFactory getS
        public SqlSessionFactory getSqlSessionFactory() throws IOException {
            String resource ="mybatis-config.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            return new SqlSessionFactoryBuilder().build(resourceAsStream);

        }
    @Test
    public  void test() throws IOException {

            SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Object o = sqlSession.selectOne("com.rl.dao.EmployeeMapper.getEmpById", 1);
            System.out.println(o);//通过配置文件查询
        } finally {
            sqlSession.close();//sqlsession 清理close();
        }
    }
    @Test
    public  void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过接口获得代理对象;
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee empById = mapper.getEmpById(1); //获取对象employee
        System.out.println(empById);  //获得对象;

        sqlSession.close();//关闭session连接
    }
  @Test
    public void test2(){




  }

}
