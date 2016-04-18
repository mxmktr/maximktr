package lesson.serial;

import java.io.*;

/**
 * Created by steve on 12/11/15.
 */
public class Operation {
    public static void main(String[] args) {
        DataObject dataObject = new DataObject();
        dataObject.setMyData("dmfgvdsmgvfakdvkjsxdacvkzxcjvk");

        File file = new File("data/store.bin");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(dataObject);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("data/store.bin")));
            Object o = ois.readObject();
            if (DataObject.class.getCanonicalName().equalsIgnoreCase(o.getClass().getCanonicalName())) {
                DataObject d = (DataObject) o;
                System.out.println(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
