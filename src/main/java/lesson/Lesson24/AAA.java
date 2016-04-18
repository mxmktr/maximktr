package lesson.Lesson24;

public class AAA {

    private static int foo1() {
        try {
            System.out.println("один");
            throw new RuntimeException();
        } finally {
            System.out.println("два");
        }
    }

    private static int foo2() {
        try {
            System.out.println(0);
            return 10;
        } finally {
            System.out.println(1);
        }
    }

    private static int foo3()  {
        try {
            System.out.println(0);
            return 10;
        } finally {
            System.out.println(1);
            return 20;
        }
    }

    public static void main(String[] args) {
        System.out.println(foo3());
    }
}
