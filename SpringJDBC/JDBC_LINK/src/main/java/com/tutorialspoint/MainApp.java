package com.tutorialspoint;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new FileSystemXmlApplicationContext("file:F:\\IDEA_CODES\\SpringDB\\SpringJDBC\\JDBC_LINK\\src\\main\\webapp\\WEB-INF\\Beans.xml");
        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");

        System.out.println("---------------Record Creation-----------");
        studentJDBCTemplate.create("Zara",11);
        studentJDBCTemplate.create("Tom",15);
        studentJDBCTemplate.create("Jack",10);

        System.out.println("---------------List of Students-----------");
        List<Student> students = studentJDBCTemplate.listStudent();
        for(Student record:students){
            System.out.print("ID : " + record.getId());
            System.out.print(", NAME : " + record.getName());
            System.out.println(", AGE : " + record.getAge());
        }

        System.out.println("----Updating Record with ID = 2 -----" );
        studentJDBCTemplate.update(2, 20);
        System.out.println("----Listing Record with ID = 2 -----" );
        Student student = studentJDBCTemplate.getStudent(2);
        System.out.print("ID : " + student.getId() );
        System.out.print(", Name : " + student.getName() );
        System.out.println(", Age : " + student.getAge());


    }

}
