package edu.mum.cs544.controller;

import edu.mum.cs544.model.*;
import edu.mum.cs544.service.BuildingRoomService;
import edu.mum.cs544.service.StatementService;
import edu.mum.cs544.service.TokenService;
import edu.mum.cs544.util.Utility;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
public class StatementController {

    @Autowired
    StatementService statementService;

    @Autowired
    BuildingRoomService buildingRoomService;

//    @Autowired
//    ItemService itemService;

    @RequestMapping(value = "/statement", method = RequestMethod.GET)
    public ModelAndView statementForm() {
        ModelAndView model = new ModelAndView();


        //model.addObject("items", itemService.itemList());

        model.setViewName("statement");
        return model;
    }

    @RequestMapping(value = "/api/v1/dorm/student/statement", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public ResponseEntity<?> createStatement(@RequestBody @Validated Statement statement) {

        Student userCurrent = TokenService.getCurrentUserFromSecurityContext();
        Student s = new Student();
        s.setId(userCurrent.getId());
        s.setStudentId(userCurrent.getStudentId());

        Room roomNo = buildingRoomService.getRoomByStudentId(userCurrent.getId());

        statement.setStudent(s);

        statement.setRoomNo(roomNo);
        statement.setBuilding(roomNo.getBuilding());
        statement.setStatementDate(new Date());

        List<Item> items = Utility.itemList();
        statement.setItems(items);

        //statement.setBuilding(buildingRoomService.);
        //Building building = buildingRoomService.
//        List<Item> items = itemService.itemList();
//        Student student = new Student();
//        Building building = new Building();
//        building.setBuildingNo("144");
//        Room room = new Room();
//        room.setId(108);
//        student.setStudentId("985884");
//        student.setRoom(room);
//        statement.setStudent(student);
//        statement.setBuilding(building);

//       // statement.setCategory(StatementCategory.CHECKIN);
//
//
//        //student.setPassword(passwordEncoder.encode(password));

        Response respStatement = new Response();
        statementService.save(statement);
        HttpStatus httpCode = (statement.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respStatement.setDescription((statement.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respStatement, httpCode);

    }

    @RequestMapping(value = "/statements", method = RequestMethod.GET)
    public ModelAndView statementList(){
        ModelAndView model = new ModelAndView();
        List<Statement> lists = statementService.statementList();
        model.addObject("statements", lists);
        model.setViewName("viewStatementStudent");
        return model;
    }
//    @RequestMapping(value = "/applicationList", method =  RequestMethod.GET)
//    public List<Complain> complainList(Complain complain){//, Model model to recheck
//
//        List<Complain> complains = new ArrayList<>();
//        complains = complainService.allComplains();
//        //model.addAllAttributes(applications);
//        return complains;
//    }



}
