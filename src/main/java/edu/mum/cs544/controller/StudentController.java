package edu.mum.cs544.controller;

import edu.mum.cs544.model.Response;
import edu.mum.cs544.model.Student;
import edu.mum.cs544.service.StudentService;
import edu.mum.cs544.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/dorm")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudent(@RequestBody @Validated Student student) {

        String password = Utility.getSaltString();

        student.setPassword(passwordEncoder.encode(password));
        student.setStudentId("986040");//TODO should change this

        Response respStudent = new Response();
        studentService.save(student);
        HttpStatus httpCode = (student.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respStudent.setDescription((student.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respStudent, httpCode);

    }


}
