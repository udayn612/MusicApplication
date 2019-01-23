package com.stackroute.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalException {

        @ExceptionHandler(TrackNotFoundException.class)
        public ResponseEntity handleTrackNotFoundException(final Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }

        @ExceptionHandler(TrackAlreadyFoundException.class)
        public ResponseEntity TrackAlreadyFoundException(final Exception ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }



