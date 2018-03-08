package by.tc.task05.controller.command;

import by.tc.task05.entity.Food;
import by.tc.task05.service.ServiceFactory;
import by.tc.task05.service.XMLParserService;
import by.tc.task05.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Дима on 08.03.2018.
 */
public final class ParseActionCommand implements ActionCommand{

    private ParseActionCommand(){}

    private static ParseActionCommand instance = new ParseActionCommand();

    public static ParseActionCommand getInstance() {
        return instance;
    }


    @Override
    public String execute(HttpServletRequest request) throws ServiceException{
        ServiceFactory factory = ServiceFactory.getInstance();
        XMLParserService parserService = factory.getParserService();

        String parserType = request.getParameter("parserType");
        List<Food> menu = null;

        menu = parserService.getRequiredPartOfItemsList(request.getParameter("parserType"),
                                                        request.getParameter("pageNumber"),
                                                        request.getParameter("itemsPerPage"));

        int countOfPages = parserService.getCountOfPages(parserType, Integer.parseInt(request.getParameter("itemsPerPage")));

        request.setAttribute("menu", menu);
        request.setAttribute("countOfPages", countOfPages);
        request.setAttribute("pageNumber", setPage(request));
        request.setAttribute("parserType", request.getParameter("parserType"));
        request.setAttribute("action", request.getParameter("action"));
        request.setAttribute("itemsPerPage", request.getParameter("itemsPerPage"));

        return "/WEB-INF/jsp/parsingResult.jsp";
    }

    private int setPage(HttpServletRequest request){
        if (request.getParameter("pageNumber") != null) {
            return Integer.parseInt(request.getParameter("pageNumber"));
        } else {
            return 1;
        }
    }
}