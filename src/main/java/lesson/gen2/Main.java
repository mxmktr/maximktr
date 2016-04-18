package lesson.gen2;

/**
 * Created by steve on 3/1/16.
 */
public class Main {

    public static Double<EEE, TTT> returnDouble(){
        return new Double<>(new EEE(), new TTT());
    }

    public static void main(String[] args) {
        Double<EEE, TTT> ddd = returnDouble();
        ddd.e.print();
        ddd.t.print();
    }
}
