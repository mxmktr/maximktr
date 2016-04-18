package lesson.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by steve on 12/11/15.
 */
public class DataObject extends NonSeriablizle implements Serializable{

    private int i = 5;
    private String s = "aaa";
    private transient String[] def = {"aaa", "bbb"};
    private CustomObject b = new CustomObject();

    public DataObject(){
    }

    private void writeObject(ObjectOutputStream oos){
        try {
            oos.defaultWriteObject();
            oos.writeObject(getMyData());
            oos.writeObject(def);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois){
        try {
            ois.defaultReadObject();
            Object o = ois.readObject();
            setMyData((String)o);
            def = (String[])ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "DataObject{" +
                super.toString() +
                ", b=" + b +
                ", i=" + i +
                ", s='" + s + '\'' +
                ", def=" + Arrays.toString(def) +
                '}';
    }
}
