package lesson.conteiner;

/**
 * Created by steve on 11/2/15.
 */
public class Camera extends Product<Camera>{

    private Integer pixeles;

    @Override
    public boolean subCompare(Camera p) {
        boolean result = false;
        if (p instanceof Camera){
            int res;
            res = this.pixeles.compareTo(((Camera) p).pixeles);
            if (res == 0)
                return true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Camera{" + super.toString() +
                "pixeles=" + pixeles +
                '}';
    }
}
