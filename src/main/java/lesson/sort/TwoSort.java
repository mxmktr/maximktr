package lesson.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by steve on 11/9/15.
 */
public class TwoSort {
    public static void main(String[] args) {

        int[] arr = new int[10];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int count = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    count = j;
                }
            }
            if (i != count) {
                arr[count] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
