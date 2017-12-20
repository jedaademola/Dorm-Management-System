package edu.mum.cs544.controller;


import edu.mum.cs544.model.Admin;
import edu.mum.cs544.model.Response;
import edu.mum.cs544.model.Student;
import edu.mum.cs544.service.AdminService;
import edu.mum.cs544.service.RoomApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import edu.mum.cs544.model.Complain;
import edu.mum.cs544.model.Response;
import edu.mum.cs544.model.RoomApplication;
import edu.mum.cs544.model.Student;
import edu.mum.cs544.service.*;
import edu.mum.cs544.util.ApplicationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class AdminController {


    @Autowired
    private AdminService adminService;
    @Autowired
    private RoomApplicationService roomApplicationService;


    @RequestMapping(value = "/admin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAdmin(@RequestBody @Validated Admin admin) {

        String password = "1234";//Utility.getSaltString();

        //   admin.setPassword(passwordEncoder.encode(password));
        //

        Response respAdmin= new Response();
        adminService.save(admin);
        HttpStatus httpCode = (admin.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respAdmin.setDescription((admin.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respAdmin, httpCode);

    }

    @RequestMapping(value = "/dashboardAdmin", method = RequestMethod.GET)
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("dashboardAdmin");
        return model;
    }


    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView viewApplications() {
        ModelAndView model = new ModelAndView();
        model.addObject("Application", roomApplicationService.roomApplications());
        model.setViewName("roomApplcations");
        return model;
    }

/*
    @RequestMapping(value = "/addBuilding", method = RequestMethod.GET)
    public ModelAndView ModelAndView viewApplications1() {
        ModelAndView model = new ModelAndView();

       // model.addObject("buildings", buildingRoomService.getBuildingListForDropDown());
      //  model.addObject("rooms", buildingRoomService.getRoomListForDropDown(0));

        model.setViewName("addBuilding");
        return model;
    }
    @RequestMapping(value = "/addDorm", method = RequestMethod.GET)
    public ModelAndView dormForm(@ModelAttribute("command") Building building) {
        ModelAndView model = new ModelAndView();

        // model.addObject("buildings", buildingRoomService.getBuildingListForDropDown());
        //  model.addObject("rooms", buildingRoomService.getRoomListForDropDown(0));

        model.setViewName("addDorm");
        return model;
    }

    */
}
