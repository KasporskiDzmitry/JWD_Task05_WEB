package by.tc.task05.dao;

import by.tc.task05.dao.exception.DAOException;
import by.tc.task05.entity.Food;
import java.util.List;

/**
 * Created by Дима on 05.03.2018.
 */
public interface XMLParserDAO {

    List<Food> parse(String typeOfParser) throws DAOException;
}
