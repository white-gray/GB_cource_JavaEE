package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HeadPage", urlPatterns = "/HeadPage")
public class HeadPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("<link rel='stylesheet' href='" + req.getServletContext().getContextPath() + "/css/style.css'>");
        resp.getWriter().printf("<ul>");
        resp.getWriter().printf("<li><a href='" + req.getServletContext().getContextPath() + "/PageMain'>Начало</a></li>");
        resp.getWriter().printf("<li><a href='" + req.getServletContext().getContextPath() + "/PageCatalog'>Каталог</a></li>");
        resp.getWriter().printf("<li><a href='" + req.getServletContext().getContextPath() + "/PageProduct'>Продукты</a></li>");
        resp.getWriter().printf("<li><a href='" + req.getServletContext().getContextPath() + "/PageCart'>Корзинка</a></li>");
        resp.getWriter().printf("<li><a href='" + req.getServletContext().getContextPath() + "/PageOrder'>Заказы</a></li>");
        resp.getWriter().printf("<li><a href='" + req.getServletContext().getContextPath() + "/Calculator'>Калькулятор</a></li>");
        resp.getWriter().printf("</ul>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().printf("<h1>New POST request</h1>");
    }
}
