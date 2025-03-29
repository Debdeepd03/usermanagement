package edu.userdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class EmailException extends Throwable {
    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistException(EmailException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(

                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
