package lesson.Lesson24;

import java.io.Serializable;

/**
 * Created by steve on 1/13/16.
 */
public class Lesson {
    private static int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }


    public LessonInner getLessonInner(){
        return new LessonInner();
    }



    private class LessonInner implements Serializable{

        private int b;

        public void setB(int b) {
            this.b = b;
        }

        public int getSumm(){
            return b + b;
        }
    }
}
