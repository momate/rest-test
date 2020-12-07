package com.momate.rest.test.dao;

import com.momate.rest.test.model.Reminder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class ReminderDao {

    List<Reminder> reminders = new ArrayList<>();

    @PostConstruct
    private void init() {
        Reminder r1 = new Reminder();
        r1.setId(1L);
        r1.setTitle("TestTitle1");

        Reminder r2 = new Reminder();
        r2.setId(2L);
        r2.setTitle("TestTitle2");

        Reminder r3 = new Reminder();
        r3.setId(3L);
        r3.setTitle("TestTitle3");

        reminders.add(r1);
        reminders.add(r2);
        reminders.add(r3);
    }

    public List<Reminder> findAll() {

        return reminders;
    }

    public Reminder findReminderById(Long ID) {
        for (Reminder r : reminders) {
            if (ID.equals(r.getId())) {
                return r;
            }
        }
        return null;
    }

    public void save(Reminder r) {
        reminders.add(r);
    }

}
