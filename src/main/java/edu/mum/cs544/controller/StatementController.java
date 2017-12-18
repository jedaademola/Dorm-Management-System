package edu.mum.cs544.controller;

import edu.mum.cs544.dao.ItemDAO;
import edu.mum.cs544.model.Item;
import edu.mum.cs544.model.Response;
import edu.mum.cs544.model.Statement;
import edu.mum.cs544.service.ItemService;
import edu.mum.cs544.service.StatementService;
import edu.mum.cs544.util.StatementCategory;
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

        model.addObject("items", itemService.itemList());

        model.setViewName("statement");
        return model;
    }


}
