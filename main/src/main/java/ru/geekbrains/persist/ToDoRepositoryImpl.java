package ru.geekbrains.persist;

import ru.geekbrains.service.ToDoRepr;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ToDoRepositoryImpl implements ToDoRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public void insert(ToDo toDo) {
        em.persist(toDo);
    }

    public void update(ToDo toDo) {
        em.merge(toDo);
    }

    public void delete(long id) {
        ToDo toDo = em.find(ToDo.class, id);
        if (toDo != null) {
            em.remove(toDo);
        }
    }

    public ToDo findById(long id) {
        return em.find(ToDo.class, id);
    }

    public List<ToDo> findAll() {
        return em.createQuery("from ToDo t", ToDo.class)
                .getResultList();
    }

    @Override
    public ToDoRepr findToDoReprById(long id) {
        return em.createQuery("select new ru.geekbrains.service.ToDoRepr(t.id, t.name, t.price, t.quantity, t.description) " +
                "from ToDo t " +
                "where t.id = id", ToDoRepr.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public ToDoRepr findToDoReprByName(String name) {
        return em.createQuery("select new ru.geekbrains.service.ToDoRepr(t.id, t.name, t.price, t.quantity, t.description) " +
                "from ToDo t " +
                "where t.name = name", ToDoRepr.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<ToDoRepr> findAllToDoRepr() {
        return em.createQuery("select new ru.geekbrains.service.ToDoRepr(t.id, t.name, t.price, t.quantity, t.description) " +
                "from ToDo t ", ToDoRepr.class).getResultList();
    }
}
