package lesson.gen3;

/**
 * Created by steve on 3/1/16.
 */
public class Boss {

    private static int count = 0;
    private final int id = count++;

    public void print(){
        System.out.println(this.getClass() == Boss.class);

    }

    class Son{

        public void print(){

            Boss.this.print();
        }

    }


    public static void main(String[] args) {
        Boss b = new Boss();
        Boss.Son son = b.new Son();
        son.print();

    }

}
