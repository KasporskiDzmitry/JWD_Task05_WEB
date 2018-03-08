package by.tc.task05.service;

import by.tc.task05.dao.DAOFactory;
import by.tc.task05.dao.XMLParserDAO;
import by.tc.task05.dao.exception.DAOException;
import by.tc.task05.entity.Food;
import by.tc.task05.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Дима on 05.03.2018.
 */
public class XMLParserServiceImpl implements XMLParserService {

    private int countOfItems = 0;
    private int countOfPages = 0;

    @Override
    public List<Food> parse(String typeOfParser) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        XMLParserDAO parserDAO = factory.getParserDAO();

        List menu = null;

        try {
            menu = parserDAO.parse(typeOfParser);
            countOfItems = menu.size();
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return menu;
    }

    public int getCountOfPages(String parseType, int itemsPerPage) throws ServiceException{
        countOfPages = (int) Math.ceil(countOfItems * 1.0/ itemsPerPage);
        return countOfPages;
    }

    @Override
    public List<Food> getRequiredPartOfItemsList(String parserType, String pageNumber, String itemsPerPage) throws ServiceException {
        List<Food> requiredList = parse(parserType);

        int pNumber = Integer.parseInt(pageNumber);
        int iPPage = Integer.parseInt(itemsPerPage);

        int startIndex = iPPage*(pNumber-1);
        int finishIndex = startIndex+iPPage;

        if (pNumber == countOfPages) {
            return requiredList.subList(startIndex, requiredList.size());
        } else if (pNumber > 1) {
            return requiredList.subList(startIndex, finishIndex);
        } else {
            return requiredList.subList(0, iPPage);
        }
    }
}
