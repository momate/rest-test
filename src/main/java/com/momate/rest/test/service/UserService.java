package com.momate.rest.test.service;

import com.momate.rest.test.exception.DataNotFoundException;
import com.momate.rest.test.model.dao.DatabaseClass;
import com.momate.rest.test.model.User;
import java.util.List;
import javax.ejb.Singleton;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Singleton
public class UserService {

    List<User> users = DatabaseClass.getUsers();

    public List<User> findAll() {

        return users;
    }

    public User findUserById(Long ID) {
        for (User r : users) {
            if (ID.equals(r.getId())) {
                return r;
            } else {
                throw new DataNotFoundException("User with id" + ID + " not found.");
            }
        }
        return null;
    }

    public void save(User r) {
        users.add(r);
    }

    public void delete(User r) {
        users.remove(r);
    }

    public void update(long ID, User r) {
        int index = users.indexOf(findUserById(ID));
        users.add(index, r);
    }

}
