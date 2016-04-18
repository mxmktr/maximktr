package lesson.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by steve on 11/4/15.
 */
public class Property {
    public static void main(String[] args) {
        FileWriter fw = null;
        FileReader fr = null;
        try {
            fw = new FileWriter("data/text.txt", true);
//            fw.flush();
            Properties properties = new Properties();
            properties.store(fw, "data=data1");
            properties.store(fw, "march=spring");
            fr = new FileReader("data/text.txt");
            properties.load(fr);
            System.out.println(properties.getProperty("data"));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
