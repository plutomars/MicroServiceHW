package com.example.microservicehw.student_service.endpoint;
import com.example.microservicehw.student_service.pojo.Student;
import com.example.microservicehw.student_service.pojo.StudentResponse;
import com.example.microservicehw.student_service.repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentServiceController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String hostName;
//    @Value("${eureka.instance.instanceId}")
//    private String instanceId;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceController.class);
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/allStudents")
    public StudentResponse getAllStudents(){
        LOGGER.info("calling student service");
        LOGGER.info("calling "+hostName+":"+port);
//        LOGGER.info("InstanceId: "+instanceId);
        List<Student> studentList = studentRepo.getAllStudent();

        return new StudentResponse(studentList);
    }
}
