package by.tc.task05.controller;

import by.tc.task05.controller.command.ActionCommand;
import by.tc.task05.controller.command.ActionCommandDirector;
import by.tc.task05.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Дима on 04.03.2018.
 */
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        ActionCommandDirector director = new ActionCommandDirector();
        ActionCommand command = director.getCommand(request.getParameter("action"));

        String url = null;

        RequestDispatcher dispatcher = null;

        try {
            url = command.execute(request);
            dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            request.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}