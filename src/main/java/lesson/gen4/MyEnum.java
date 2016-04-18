package lesson.gen4;

/**
 * Created by steve on 3/11/16.
 */
public enum MyEnum {
    Yellow(2),
    Blue(3),
    Black(4),
    White(5);

    private final int id;

    MyEnum(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
