package by.tc.task05.dao.command;

import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Дима on 04.03.2018.
 */
public interface ParserCommand {

    List execute(InputStream fileLocation) throws IOException, SAXException;
}
