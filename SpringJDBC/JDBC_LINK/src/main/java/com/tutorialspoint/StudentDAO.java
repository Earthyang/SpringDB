package com.tutorialspoint;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {

    //初始化数据库
    public void setDataSource(DataSource ds);

    //创建
    public void create(String name , Integer age);

    public Student getStudent(Integer id);

    public List<Student> listStudent();

    public void delete(Integer id);

    public void update(Integer id , Integer age);
}
