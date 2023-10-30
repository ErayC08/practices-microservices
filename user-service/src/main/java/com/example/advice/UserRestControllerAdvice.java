package com.example.advice;

import com.example.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserRestControllerAdvice {

    @ExceptionHandler({
            InvalidMailException.class,
            InvalidNicknameException.class,
            MailAlreadyExistsException.class,
            MismatchingPasswordException.class,
            NicknameAlreadyExistsException.class,
            NullMailException.class,
            NullNicknameException.class,
            NullPasswordException.class
    })
    public ResponseEntity<String> handleBadRequestException(RuntimeException exception) {
        return ResponseEntity.badRequest().body(exception.getLocalizedMessage());
    }

    @ExceptionHandler({InvalidPasswordException.class})
    public ResponseEntity<String> handleInvalidPasswordException(InvalidPasswordException exception) {
        return ResponseEntity.badRequest().body("The password must have following criteria: " + exception.getLocalizedMessage());
    }
}
