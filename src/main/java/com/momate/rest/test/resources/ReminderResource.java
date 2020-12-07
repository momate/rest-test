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
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Path("reminder")
public class ReminderResource {

    @Inject
    private ReminderDao dao;

    @GET
    @Produces("application/json")
    public Response getAllReminders() {
        List<Reminder> entityList = dao.findAll();
        return Response.status(200)
                .entity(entityList)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getReminderById(@PathParam("id") String ID) {
        Reminder entity = dao.findReminderById(Long.parseLong(ID));
        return Response.status(200)
                .entity(entity)
                .build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addReminder(Reminder r) {

        dao.save(r);
        return Response.status(200)
                .build();
    }

}
