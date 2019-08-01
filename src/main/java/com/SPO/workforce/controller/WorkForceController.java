package com.SPO.workforce.controller;

import com.SPO.workforce.entity.Place;
import com.SPO.workforce.exception.CleanerCapacityException;
import com.SPO.workforce.exception.RoomSizeNotAppropriate;
import com.SPO.workforce.service.WorkForceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WorkForceController {

    @Autowired
    private WorkForceServiceImpl workForceService;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateCleaners(@RequestBody Place place) throws RoomSizeNotAppropriate, CleanerCapacityException {
        return new ResponseEntity<>(workForceService.calculateCleaners(place), HttpStatus.OK);
    }

}
