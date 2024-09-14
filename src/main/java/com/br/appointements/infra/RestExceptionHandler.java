package com.br.appointements.infra;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.br.appointements.exceptions.BusinessException;
import com.br.appointements.exceptions.PatientNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<RestErrorMessage> handlePatientNotFound(PatientNotFoundException ex, WebRequest request) {
        RestErrorMessage error = new RestErrorMessage(
            HttpStatus.NOT_FOUND,                                   // status
            ex.getMessage(),                                       // message
            "/errors/not-found",                                  // type
            "The patient with id " + ex.getId() + " was not found.", // detail
            request.getDescription(false),                          // instance
            LocalDateTime.now()                                    // timestamp
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<RestErrorMessage> handleBusinessException(BusinessException exception, WebRequest request) {
        RestErrorMessage error = new RestErrorMessage(
            HttpStatus.CONFLICT,                                   // status
            "Database integrity violation",                        // message
            "/errors/database-error",                             // type
            "A database constraint was violated: " + exception.getMessage(), // detail
            request.getDescription(false),                          // instance
            LocalDateTime.now()                                    // timestamp
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

  
}
