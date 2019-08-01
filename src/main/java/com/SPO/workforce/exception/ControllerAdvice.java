package com.SPO.workforce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RoomSizeNotAppropriate.class)
    public ResponseEntity<?> handleRoomSizeException() {
        return new ResponseEntity<>("Room size is not appropriate!\nPlease add valid values!",
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CleanerCapacityException.class)
    public ResponseEntity<?> handleCleanerCapacityException() {
        return new ResponseEntity<>("Cleaner capacity is not appropriate!\nPlease add valid values!",
                HttpStatus.BAD_REQUEST);
    }
}
