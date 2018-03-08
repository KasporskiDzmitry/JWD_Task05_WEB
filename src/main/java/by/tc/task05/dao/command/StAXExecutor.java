package by.tc.task05.dao.command;

import by.tc.task05.dao.parser.StAXHandler;
import by.tc.task05.entity.Food;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Дима on 04.03.2018.
 */
public final class StAXExecutor implements ParserCommand {

    private StAXExecutor(){}

    private static StAXExecutor instance = new StAXExecutor();

    public static StAXExecutor getInstance() {
        return instance;
    }

    @Override
    public List execute(InputStream fileLocation) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileLocation);

            XMLOutputFactory factory = XMLOutputFactory.newInstance();

            List<Food> menu = StAXHandler.process(reader);

            return menu;
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }
}
