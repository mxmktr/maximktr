package lesson.inner;

/**
 * Created by steve on 1/13/16.
 */
public class AAA {
    
    public FFF getBBB(){
        return new BBB();
    }

    static class BBB implements FFF{
        private int a;
        private int b;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int summ(){
            return a + b;
        }
    }
}
