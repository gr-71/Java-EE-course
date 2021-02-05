package ru.geekbrains.shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/forbidden_error")
public class ForbiddenServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (res.getStatus() == 403){
            res.setContentType("text/html");
            res.getWriter().println("<h1>Forbidden to visit. Error code 403.</h1>");
        }
    }
}
