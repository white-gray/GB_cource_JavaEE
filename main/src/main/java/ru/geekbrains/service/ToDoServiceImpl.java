package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.ToDo;
import ru.geekbrains.persist.ToDoRepository;
import ru.geekbrains.rest.ToDoServiceRs;

import javax.ejb.*;
import javax.jws.WebService;
import java.util.List;
import java.util.concurrent.Future;

@Stateless
@WebService(endpointInterface = "ru.geekbrains.service.ToDoServiceWs", serviceName = "ToDoService")
public class ToDoServiceImpl implements ToDoServiceLocal, ToDoServiceRemote, ToDoServiceWs, ToDoServiceRs {

    private static final Logger logger = LoggerFactory.getLogger(ToDoServiceImpl.class);

    @EJB
    private ToDoRepository toDoRepository;

    @TransactionAttribute
    @Override
    public void insert(ToDoRepr toDoRepr) {
        toDoRepository.insert(new ToDo(null, toDoRepr.getName(), toDoRepr.getPrice(), toDoRepr.getQuantity(), toDoRepr.getDescription()));
    }

    @TransactionAttribute
    @Override
    public void update(ToDoRepr toDoRepr) {
        toDoRepository.update(new ToDo(toDoRepr.getId(), toDoRepr.getName(), toDoRepr.getPrice(), toDoRepr.getQuantity(), toDoRepr.getDescription()));
    }

    @Override
    public ToDoRepr delete(Long id) {
        return null;
    }

    @TransactionAttribute
    @Override
    public void delete(long id) {
        toDoRepository.delete(id);
    }

    @Override
    public ToDoRepr findById(long id) {
        return toDoRepository.findToDoReprById(id);
    }

    @Override
    public ToDoRepr findById(Long id) {
        return toDoRepository.findToDoReprById(id);
    }

    @Override
    public ToDoRepr findByName(String name) {
        return toDoRepository.findToDoReprByName(name);
    }

    @Override
    public List<ToDoRepr> findAll() {
        return toDoRepository.findAllToDoRepr();
    }

    @Asynchronous
    @Override
    public Future<ToDoRepr> findByIdAsync(long id) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(toDoRepository.findToDoReprById(id));
    }
}
