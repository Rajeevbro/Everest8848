package com.everest8848.Everest8848.exceptions;

import com.everest8848.Everest8848.dto.ErrorDto;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex) {

        HashMap<String, String> errors = new HashMap<>();

        // Get the error messages from the binding result
        ex.getBindingResult().getFieldErrors().stream()
                .forEach(error->errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleDataAccessException(DataAccessException ex)
    {
        ErrorDto errorDto = new ErrorDto();
     errorDto.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
     errorDto.setMessage(ex.getMessage());
        return new  ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleDataEntigrityException(DataIntegrityViolationException ex)
    {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        errorDto.setMessage(ex.getMessage());
        return new  ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDto> productNotFoundException(ProductNotFoundException ex){
        ErrorDto errors = new ErrorDto();
        errors.setMessage(ex.getMessage());
        errors.setHttpStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDto>userNotFoundException(UserNotFoundException ex){
        ErrorDto errorDto= new ErrorDto();
        errorDto.setHttpStatus(HttpStatus.NOT_FOUND);
        errorDto.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }

}

