package by.tc.task05.dao.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дима on 04.03.2018.
 */
public class ParserCommandDirector {

    private Map<String, ParserCommand> commands = new HashMap<>();

    public ParserCommandDirector() {
        commands.put("sax", SAXExecutor.getInstance());
        commands.put("stax", StAXExecutor.getInstance());
        commands.put("dom", DOMExecutor.getInstance());
    }

    public ParserCommand getCommand(String typeOfParser) {
        ParserCommand parserCommand;
        parserCommand = commands.get(typeOfParser);
        return parserCommand;
    }
}