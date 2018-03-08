package by.tc.task05.service;

import by.tc.task05.entity.Food;
import by.tc.task05.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Дима on 05.03.2018.
 */
public interface XMLParserService {

    List<Food> parse(String typeOfParser) throws ServiceException;
    int getCountOfPages(String parseType, int itemsPerPage) throws ServiceException;
    List<Food> getRequiredPartOfItemsList(String itemsPerPage, String parserType, String pageNumber) throws ServiceException;
}
