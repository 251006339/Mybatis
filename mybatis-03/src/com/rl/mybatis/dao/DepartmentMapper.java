package com.rl.mybatis.dao;

import com.rl.mybatis.bean.Department;

/**
 * @author XAIOHU
 * @date 2019/8/24 --14:22
 **/
public interface DepartmentMapper {
    public Department getDeptById(Integer id);

    public Department getDeptByIdPlus(Integer id);

    public Department getDeptByIdStep(Integer id);


}
