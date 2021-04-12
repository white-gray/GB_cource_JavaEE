package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageOrder", urlPatterns = "/PageOrder")
public class PageOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/HeadPage").include(req, resp);
        resp.getWriter().printf("<div><br><br><h1 align='center'>Оформлени заказа:</h1></div>");
		req.getServletContext().getRequestDispatcher("/PageOrder.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().printf("<h1>New POST request</h1>");
    }
}
