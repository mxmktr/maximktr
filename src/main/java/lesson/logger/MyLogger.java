package lesson.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by steve on 1/14/16.
 */
public class MyLogger {

    private Logger logger = null;

    public MyLogger() {
        Logg logg = new Logg();
        logger = logg.getLogger();
    }

    public void doIt(){
//        logger.entering(getClass().getName(), "doIt");

        try {
            throw new Exception();
        } catch (Exception ex){
            logger.info("_____________________________________________________________________");
            logger.log(Level.WARNING, "throw new Exception", ex);
            logger.info("_____________________________________________________________________");
            logger.logp(Level.WARNING, getClass().getName(), "doIt", "throw new Exception", ex);
        }

//        logger.exiting(getClass().getName(), "doIt");
    }

    public static void main(String[] args) {
        MyLogger myLogger = new MyLogger();
        myLogger.doIt();
    }
}
