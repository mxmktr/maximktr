package lesson.serial;

/**
 * Created by steve on 12/11/15.
 */
public class NonSeriablizle{

    private transient String myData = "hahaha";

    public String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }

    @Override
    public String toString() {
        return "NonSeriablizle{" +
                "myData='" + myData + '\'' +
                '}';
    }
}
