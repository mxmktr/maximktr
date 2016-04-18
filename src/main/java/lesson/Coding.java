package lesson;

/**
 * Created by steve on 10/19/15.
 */
public class Coding {
    public static void main(String[] args) {

        String a = "hello fdmggfd dfgf";
        String key = "max";

        byte[] ab = a.getBytes();
        byte[] keyb = key.getBytes();

        byte[] result = new byte[ab.length];
        for (int i = 0; i < ab.length; i++) {
            result[i] = (byte) (ab[i] ^ keyb[i % keyb.length]);
        }

        byte[] resultDec = new byte[result.length];
        for (int i = 0; i < result.length; i++) {
            resultDec[i] = (byte) (result[i] ^ keyb[i % keyb.length]);
        }
        System.out.println(new String(resultDec));

    }
}
