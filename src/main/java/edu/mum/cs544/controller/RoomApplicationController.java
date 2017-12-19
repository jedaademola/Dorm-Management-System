package edu.mum.cs544.controller;

import edu.mum.cs544.model.Response;
import edu.mum.cs544.model.RoomApplication;
import edu.mum.cs544.service.RoomApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/dorm")
public class RoomApplicationController {

    @Autowired
    RoomApplicationService roomApplicationService;

    @RequestMapping(value = "/roomApplication", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public ResponseEntity<?> createRoomApplication(@RequestBody @Validated RoomApplication roomApplication) {

        Response respRoomAppliacation = new Response();
        roomApplicationService.save(roomApplication);
        HttpStatus httpCode = (roomApplication.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        respRoomAppliacation.setDescription((roomApplication.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(respRoomAppliacation, httpCode);
    }





}
