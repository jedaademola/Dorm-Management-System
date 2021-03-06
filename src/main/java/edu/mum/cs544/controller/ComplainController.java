package edu.mum.cs544.controller;

import edu.mum.cs544.model.Complain;
import edu.mum.cs544.model.Response;
import edu.mum.cs544.model.Student;
import edu.mum.cs544.service.ComplainService;
import edu.mum.cs544.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/dorm")
public class ComplainController {

    @Autowired
    ComplainService complainService;

    @RequestMapping(value = "/complain", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public ResponseEntity<?> createComplain(@RequestBody @Validated Complain complain) {

        Student userCurrent = TokenService.getCurrentUserFromSecurityContext();

        Student s = new Student();
        s.setId(userCurrent.getId());

        s.setStudentId(userCurrent.getStudentId());
        complain.setStudentId(s);

        Response respComplain = new Response();
        complainService.save(complain);
        HttpStatus httpCode = (complain.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respComplain.setDescription((complain.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respComplain, httpCode);
    }
    @RequestMapping(value = "/applicationList", method =  RequestMethod.GET)
    public List<Complain> complainList(Complain complain){//, Model model to recheck

        List<Complain> complains = new ArrayList<>();
        complains = complainService.allComplains();
        //model.addAllAttributes(applications);
        return complains;
    }
}
