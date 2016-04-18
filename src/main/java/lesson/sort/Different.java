package lesson.sort;

import java.util.*;

/**
 * Created by steve on 3/9/16.
 */
public class Different {

    public Integer getRandomInt(int min, int max){
        return (int)(Math.random()*(max - min +1)) + min;
    }

    public static void main(String[] args) {

        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        Integer[] array = {1, 3, 5, 6, 11, 9};
        List<Integer> list = Arrays.asList(array);

        map.put("first", list);

        System.out.println(map);
        List<Integer> list1 = map.get("first");
        System.out.println(list1);

        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(array));
        list2.add(44);
        System.out.println(list2);

        System.out.println(new Different().getClass() == Different.class);

    }
}
