package ru.geekbrains.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ToDoServiceWs {

    @WebMethod
    List<ToDoRepr> findAll();

    @WebMethod
    ToDoRepr findById (Long id);

    @WebMethod
    ToDoRepr findByName (String name);

    @WebMethod
    void insert (ToDoRepr toDoRepr);

    @WebMethod
    void update (ToDoRepr toDoRepr);

    @WebMethod
    ToDoRepr delete (Long id);
}
