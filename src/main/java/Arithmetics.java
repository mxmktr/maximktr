import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Arithmetics {

    public double add(double a, double b){
        return a + b;
    }

    public double mult(double a, double b){
        return a*b;
    }

    public double division(double a, double b){
        return a/b;
    }

    public static void main(String[] args) {

        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");

        String s4 = s1.intern();
        // сравниваем наши строки
        System.out.println("s1 == s2 : " + ( s1 == s2 ) );
        System.out.println("s1 == s3 : " + ( s1 == s3 ) );
        System.out.println("s1 == s4 : " + ( s1 == s4 ) );

        String first = "Hello    world!";
        System.out.println(Arrays.toString(first.split("\\s+")));

        System.out.println(first.substring(6, 7));

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
        System.out.println(sdf.format(new Date()));

    }
}
