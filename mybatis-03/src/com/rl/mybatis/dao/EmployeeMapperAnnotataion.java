package com.rl.mybatis.dao;

import com.rl.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author XAIOHU
 * @date 2019/8/24 --14:25
 **/
public interface EmployeeMapperAnnotataion{

    @Select("select * from tbl_employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Insert("insert into tbl_employee(last_name,gender,email) values(#{lastName},#{gender},#{email})")
    public void   insertEmp(Employee employee);

}
