package com.momate.rest.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    
    private String errorMessage;
    private int errorCode;
    private String doucmentation;
    
    
    
}
