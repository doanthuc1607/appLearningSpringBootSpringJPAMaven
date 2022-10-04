package com.example.demo.exception;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotFoundException {
    private int statusCode;
    private String message;
    private String errors;
}
