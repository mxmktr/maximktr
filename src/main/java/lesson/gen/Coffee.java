package lesson.gen;

/**
 * Created by steve on 3/1/16.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString(){
        return getClass().getCanonicalName() + " " + id;
    }

}
