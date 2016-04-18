package lesson.sort;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by steve on 3/6/16.
 */
public class AAA {
    public static void main(String[] args) {

        int black = -1;
        int zero = 0;
        int red = 1;

        int n = 20;
        int[] datas = new int[n];
        Map<Integer, Integer> result = new TreeMap<Integer, Integer>();

        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            datas[i] = (int) (Math.random() * 3) - 1;
        }

        for (int i = 0; i < n; i++) {
            count = 0;
            while (i < n && datas[i] == red) {
                count++;
                i++;
            }
            if (count > max) {
                max = count;
            }
        }


        System.out.println(Arrays.toString(datas));
        System.out.println(max);


    }

    boolean compare(Class obj) {
        return getClass().equals(obj);
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

}
