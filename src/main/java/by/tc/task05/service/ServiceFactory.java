package by.tc.task05.service;

/**
 * Created by Дима on 05.03.2018.
 */
public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final XMLParserService parserService = new XMLParserServiceImpl();

    private ServiceFactory() {}

    public XMLParserService getParserService() {
        return parserService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}