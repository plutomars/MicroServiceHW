package com.example.microservicehw.student_service.pojo;

import java.util.List;

public class StudentResponse {
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudentResponse(){}
    public StudentResponse(List<Student> students){
        this.students=students;
    }

}
