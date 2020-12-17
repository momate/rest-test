package com.momate.rest.test.resources;

import com.momate.rest.test.service.UserService;
import com.momate.rest.test.model.User;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("user")
@Consumes("application/json")
@Produces("application/json")
public class UserResource {
    
    @Inject
    private UserService service;

    @GET
    public Response getAllReminders() {
        List<User> entityList = service.findAll();
        return Response.status(200)
                .entity(entityList)
                .build();
    }

    @GET
    @Path("{id}")
    public Response getReminderById(@PathParam("id") long ID) {
        User entity = service.findUserById(ID);
        return Response.status(200)
                .entity(entity)
                .build();
    }

    @POST
    public Response addReminder(User user) {
        service.save(user);
        return Response.status(201)
                .entity(user)
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteReminder(@PathParam("id") long ID) {
        User entity = service.findUserById(ID);
        service.delete(entity);
        return Response.status(204).build();
    }

    @PUT
    @Path("{id}")
    public Response updateReminder(@PathParam("id") long ID, User user) {
        service.update(ID, user);
        return Response.status(200)
                .entity(user)
                .build();
    }

}
