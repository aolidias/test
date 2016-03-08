package org.fiveware.test.web.controller.advice;

import org.fiveware.test.web.controller.model.ErrorInfo;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiControllerAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorInfo notFoundException(NotFoundException ex) {
        return new ErrorInfo(ex.getMessage());
    }
    
    
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorInfo methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new ErrorInfo(ex.getLocalizedMessage());
    }
    
    
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorInfo exception(Exception ex) {
        return new ErrorInfo(ex.getLocalizedMessage());
    }
}	
