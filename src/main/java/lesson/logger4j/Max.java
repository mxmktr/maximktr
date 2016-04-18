package lesson.logger4j;

public class Max {

    public static int[] getArr(int[] arr) {
        int result = 0;
        int min = 0,  max = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            while (i < arr.length && arr[i] > 0){
                count++;
                i++;
            }
            if (result < count && count > 1){
                result = count;
                max = i - 1;
                min = i - result;
            }
        }
        System.out.println(result + "  min " + min + " max " + max);
        if (result > 1)
            return new int[]{min, max};
        return new int[]{};
    }

    public static void main(String[] args) {

    }
}
