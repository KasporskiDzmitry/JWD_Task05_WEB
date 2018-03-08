package by.tc.task05.dao.parser;

import by.tc.task05.entity.BreakfastMenuTagName;
import by.tc.task05.entity.Food;
import by.tc.task05.entity.XMLStreamConstants;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дима on 04.03.2018.
 */
public class StAXHandler implements XMLStreamConstants {
    public static List<Food> process(XMLStreamReader reader) throws XMLStreamException {
        List<Food> menu = new ArrayList<>();
        Food food = null;
        BreakfastMenuTagName tagName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    tagName = BreakfastMenuTagName.getElementTagName(reader.getLocalName());
                    switch (tagName) {
                        case FOOD:
                            food = new Food();
                            Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            food.setId(id);
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();

                    if(text.isEmpty()) {
                        break;
                    }
                    switch (tagName) {
                        case NAME:
                            food.setName(text);
                            break;
                        case PRICE:
                            food.setPrice(text);
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    tagName = BreakfastMenuTagName.getElementTagName(reader.getLocalName());
                    switch (tagName) {
                        case FOOD:
                            menu.add(food);
                    }
            }
        }
        return menu;
    }
}