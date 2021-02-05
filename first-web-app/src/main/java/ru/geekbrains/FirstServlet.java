package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class FirstServlet implements Servlet {

    private static final Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("FirstServlet is initialized");
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("New request to FirstServlet");
<<<<<<< HEAD

        req.setAttribute("pageHeader", "Привет от сервлета!!!");
        config.getServletContext().getRequestDispatcher("/page_header").forward(req, res);

        res.getWriter().println("<h1>Hello from servlet!!!</h1>");
=======
        res.getWriter().println("<h1>Hello from servlet!</h1>");
>>>>>>> 96a09a2de050ef12a718356956c91f0b3fb22b1c
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
