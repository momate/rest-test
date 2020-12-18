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
import com.momate.rest.test.service.ReminderService;
import com.momate.rest.test.model.Reminder;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("reminder")
@Consumes("application/json")
@Produces("application/json")
public class ReminderResource {

    @Inject
    private ReminderService service;

    @GET
    public Response getAllReminders(@QueryParam("start") int start,
            @QueryParam("size") int size) {
        List<Reminder> entityList;
        if (start >= 0 && size > 0) {
            entityList = service.findAllPaginated(start, size);
        } else {
            entityList = service.findAll();
        }

        return Response.status(200)
                .entity(entityList)
                .build();
    }

//    @GET
//    @Path("annotationTest")
//    public String getParamsWithAnnotations(@QueryParam("param") String queryParam,
//            @MatrixParam("mparam") String matrixParam,
//            @HeaderParam("header") String headerParam,
//            @CookieParam("cookie") String cookieParam) {
//
//        return "Query param: " + queryParam
//                + " Matrix Param: " + matrixParam
//                + " Header Param: " + headerParam
//                + " Cookie Param: " + cookieParam;
//    }
    @GET
    @Path("{id}")
    public Response getReminderById(@PathParam("id") long ID) {
        Reminder entity = service.findReminderById(ID);
        return Response.status(200)
                .entity(entity)
                .build();
    }

    @POST
    public Response addReminder(Reminder reminder,
            @Context UriInfo uriInfo) {
        URI uri = uriInfo.getAbsolutePathBuilder().path(reminder.getId().toString()).build();
        System.out.println(uri);
        service.save(reminder);
        return Response.created(uri)
                .entity(reminder)
                .build();
    }
 
    @DELETE
    @Path("{id}")
    public Response deleteReminder(@PathParam("id") String ID) {
        Reminder entity = service.findReminderById(Long.parseLong(ID));
        service.delete(entity);
        return Response.status(204).build();
    }

    @PUT
    @Path("{id}")
    public Response updateReminder(@PathParam("id") long ID, Reminder reminder) {
        service.update(ID, reminder);
        return Response.status(200)
                .entity(service.findReminderById(ID))
                .build();
    }
}
