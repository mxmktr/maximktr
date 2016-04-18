package lesson.decorator;

import java.io.Serializable;

/**
 * Created by steve on 11/16/15.
 */
public interface ProjectItem extends Serializable{

    String EOL_STRING = System.getProperty("line.separator");

    double getTimeRequired();

}
