package lesson.Lesson24;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by steve on 1/13/16.
 */
public class Lesson1 {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("aaa", 20);
        map.put("bbb", 25);
        map.put("ccc", 21);
        map.put("ddd", 14);
        System.out.println(map);


        System.out.println(map.entrySet());

    }
}
