package by.tc.task05.dao;

import by.tc.task05.dao.command.ParserCommand;
import by.tc.task05.dao.command.ParserCommandDirector;
import by.tc.task05.dao.exception.DAOException;
import by.tc.task05.entity.Food;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Дима on 05.03.2018.
 */
public class XMLParserDAOImpl implements XMLParserDAO {
    @Override
    public List<Food> parse(String typeOfParser) throws DAOException {
        ParserCommandDirector director = new ParserCommandDirector();
        ParserCommand command = director.getCommand(typeOfParser);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fileLocation = classLoader.getResourceAsStream("/breakfast-menu.xml");

        List menu = null;
        try {
            menu = command.execute(fileLocation);
        } catch (IOException e) {
            throw new DAOException("Ошибка при работе с файлом", e);
        } catch (SAXException e) {
            throw new DAOException("Ошибка при парсинге", e);
        } finally {
            try {
                fileLocation.close();
            } catch (IOException e) {
                throw new DAOException("Ошибка при закрытии файла", e);
            }
        }
        return menu;
    }
}