package lesson.singlton;

import java.util.Properties;

public class Singlton {


    private static final Singlton singl = new Singlton();

    private static Singlton singlton1 = null;
    private static volatile Singlton singlton = null;


    private final Properties properties;

    private Singlton(){
        properties = new Properties();
        properties.setProperty("mama", "papa");
    }

    public static Singlton getInstance(){
        return singl;
    }

    public int getSumm(){
        return 22;
    }

    public static synchronized Singlton getSinglton1(){
        if (singlton1 == null)
            singlton1 = new Singlton();
        return singlton1;
    }

    public static final Singlton getSinglton(){
        if (singlton == null)
            synchronized (Singlton.class){
                if (singlton == null)
                    singlton = new Singlton();
            }
        return singlton;
    }

    public String getValue(String key){
        return properties.getProperty(key);
    }

}
