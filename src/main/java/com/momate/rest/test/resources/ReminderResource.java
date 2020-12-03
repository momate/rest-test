/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.momate.rest.test.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.momate.rest.test.dao.ReminderDao;
import com.momate.rest.test.model.Reminder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

@Path("reminder")
public class ReminderResource {

    ReminderDao dao = new ReminderDao();

    @GET
    @Produces("application/json")
    public List<Reminder> getAllReminders() {
        return dao.findAll();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Reminder getReminderById(@PathParam("id") String ID) {
        return dao.findReminderById(Long.parseLong(ID));

    }

    @POST
    @Consumes("application/json")
    public void addReminder(Reminder r,
            @Context HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("Success...");
        dao.save(r);
    }

}
