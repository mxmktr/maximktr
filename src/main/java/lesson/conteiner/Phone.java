package lesson.conteiner;

/**
 * Created by steve on 11/2/15.
 */
public class Phone extends Product{

    private String model;

    @Override
    public boolean subCompare(Product p) {
        boolean result = false;
        if (p instanceof Phone){
            return result = this.model.equalsIgnoreCase(((Phone) p).model)? true: false;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Phone{" + super.toString() +
                "model='" + model + '\'' +
                '}';
    }
}
