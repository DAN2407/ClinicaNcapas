package com.springdemo.clinica.handlers;

import com.springdemo.clinica.models.dtos.GeneralResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponse> GeneralHandler(Exception ex){
        log.error((ex.getMessage()));
        log.error((ex.getClass().toGenericString()));
        return GeneralResponse.getResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<GeneralResponse> NoResourceFoundHandler(NoResourceFoundException ex){
        log.error((ex.getMessage()));
        log.error((ex.getClass().toGenericString()));
        return GeneralResponse.getResponse(HttpStatus.NOT_FOUND);
    }
}
