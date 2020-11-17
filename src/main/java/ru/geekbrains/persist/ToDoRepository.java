package ru.geekbrains.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Named
@ApplicationScoped
public class ToDoRepository {

    @Inject
    private ServletContext context;

    private Connection conn;

    @PostConstruct
    public void init() throws SQLException {
        this.conn = (Connection) context.getAttribute("jdbcConnection");
        createTableIfNotExists(conn);
    }

    public void insert(ToDo toDo) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into productes (name, price, quantity, description) values (?, ?, ?, ?);")) {

            stmt.setLong(1, toDo.getId());
            stmt.setString(2, toDo.getName());
            stmt.setFloat(3, toDo.getPrice());
            stmt.setLong(4, toDo.getQuantity());
            stmt.setString(5, toDo.getDescription());
            stmt.execute();
        }
    }

    public void update(ToDo toDo) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update productes set name = ?, price = ?, quantity = ?, description = ? where id = ?;")) {

                stmt.setString(1, toDo.getDescription());
            stmt.setLong(2, toDo.getQuantity());
            stmt.setFloat(3, toDo.getPrice());
            stmt.setString(4, toDo.getName());
            stmt.setLong(5, toDo.getId());
            stmt.execute();
        }
    }

    public void delete(Long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from productes where id = ?;")) {
            stmt.setLong(1, id);
            stmt.execute();
        }
    }

    public ToDo findById(Long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, name, price, quantity, description from productes where id = ?")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ToDo(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getLong(4), rs.getString(5));
            }
        }
        return new ToDo(-1L, "", 0.0f, -1L, "");
    }

    public List<ToDo> findAll() throws SQLException {
        List<ToDo> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id, name, price, quantity, description from productes");

            while (rs.next()) {
                res.add(new ToDo(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getLong(4), rs.getString(5)));
            }
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists productes (\n" +
                    "\tid int auto_increment primary key,\n" +
                    "    name varchar(25),\n" +
                    "    price float, \n" +
                    "    quantity long,\n" +
                    "    description varchar(25)\n" +
                    ");");

            }
    }
}
