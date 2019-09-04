package com.rl.dao;

import com.rl.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author XAIOHU
 * @date 2019/8/24 --10:27
 **/
public interface EmployeeMapperAnnotation {
       //查询sql语句  使用注解操作; #{id}
    // select *from tbl_employee where id=#{id};
    //使用注解实现连接 @Select("select *from tbl_employee where id=#{id}")
    @Select("select * from tbl_employee where id=#{id}")
    public Employee getEmpById(Integer id);
   //employee [id=1,lastName=null,email=2,gender=2]




}
