package com.example.demo.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//generate auto getter, setter
@Setter
@Getter
//generate auto a contructor no arguments
@NoArgsConstructor
//generate auto a contructor with all of arguments
@AllArgsConstructor
public class SaleRequest {
    @NotBlank(message = "classes field is missing or has no data")
//    @NotNull
    private String classes;
//    @NotBlank
    @NotNull(message = "month field is missing or has no data")
    private Integer month;
    @NotBlank(message = "city field is missing or has no data")
//    @NotNull
    private String city;
    @NotBlank(message = "money field is missing or has no data")
//    @NotNull
    private String money;

}

