package ru.geekbrains.shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/not_found_error")
public class NotFoundServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        if (res.getStatus() == 404){
            res.setContentType("text/html");
            res.getWriter().println("<h1>Not Found Page. Error code 404.</h1>");
        }
    }
}
