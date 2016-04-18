package lesson.gen2;

/**
 * Created by steve on 3/1/16.
 */
public class Double<E, T> {

    public final E e;
    public final T t;

    public Double(E e, T t) {
        this.e = e;
        this.t = t;
    }

    public E getE(){
        return e;
    }

    public T getT(){
        return t;
    }

}
