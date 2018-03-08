package by.tc.task05.dao.command;

import by.tc.task05.dao.parser.SaxHandler;
import by.tc.task05.entity.Food;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Дима on 04.03.2018.
 */
public final class SAXExecutor implements ParserCommand {

    private SAXExecutor(){}

    private static SAXExecutor instance = new SAXExecutor();

    public static SAXExecutor getInstance() {
        return instance;
    }

    @Override
    public List execute(InputStream fileLocation) throws IOException, SAXException {

        XMLReader reader = XMLReaderFactory.createXMLReader();
        SaxHandler handler = new SaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(fileLocation));

        List<Food> menu = handler.getFoodList();

        return menu;
    }
}
