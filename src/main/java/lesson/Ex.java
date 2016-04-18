package lesson;

/**
 * Created by steve on 12/1/15.
 */
public class Ex {
    public static void main(String[] args) {

        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};

        for (int i = -1; i < arr.length + 1; i++) {
            System.out.println(binary(arr, i));
        }
    }


    public static int binary(int[] arr, int a){

        int low = 0, high = arr.length;
        int res = -1;
        while (high != (low + 1)) {
            int data = (low + high)/2;
            if (arr[data] == a) {
                res = data;
                return res;
            } else if (arr[data] > a) {
                high = data;
            } else if (arr[data] < a){
                low = data;
            }
        }
        if (arr[0] == a)
            return 0;

        return res;
    }
}
