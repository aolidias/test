package org.fiveware.test.web.controller.advice;

import org.fiveware.test.web.controller.dto.ErrorMsg;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Advice to treat exceptions
 * @author aolidias
 *
 */
@ControllerAdvice
public class ApiControllerAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorMsg notFoundException(NotFoundException ex) {
        return new ErrorMsg(ex.getMessage());
    }
    
    
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMsg methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new ErrorMsg(ex.getLocalizedMessage());
    }
    
    
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMsg exception(Exception ex) {
        return new ErrorMsg(ex.getLocalizedMessage());
    }
}	
