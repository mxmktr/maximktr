package lesson.last;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 2/3/16.
 */
public class Last implements Comparable<Last>{

    private String name;
    private String lastName;

    public Last(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Last{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Last that) {

        int AFTER = 1;
        int BEFORE = -1;

        String thisCertificate = this.getName();
        String thatCertificate = that.getName();

        if(thisCertificate == null) {
            return AFTER;
        } else if(thatCertificate == null) {
            return BEFORE;
        } else {
            return thisCertificate.compareTo(thatCertificate);
        }
    }

    public static void main(String[] args) {

        Last last1 = new Last("Max", "Max");
        Last last2 = new Last("Dima", "Dima");
        Last last3 = new Last("Sveta", "Sveta");

        List<Last> list = new ArrayList<Last>();
        list.add(last1);
        list.add(last2);
        list.add(last3);

        for (Last el: list){
            System.out.println(el.getName());
        }
    }
}
