package lesson.last;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 2/29/16.
 */
public class SortMy {

    public static int[] sort(int[] arr){
        for (int boarder = arr.length - 1 ; boarder > 0; boarder--) {
            for (int j = 0; j < boarder; j++) {
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

    }
}
