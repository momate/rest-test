package com.momate.rest.test.service;

import com.momate.rest.test.exception.DataNotFoundException;
import com.momate.rest.test.model.dao.DatabaseClass;
import com.momate.rest.test.model.Reminder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class ReminderService {

    List<Reminder> reminders = DatabaseClass.getReminders();

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
            } else {
                throw new DataNotFoundException("Reminder with id " + ID + " not found.");
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
