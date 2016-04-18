package lesson.inner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by steve on 1/13/16.
 */
public class CollMain {
    public static void main(String[] args) {


        List<String> list = new ArrayList<String>();


        Collection<String> collection = new Collection<String>(4);

        System.out.println(Arrays.toString(collection.getArray()));

        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("ddd");
        collection.add("fff");

        System.out.println(Arrays.toString(collection.getArray()));

        Iterator iterator = collection.getForward();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Iterator itera = collection.getForward();
        while (itera.hasNext()){
            System.out.println(itera.next());
        }

        Collection<String>.Forward<String> f = collection.new Forward<String>();
        while (f.hasNext()){
            System.out.println(f.next());
        }

    }
}
