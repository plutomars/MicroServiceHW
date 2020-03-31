package com.example.microservicehw.info_service.endpoint;

import com.example.microservicehw.info_service.pojo.InfoResponse;
import com.example.microservicehw.info_service.pojo.Student;
import com.example.microservicehw.info_service.repository.StudentRepo;
import com.example.microservicehw.info_service.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InfoServiceController {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String hostName;

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoServiceController.class);
    @Autowired
    OperationService operationService;

    @GetMapping("/students")
    public ResponseEntity<InfoResponse> getAllStudents(){
        LOGGER.info("calling info_service");
        InfoResponse response = operationService.service();
        LOGGER.info("Responsed: "+response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionHandler(Exception ex){
        LOGGER.error("Erroe message: "+ex.getMessage());
        return new ResponseEntity<>("Bad request!",HttpStatus.BAD_REQUEST);
    }
}
