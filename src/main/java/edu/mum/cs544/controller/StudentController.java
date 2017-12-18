package edu.mum.cs544.controller;

import edu.mum.cs544.model.Complain;
import edu.mum.cs544.model.Response;
import edu.mum.cs544.model.RoomApplication;
import edu.mum.cs544.model.Student;
import edu.mum.cs544.service.BuildingRoomService;
import edu.mum.cs544.service.ComplainService;
import edu.mum.cs544.service.StudentService;
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
//@RequestMapping(value = "/api/v1/dorm")
public class StudentController {
    @Autowired
    ComplainService complainService;

    @Autowired
    StudentService studentService;

    @Autowired
    BuildingRoomService buildingRoomService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/api/v1/dorm/student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudent(@RequestBody @Validated Student student) {

        String password = "1234";//Utility.getSaltString();

        student.setPassword(passwordEncoder.encode(password));

        Response respStudent = new Response();
        studentService.save(student);
        HttpStatus httpCode = (student.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respStudent.setDescription((student.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respStudent, httpCode);

    }



    @RequestMapping(value = "/api/v1/dorm/student/complaint", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addStudentComplaint(@RequestBody @Validated Complain complain) {

        Student s = new Student();
        s.setStudentId("986040");//TODO replace from Session
        complain.setStudentId(s);
        complain.setComplainDate(new Date());

        Response respStudent = new Response();
        studentService.addStudentComplaint(complain);
        HttpStatus httpCode = (complain.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respStudent.setDescription((complain.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respStudent, httpCode);

    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("dashboardStudent");
        return model;
    }


    @RequestMapping(value = "/dashboardra", method = RequestMethod.GET)
    public ModelAndView dashboardRa() {
        ModelAndView model = new ModelAndView();
        model.setViewName("dashboardRA");
        return model;
    }


    @RequestMapping(value = "/viewcomplaintra", method = RequestMethod.GET)
    public ModelAndView viewComplaintRa() {
        ModelAndView model = new ModelAndView();
        model.addObject("complaints", complainService.allComplains());
        model.setViewName("viewcomplaintra");
        return model;
    }



    @RequestMapping(value = "/complaint", method = RequestMethod.GET)
    public ModelAndView complaintForm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("complaint");
        return model;
    }


    @RequestMapping(value = "/studentForm", method = RequestMethod.GET)
    public ModelAndView studentForm(@ModelAttribute("command") RoomApplication roomApplication) {
        ModelAndView model = new ModelAndView();

        model.addObject("buildings", buildingRoomService.getBuildingListForDropDown());
        model.addObject("rooms", buildingRoomService.getRoomListForDropDown(0));

        model.setViewName("forms");
        return model;
    }


    @RequestMapping(value = "/api/v1/dorm/student/room/applyREST",
            method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> roomApplicationREST(@RequestBody @Validated RoomApplication data) {

        Student s = new Student();
        s.setStudentId("986040");//TODO replace from Session
        data.setStudent(s);
        data.setStatus(ApplicationStatus.PENDING);
        data.setApplicationDate(new Date());

        Response respStudent = new Response();
        studentService.roomApplication(data);

        HttpStatus httpCode = (data.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respStudent.setDescription((data.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respStudent, httpCode);

    }

    @RequestMapping(value = "/api/v1/dorm/student/room/apply", method = RequestMethod.POST)
    public String roomApplication(@ModelAttribute("data") RoomApplication data,
                                  ModelMap model, HttpServletRequest request)

    {
        // ModelAndView modelandView = new ModelAndView("forms");

        Student s = new Student();
        s.setStudentId("986040");
        data.setStudent(s);
        data.setStatus(ApplicationStatus.PENDING);

        // Response respStudent = new Response();
        studentService.roomApplication(data);
        String response = (data.getId() > 0) ? "Operation Successful" : "Operation Failed";

        // modelandView.addObject("response", response);
        return "redirect:/studentForm?emr=" + response;
        //return modelandView;

    }


}
