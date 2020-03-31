package com.example.microservicehw.info_service.pojo;

import java.util.List;

public class InfoResponse {
    public void setCount(int count) {
        this.count = count;
    }

    private int count;
    private List<Student> studentList;

    public int getCount() {
        return count;
    }

    public InfoResponse(){}

    public InfoResponse(List<Student> studentList) {
        this.count = studentList.size();
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
