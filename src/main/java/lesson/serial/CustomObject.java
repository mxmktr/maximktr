package lesson.serial;

import java.io.Serializable;

/**
 * Created by steve on 12/11/15.
 */
public class CustomObject implements Serializable {

    private transient boolean b = true;

    @Override
    public String toString() {
        return "CustomObject{" +
                "b=" + b +
                '}';
    }
}
