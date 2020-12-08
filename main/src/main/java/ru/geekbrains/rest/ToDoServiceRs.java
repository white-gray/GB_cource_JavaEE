package ru.geekbrains.rest;


import ru.geekbrains.service.ToDoRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/todo")
public interface ToDoServiceRs {
    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    void insert(ToDoRepr toDoRepr);

    @PUT
    @Consumes (MediaType.APPLICATION_JSON)
    void update(ToDoRepr toDoRepr);

    @DELETE
    @Path("/{id}")
    void delete(long id);

    @GET
    @Path("/{id}")
    @Produces (MediaType.APPLICATION_JSON)
    ToDoRepr findById(long id);

    @GET
    @Path("/{name}")
    @Produces (MediaType.APPLICATION_JSON)
    ToDoRepr findByName(String name);

    @GET
    @Path("/all")
    @Produces (MediaType.APPLICATION_JSON)
    List<ToDoRepr> findAll();
}
