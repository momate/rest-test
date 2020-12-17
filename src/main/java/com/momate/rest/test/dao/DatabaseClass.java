package com.momate.rest.test.dao;

import com.momate.rest.test.model.Reminder;
import com.momate.rest.test.model.User;
import java.util.ArrayList;
import java.util.List;

public class DatabaseClass {

    public static List<User> users = new ArrayList<>();
    public static List<Reminder> reminders = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static List<Reminder> getReminders() {
        return reminders;
    }
    
    

}
