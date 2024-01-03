package com.simlearn.score.exception.handler;

import com.simlearn.score.error.ErrorObject;
import com.simlearn.score.exception.GameAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(GameAlreadyExistException.class)
    public ResponseEntity<ErrorObject> handleAuthenticationFailedException(GameAlreadyExistException ae) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setError("01");
        errorObject.setMessage(ae.getMessage());
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
