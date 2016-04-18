package lesson.singlton;

public class Singl {

    private static volatile Singl singl;
    private int[] arr;

    private Singl(){

    }

    public static Singl getInstance(){
        if (singl == null) {
            synchronized (Singl.class){
                if (singl == null)
                    singl = new Singl();
            }
        }
        return singl;
    }

    public int[] getArr(){
        if (arr == null)
            arr = new int[5];
        return arr;
    }
}
