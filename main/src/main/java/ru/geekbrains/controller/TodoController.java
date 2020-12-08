package ru.geekbrains.controller;

import ru.geekbrains.service.CartService;
import ru.geekbrains.service.ToDoRepr;
import ru.geekbrains.service.ToDoServiceLocal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TodoController implements Serializable {

    @Inject
    private ToDoServiceLocal toDoService;


    @EJB
    private CartService cartService;
    private ToDoRepr todo;

   private List<ToDoRepr> todos;

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        this.todos = toDoService.findAll();
    }

    public List<ToDoRepr> getAllTodos()  {
        return todos;
    }

    public ToDoRepr getTodo() {
        return todo;
    }

    public void setTodo(ToDoRepr todo) {
        this.todo = todo;
    }

    public String editTodo(ToDoRepr todo) {
        this.todo = todo;
        return "/todo.xhtml?faces-redirect=true";
    }

    public void deleteTodo(ToDoRepr toDo) {
        toDoService.delete(toDo.getId());
    }

    public String saveTodo()  {
        if (todo.getId() == null) {
            toDoService.insert(todo);
        } else {
            toDoService.update(todo);
        }
        return "/PageCatalog.xhtml?faces-redirect=true";
    }

    public String createTodo() {
        this.todo = new ToDoRepr();
        return "/todo.xhtml?faces-redirect=true";
    }

}
