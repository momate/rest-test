package com.momate.rest.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reminder {

    private Long id;
    private String title;
    private String description;

    public Reminder() {
    }
    
    

}
