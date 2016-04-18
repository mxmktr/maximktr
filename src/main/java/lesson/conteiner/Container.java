package lesson.conteiner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by steve on 11/2/15.
 */
public class Container{


    public static void showList(Collection<? extends Object> from){
        for (Object f: from){
            System.out.println(f);
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        list.add(2);
        list.add(3);
        list.add(4);

        showList(list);
    }

}
