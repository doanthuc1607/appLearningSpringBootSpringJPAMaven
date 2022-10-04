package com.example.demo.exception;

import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestException{
    private int statusCode;
    private String message;
    private Map<String, String> errors;
}
