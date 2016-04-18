package lesson.io;

import java.io.*;

/**
 * Created by steve on 11/4/15.
 */
public class IO {
    public static void main(String[] args) {
        DataInputStream dis = null;
        StringBuilder sb = new StringBuilder();
        try {
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream("data/data.txt")));
            int length = dis.available();
            byte[] data = new byte[length];
            dis.readFully(data);

            for (byte a: data){
                sb.append((char)a);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sb.toString());
    }
}
