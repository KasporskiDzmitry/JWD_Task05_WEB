package by.tc.task05.controller.command;

import by.tc.task05.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Дима on 08.03.2018.
 */
public final class HomeActionCommand implements ActionCommand {

    private HomeActionCommand(){}

    private static HomeActionCommand instance = new HomeActionCommand();

    public static HomeActionCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request) throws ServiceException{
        return "/WEB-INF/jsp/home.jsp";
    }
}
