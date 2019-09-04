package com.rl.mybatis.bean;

/**
 * @author XAIOHU
 * @date 2019/8/24 --14:22
 **/
public class Employee {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String lastName;
    private String email;
    private String gender;
    private Department dept;

    public Employee() {

    }


    public Employee(Integer id, String lastName, String email, String gender) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
