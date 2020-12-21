package com.momate.rest.test.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reminder {

    private Long id;
    private String title;
    private String description;
    private List<Link> links = new ArrayList<>();

    public Reminder() {
    }

    public void addLink(Link link) {
        links.add(link);
    }

}
