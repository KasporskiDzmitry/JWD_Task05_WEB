package by.tc.task05.dao.command;

import by.tc.task05.entity.Food;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дима on 04.03.2018.
 */
public final class DOMExecutor implements ParserCommand {

    private DOMExecutor(){}

    private static DOMExecutor instance = new DOMExecutor();

    public static DOMExecutor getInstance() {
        return instance;
    }

    @Override
    public List<Food> execute(InputStream fileLocation) throws IOException, SAXException {
        InputSource pathToFile = new InputSource(fileLocation);
        DOMParser parser = new DOMParser();
        parser.parse(pathToFile);
        Document document = parser.getDocument();

        Element root = document.getDocumentElement();

        List<Food> menu = new ArrayList<>();

        NodeList foodNodes = root.getElementsByTagName("food");
        Food food = null;
        for (int i = 0; i < foodNodes.getLength(); i++) {
            food = new Food();
            Element foodElement = (Element) foodNodes.item(i);

            food.setId(Integer.parseInt(foodElement.getAttribute("id")));
            food.setName(getSingleChild(foodElement, "name").getTextContent().trim());
            food.setPrice(getSingleChild(foodElement, "price").getTextContent().trim());

            menu.add(food);
        }
        return menu;
    }
    private static Element getSingleChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return  child;
    }
}
