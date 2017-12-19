package edu.mum.cs544.controller;

import edu.mum.cs544.model.*;
import edu.mum.cs544.service.BuildingRoomService;
import edu.mum.cs544.service.ComplainService;
import edu.mum.cs544.service.RoomApplicationService;
import edu.mum.cs544.service.StudentService;
import edu.mum.cs544.service.TokenService;
import edu.mum.cs544.util.ApplicationStatus;
import edu.mum.cs544.util.UserCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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


    private TokenService tokenService;

    private RoomApplicationService roomApplicationService;



    @RequestMapping(value = "/api/v1/dorm/student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudent(@RequestBody @Validated Student student) {

        String password = "1234";//Utility.getSaltString();

        student.setPassword(passwordEncoder.encode(password));
        student.setCategory(UserCategory.STUDENT.name());

        Response respStudent = new Response();
        studentService.save(student);
        HttpStatus httpCode = (student.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respStudent.setDescription((student.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respStudent, httpCode);

    }



    @RequestMapping(value = "/api/v1/dorm/student/complaint", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addStudentComplaint(@RequestBody @Validated Complain complain) {

        Student userCurrent = TokenService.getCurrentUserFromSecurityContext();

       // Student sTemp = studentService.getStudentById(userCurrent.getId());

        Student s = new Student();
        s.setStudentId(userCurrent.getStudentId());
        complain.setStudentId(s);
        complain.setComplainDate(new Date());

        Response respStudent = new Response();
        studentService.addStudentComplaint(complain);
        HttpStatus httpCode = (complain.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respStudent.setDescription((complain.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respStudent, httpCode);

    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("dashboardStudent");
        return model;
    }


    @RequestMapping(value = "/dashboardra", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_RA')")
    public ModelAndView dashboardRa() {
        ModelAndView model = new ModelAndView();

        Person userCurrent = TokenService.getCurrentUserFromSecurityContext();

        model.setViewName("dashboardRA");
        return model;
    }


    @RequestMapping(value = "/viewcomplaintra", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_RA')")
    public ModelAndView viewComplaintRa() {
        ModelAndView model = new ModelAndView();

        Person userCurrent = TokenService.getCurrentUserFromSecurityContext();

        model.addObject("complaints", complainService.allComplains());
        model.setViewName("viewcomplaintra");
        return model;
    }


    @RequestMapping(value = "/viewcomplaintstudent", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public ModelAndView viewComplaintStudent() {
        ModelAndView model = new ModelAndView();

        Person userCurrent = TokenService.getCurrentUserFromSecurityContext();

        model.addObject("complaints", complainService.studentComplains(1));//TODO CHANGE THIS
        model.setViewName("viewcomplaintstudent");
        return model;
    }


    @RequestMapping(value = "/api/v1/dorm/ra/feedback", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_RA')")
    public ResponseEntity<?> addFeedback(@RequestBody @Validated Complain complain) {

        Person userCurrent = TokenService.getCurrentUserFromSecurityContext();

        Response respStudent = new Response();
        int result = studentService.addFeedbackComplaint(complain);
        HttpStatus httpCode = (result > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respStudent.setDescription((result > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respStudent, httpCode);

    }


    @RequestMapping(value = "/complaint", method = RequestMethod.GET)
    public ModelAndView complaintForm() {
        ModelAndView model = new ModelAndView();

       // Person userCurrent = TokenService.getCurrentUserFromSecurityContext();

        model.setViewName("complaint");
        return model;
    }


    @RequestMapping(value = "/studentForm", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public ModelAndView studentForm(@ModelAttribute("command") RoomApplication roomApplication) {
        ModelAndView model = new ModelAndView();


        model.addObject("buildings", buildingRoomService.getBuildingListForDropDown());
        model.addObject("rooms", buildingRoomService.getRoomListForDropDown(0));

        model.setViewName("forms");
        return model;
    }


    @RequestMapping(value = "/api/v1/dorm/student/room/apply",
            method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public ResponseEntity<?> roomApplicationREST(@RequestBody @Validated RoomRequest request) {

        Student userCurrent = TokenService.getCurrentUserFromSecurityContext();

        RoomApplication data = new RoomApplication();

        Student s = new Student();
        s.setStudentId(userCurrent.getStudentId());

        data.setStudent(s);

        Building b = new Building();
        Room r = new Room();

        b.setBuildingNo(request.getBuildingNo());
        r.setBuilding(b);
        r.setRoomNo(request.getRoomNo());
        data.setRoomNo(r);
        b.addRoom(r);//TODO WHAT IS THIS


        data.setBuildingNo(b);





        data.setArrivingDate(request.getArrivingDate());

        data.setStatus(ApplicationStatus.PENDING);
        data.setApplicationDate(new Date());

        Response respStudent = new Response();
        studentService.roomApplication(data);

        HttpStatus httpCode = (data.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respStudent.setDescription((data.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respStudent, httpCode);

    }

    @RequestMapping(value = "/api/v1/dorm/student/room/applyModel", method = RequestMethod.POST)
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
