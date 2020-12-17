/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.momate.rest.test.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.momate.rest.test.dao.ReminderDao;
import com.momate.rest.test.model.Reminder;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

@Path("reminder")
@Consumes("application/json")
@Produces("application/json")
public class ReminderResource {

    @Inject
    private ReminderDao dao;

    @GET
    public Response getAllReminders() {
        List<Reminder> entityList = dao.findAll();
        return Response.status(200)
                .entity(entityList)
                .build();
    }

    @GET
    @Path("{id}")
    public Response getReminderById(@PathParam("id") long ID) {
        Reminder entity = dao.findReminderById(ID);
        return Response.status(200)
                .entity(entity)
                .build();
    }

    @POST
    public Response addReminder(Reminder r) {
        dao.save(r);
        return Response.status(201)
                .entity(r)
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteReminder(@PathParam("id") String ID) {
        Reminder entity = dao.findReminderById(Long.parseLong(ID));
        dao.delete(entity);
        return Response.status(204).build();
    }

    @PUT
    @Path("{id}")
    public Response updateReminder(@PathParam("id") long ID, Reminder reminder) {
        dao.update(ID, reminder);
        return Response.status(200)
                .entity(dao.findReminderById(ID))
                .build();
    }
}
