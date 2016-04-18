package lesson.singlton;

public class SinglTest {
    public static void main(String[] args) {

        Singl singl = Singl.getInstance();
        System.out.println(singl.getArr());


        Singl s = Singl.getInstance();
        System.out.println(s.getArr());


    }
}
