package lesson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by steve on 10/23/15.
 */
public class ListOfNumbers {

    private ArrayList<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        Random rnd = new Random();
        for (int i = 0; i < SIZE; i++) {
            list.add(Integer.valueOf(rnd.nextInt(20)));
        }
    }

    public ArrayList<Integer> getList(){
        return list;
    }

    public void writeList() {
        // The FileWriter constructor throws IOException, which must be caught.
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("OutFile.txt"), true);
            for (int i = 0; i < SIZE; i++) {
                // The get(int) method throws IndexOutOfBoundsException, which must be caught.
                out.println("Value at: " + i + " = " + list.get(i));
            }
            out.close();
        } catch (IOException  e){
            System.err.println("Catch IOException! " + e.getMessage());
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
