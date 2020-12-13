package ru.geekbrains;

import ru.geekbrains.persist.ToDoCategory;
import ru.geekbrains.service.ToDoRepr;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.print.attribute.standard.Destination;
import javax.resource.cci.ConnectionFactory;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

public class JmsClient {

    public static void main(String[] args) throws IOException, NamingException {
        Context context = createInitialContext();

        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
        JMSContext jmsContext = connectionFactory.createContext("jms-user", "jms-User");

        Destination dest = (Destination) context.lookup("jms/queue/toDoQueue");

        JMSProducer producer = jmsContext.createProducer();

        ObjectMessage msg = jmsContext.createObjectMessage(new ToDoRepr(null, "Study JMS lesson", LocalDate.now(),
                new ToDoCategory(1L)));

        producer.send(dest, msg);

    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EjbClient.class.getClassLoader().getResourceAsStream("wildfly-jndi.properties"));
        return new InitialContext(env);
    }
}
