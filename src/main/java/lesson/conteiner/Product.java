package lesson.conteiner;

/**
 * Created by steve on 11/2/15.
 */
public abstract class Product<T extends Product<T>> implements Comparable<T> {

    protected String name;
    protected Integer price;

    public Integer getPrice() {
        return price;
    }

    public int compareTo(T o) {
        return this.price - o.getPrice();
    }

    public abstract boolean subCompare(T p);

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}
