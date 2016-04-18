package lesson.logger;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by steve on 10/26/15.
 */
public class Logg {

    private static final Logger LOGGER = Logger.getLogger(Logg.class.getName());

    static {
        try {
            Handler fileHandler = new FileHandler("logg.%u.%g.txt");
            Handler consoleHandler = new ConsoleHandler();

            Formatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            consoleHandler.setFormatter(formatter);

            LOGGER.addHandler(fileHandler);
            LOGGER.addHandler(consoleHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Logger getLogger(){
        return LOGGER;
    }
}
