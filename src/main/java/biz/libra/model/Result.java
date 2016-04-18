package biz.libra.model;

/**
 * Created by steve on 11/25/15.
 */
public class Result {

    private int count;
    private double summ;

    public Result() {
    }

    public Result(int count, double summ) {
        this.count = count;
        this.summ = summ;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }

    public void add(Result result){
        this.count += result.count;
        this.summ += result.summ;
    }
}
