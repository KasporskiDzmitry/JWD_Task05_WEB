package by.tc.task05.dao.parser;

import by.tc.task05.entity.BreakfastMenuTagName;
import by.tc.task05.entity.Food;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дима on 04.03.2018.
 */
public class SaxHandler extends DefaultHandler {
    private List<Food> foodList = new ArrayList<>();
    private Food food;
    private StringBuilder text;

    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (qName.equals("food")) {
            food = new Food();
            food.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        BreakfastMenuTagName tagName = BreakfastMenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName) {
            case NAME:
                food.setName(text.toString());
                break;
            case PRICE:
                food.setPrice(text.toString());
                break;
            case FOOD:
                foodList.add(food);
                food = null;
                break;
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.err.println("WARNING: line: " + e.getLineNumber() + ": " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.err.println("ERROR: line: " + e.getLineNumber() + ": " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println("FATAL: line: " + e.getLineNumber() + ": " + e.getMessage());
        throw (e);
    }
}
