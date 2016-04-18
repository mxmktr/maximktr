package lesson.gen4;

import java.util.Arrays;

/**
 * Created by steve on 3/11/16.
 */
public class TestMyEnum {



    public static void main(String[] args) {

        MyEnum color = MyEnum.Yellow;

        System.out.println(color.getId());

        System.out.println(Arrays.toString(MyEnum.values()));

        System.out.println(color);



    }
}
