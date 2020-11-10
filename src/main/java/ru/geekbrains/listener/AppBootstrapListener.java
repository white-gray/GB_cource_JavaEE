package ru.geekbrains.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.ToDo;
import ru.geekbrains.persist.ToDoRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class AppBootstrapListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(AppBootstrapListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Initializing application");

        ServletContext sc = sce.getServletContext();
        String jdbcConnectionString = sc.getInitParameter("jdbcConnectionString");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        try {
            Connection connection = DriverManager.getConnection(jdbcConnectionString, username, password);
            sc.setAttribute("jdbcConnection", connection);

            ToDoRepository toDoRepository = new ToDoRepository(connection);
            sc.setAttribute("todoRepository", toDoRepository);

            if (toDoRepository.findAll().size() == 0) {
                toDoRepository.insert(new ToDo(-1L, "вещь1", 33, 4, "прекрасная вещь!"));
                toDoRepository.insert(new ToDo(-1L, "вещь2", 12, 1, "так себе..."));
                toDoRepository.insert(new ToDo(-1L, "вещь3", 123, 44, "впечатляет!"));
                toDoRepository.insert(new ToDo(-1L, "вещь4", 1234, 445, "их много"));
                toDoRepository.insert(new ToDo(-1L, "вещь5", 1, 132, "преКраснс она! Т.е. именно красная!!"));
                toDoRepository.insert(new ToDo(-1L, "вещь6", 126, 66, "оно того стоит"));
                toDoRepository.insert(new ToDo(-1L, "вещь7", 22, 4, "пригодится!"));
                toDoRepository.insert(new ToDo(-1L, "вещь8", 67, 56, "неясно зачем нужна"));
                toDoRepository.insert(new ToDo(-1L, "вещь9", 93, 2, "отлично лежит!"));
            }
        } catch (SQLException ex) {
            logger.error("Can't initialize JDBC connection", ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Closing JDBC connection");

        ServletContext sc = sce.getServletContext();
        Connection connection = (Connection) sc.getAttribute("jdbcConnection");

        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException ex) {
            logger.error("Can't close JDBC connection", ex);
        }
    }
}
