package com.infy.springbootrestapicrudapp.app.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseError {
 private LocalDate date;
 private Integer statuscode;
 private HttpStatus message;
 private String errorMessage;
 private String urlPath;
}
