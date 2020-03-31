package com.example.microservicehw.student_service.repository;
import com.example.microservicehw.student_service.pojo.Address;
import com.example.microservicehw.student_service.pojo.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepo {
    private List<Student> studentList=new ArrayList<>();

    public StudentRepo(){
        studentList.add(new Student(101,"test1",20,new Address("sterling","VA")));
        studentList.add(new Student(102,"test1",23,new Address("tyson","VA")));
        studentList.add(new Student(103,"test1",31,new Address("san dimas","CA")));
        studentList.add(new Student(104,"test1",42,new Address("seattle","WA")));
        studentList.add(new Student(105,"test1",18,new Address("san jose","CA")));
        studentList.add(new Student(106,"test1",55,new Address("houston","TX")));
        studentList.add(new Student(107,"test1",67,new Address("santa clara","CA")));
        studentList.add(new Student(108,"test1",37,new Address("kirkland","WA")));
        studentList.add(new Student(109,"test1",28,new Address("irvine","CA")));
        studentList.add(new Student(110,"test1",30,new Address("new york city","NY")));
    }

    public List<Student> getAllStudent(){
        return this.studentList;
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }
}
