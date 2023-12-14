package com.arjuncode.Springbootlearn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    //this class will send back data to restResponseEntituExceptionHandler class

    //now mention what to send
    private HttpStatus status ;
    private String message;

}
