package by.tc.task05.dao;

/**
 * Created by Дима on 05.03.2018.
 */
public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final XMLParserDAO parserDAO = new XMLParserDAOImpl();

    private DAOFactory() {}

    public XMLParserDAO getParserDAO() {
        return parserDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }

}