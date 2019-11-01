package com.invillia.springregister.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public void handleNotFount(HttpServletResponse resp, Exception e) throws IOException{
        resp.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
