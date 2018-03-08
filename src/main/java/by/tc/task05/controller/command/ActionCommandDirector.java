package by.tc.task05.controller.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дима on 07.03.2018.
 */
public class ActionCommandDirector {

    private Map<String, ActionCommand> commands = new HashMap<>();

    public ActionCommandDirector() {
        commands.put("parse", ParseActionCommand.getInstance());
        commands.put("home", HomeActionCommand.getInstance());
    }

    public ActionCommand getCommand(String action) {
        ActionCommand actionCommand;
        actionCommand = commands.get(action);
        return actionCommand;
    }
}
