package ru.geekbrains.shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/page_header")
public class PageHeaderServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().println("<ul>");
        res.getWriter().println("<li><a href = '" + req.getContextPath() + "/main'>Главная</a></li>");
        res.getWriter().println("<li><a href = '" + req.getContextPath() + "/catalog'>Каталог</a></li>");
        res.getWriter().println("<li><a href = '" + req.getContextPath() + "/product'>Продукт</a></li>");
        res.getWriter().println("<li><a href = '" + req.getContextPath() + "/cart'>Корзина</a></li>");
        res.getWriter().println("<li><a href = '" + req.getContextPath() + "/order'>Заказ</a></li>");
        res.getWriter().println("</ul>");

    }
}
