package lesson.thr;

import java.lang.reflect.Method;

/**
 * Created by steve on 12/10/15.
 */
public class ClassEx {
    public static void main(String[] args) {
        ClassEx thr = new ClassEx();
        Class c = ClassEx.class;
        Method[] m = c.getMethods();
        for (Method el: m)
            System.out.println(el);


        System.out.println(ClassEx.class.getName());

        System.out.println(thr.getClass().getCanonicalName());
    }

    public <T extends Number> void setData(T t){

    }
}

