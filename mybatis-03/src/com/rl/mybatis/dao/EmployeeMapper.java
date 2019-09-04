package com.rl.mybatis.dao;

import com.rl.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author XAIOHU
 * @date 2019/8/24 --14:25
 **/
public interface EmployeeMapper {
    //获取public Map<String,Object> getEmpByIdReturnMap(Integer id);
    public Map<String,Object> getEmpByIdReturnMap(Integer id);
     //获得employee 对象
    public Employee getEmpById(Integer id);
    //使用命名空间注解@Param("id")赋值
    public Employee getEmpByIdAndLastName(@Param("id") Integer id,@Param("lastName")String lastName);
    //增加对象
    public Integer   addEmp(Employee employee);
    //修改对象
    public Integer updateEmp(Employee employee);
   //删除对象
    public Integer deleteEmpById(Integer id);
}
