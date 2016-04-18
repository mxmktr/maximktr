package lesson.Lesson24;

public class MyHashCode {

    private String name;
    private String surname;
    private int age;

    public MyHashCode(){
    }

    public MyHashCode(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyHashCode{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (this == obj) return true;

        if (this.getClass() != obj.getClass()) return false;

        MyHashCode newObj = (MyHashCode) obj;

        if (!name.equals(newObj.getName())) return false;
        if (!surname.equals(newObj.getSurname())) return false;
        if (age != newObj.getAge()) return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result = 1;

        result = 31*result + (name != null? name.hashCode(): 0);
        result = 31*result + (surname != null? surname.hashCode(): 0);
        result = 31*result + age;

        return result;
    }

    public static boolean row(int countSmall, int countBig, int totalInch){
/*

        if (countBig * 5 < totalInch && (countSmall >= totalInch % 5)) {
            return true;
        } else if (totalInch % 5 <= countSmall) return true;
        return false;

*/

        return ((countSmall+ countBig*5>=totalInch)&&(totalInch%5<=countSmall))?true:false;
    }



    public static void main(String[] args) {
        System.out.println(row(5, 3, 9));
    }
}
