package by.tc.task05.controller.command;

import by.tc.task05.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Дима on 07.03.2018.
 */
public interface ActionCommand {

    String execute(HttpServletRequest request) throws ServiceException;
}
