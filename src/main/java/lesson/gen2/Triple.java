package lesson.gen2;

/**
 * Created by steve on 3/1/16.
 */
public class Triple<E, T, C> extends Double<E, T> {

    public final C c;

    public Triple(E e, T t, C c) {
        super(e, t);
        this.c = c;
    }
}
