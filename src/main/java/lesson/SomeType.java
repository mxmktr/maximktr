package lesson;

import java.util.*;

/**
 * Created by steve on 11/2/15.
 */
public class SomeType<T> {

    public <E> void test(Collection<E> collection){
        for (E e: collection){
            System.out.println(e);
        }
    }

    public void test(List<Integer> integerList){
        for (Integer integer: integerList){
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        SomeType<?> someType = new SomeType<Object>();
        List<String> list = Arrays.asList("string");
        someType.test(list);

        List<String> l = new ArrayList<String>();
        List<? extends Object> object = l;


    }
}
