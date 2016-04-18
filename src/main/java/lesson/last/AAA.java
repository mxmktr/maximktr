package lesson.last;

/**
 * Created by steve on 2/18/16.
 */
public class AAA implements Comparable<AAA>{
    private String name;
    private String surName;
    private Integer age;

    public AAA(){
    }

    public AAA(String name, String surName, Integer age){
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String toString(){
        return "AAA: name = " + name + "; surName = " + surName + "; age = " + age + ".";
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean equals(Object o){
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        if (this == o) return true;

        AAA obj = (AAA) o;
        return !name.equals(obj.name) ? false: (!surName.equals(obj.surName) ? false : ((!age.equals(obj.age) ? false: true)));
    }

    public int hashCode(){
        int res = 0;
        res = 31 * res + (name != null? name.hashCode(): 0);
        res = 31 * res + (surName != null? surName.hashCode(): 0);
        res = 31 * res + (age != null? age.hashCode(): 0);
        return res;
    }

    @Override
    public int compareTo(AAA o) {
        int result;

        result = name.compareTo(o.name);
        if (result != 0) return result;
        result = surName.compareTo(o.surName);
        if (result != 0) return result;
        result = Integer.compare(this.age, o.age);
        if (result != 0) return result;

        return result;
    }
}
