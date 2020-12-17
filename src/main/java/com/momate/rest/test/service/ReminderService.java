package com.momate.rest.test.service;

import com.momate.rest.test.model.dao.DatabaseClass;
import com.momate.rest.test.model.Reminder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class ReminderService {

    List<Reminder> reminders = DatabaseClass.getReminders();

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

    public List<Reminder> findAllPaginated(int start, int size) {
        if (start + size > reminders.size()) {
            return new ArrayList<>();
        }
        return reminders.subList(start, start + size);
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

    public void delete(Reminder r) {
        reminders.remove(r);
    }

    public void update(long ID, Reminder r) {
        int index = reminders.indexOf(findReminderById(ID));
        reminders.add(index, r);
    }

}