package lesson.logger4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by steve on 3/22/16.
 */
public class Application {

    private static final Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) throws IOException {
//        log.setLevel(Level.WARN);

        log.debug("Debug Message!");
        log.info("Info Message!", new Exception());
        log.warn("Warn Message!");
        log.error("Error Message!");
        log.fatal("Fatal Message!");


        File file = new File("/home/steve/IdeaProjects/Max/src/main/resources/max.properties");
        System.out.println(file.isFile());

        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        System.out.println(properties.getProperty("dima"));

    }
}
