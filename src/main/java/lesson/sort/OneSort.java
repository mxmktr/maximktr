package lesson.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by steve on 11/6/15.
 */
public class OneSort {
    public static void main(String[] args) {

        int[] arr = new int[0];
       /* for (int i = 0; i < 10; i++) {
            arr[i] = (int)(Math.random() * 50);
        }
        System.out.println(Arrays.toString(arr));
*/
//        sortOne(arr);
        sortSecond(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sortOne(int[] arr){
        int length = arr.length;
        for (int i = length -1 ; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void sortSecond(int[] arr){

        int length = arr.length;
        int position = 0;

        for (int i = 0; i < length - 1; i++) {
            int min = arr[i];
            for (int j = i + 1; j < length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    position = j;
                }
            }
            arr[position] = arr[i];
            arr[i] = min;
        }
    }
}
