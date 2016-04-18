package lesson.gen3;

import java.util.Random;

/**
 * Created by steve on 3/1/16.
 */
public class MegaBoss extends Boss {

    private Random random = new Random(47);

    public void print(){
        System.out.println(random.nextDouble());
    }
}
