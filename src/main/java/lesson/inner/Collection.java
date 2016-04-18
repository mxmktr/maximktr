package lesson.inner;

/**
 * Created by steve on 1/6/16.
 */
public class Collection<T extends Object> {

    private Object[] array = null;
    private int count;
    private int number;

    public Collection(int n) {
        if (n == 0)
            array = new Object[5];
        array = new Object[n];
        count = array.length;
    }

    public void add(T data){
        if (number < count){
            array[number] = data;
            number++;
        }
    }

    public Object[] getArray() {
        return array;
    }

    public Iterator<T> getForward(){
        return new Forward<T>();
    }


    public class Forward<T> implements Iterator<T>{

        private int position = 0;

        public boolean hasNext() {
            return position < count;
        }

        public T next() {
            return (T)array[position++];
        }
    }
}
