package com.example.microservicehw.info_service.service;

import com.example.microservicehw.info_service.pojo.InfoResponse;
import com.example.microservicehw.info_service.pojo.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public InfoResponse service() {
        StudentResponse studentResponse = restTemplate.getForObject(
          "http://localhost:2234/allStudents",StudentResponse.class);


//        ResponseEntity<StudentResponse> responseEntity = restTemplate.exchange(
////                "http://student_service/allStudents",
//                "http://localhost:2234/allStudents",
//                HttpMethod.GET,
//                null,
//                StudentResponse.class
//        );
        InfoResponse infoResponse = new InfoResponse();
        infoResponse.setStudentList(studentResponse.getStudents());
        infoResponse.setCount(studentResponse.getStudents().size());
//        infoResponse.setStudentList(responseEntity.getBody().getStudents());
//        infoResponse.setCount(responseEntity.getBody().getStudents().size());
        return infoResponse;
    }
}
