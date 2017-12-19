package edu.mum.cs544.controller;

import edu.mum.cs544.dao.ItemDAO;
import edu.mum.cs544.model.*;
import edu.mum.cs544.service.ItemService;
import edu.mum.cs544.service.StatementService;
import edu.mum.cs544.util.StatementCategory;
import edu.mum.cs544.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StatementController {

    @Autowired
    StatementService statementService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/statement", method = RequestMethod.GET)
    public ModelAndView statementForm() {
        ModelAndView model = new ModelAndView();

        //model.addObject("items", itemService.itemList());

        model.setViewName("statement");
        return model;
    }

    @RequestMapping(value = "/api/v1/dorm/student/statement", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStatement(@RequestBody @Validated Statement statement) {

        //String password = "1234";//Utility.getSaltString();
        List<Item> items = items = itemService.itemList();
        Student student = new Student();
        Building building = new Building();
        building.setBuildingNo("144");
        Room room = new Room();
        room.setId(108);
        student.setStudentId("985884");
        student.setRoom(room);
        statement.setStudent(student);
        statement.setBuilding(building);
        statement.setItems(items);
       // statement.setCategory(StatementCategory.CHECKIN);


        //student.setPassword(passwordEncoder.encode(password));

        Response respStatement = new Response();
        statementService.save(statement);
        HttpStatus httpCode = (statement.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respStatement.setDescription((statement.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respStatement, httpCode);

    }

    @RequestMapping(value = "/statements", method = RequestMethod.GET)
    public ModelAndView statementList(){
        ModelAndView model = new ModelAndView();
        model.addObject(statementService.statementList());
        return model;
    }



}
