package biz.libra.model;

/**
 * Created by steve on 11/25/15.
 */
public class CashTableData {

    private String cashSymbol;
    private int countOfTran;
    private double sumOfTran;

    public String getCashSymbol() {
        return cashSymbol;
    }

    public void setCashSymbol(String cashSymbol) {
        this.cashSymbol = cashSymbol;
    }

    public int getCountOfTran() {
        return countOfTran;
    }

    public void setCountOfTran(int countOfTran) {
        this.countOfTran = countOfTran;
    }

    public double getSumOfTran() {
        return sumOfTran;
    }

    public void setSumOfTran(double sumOfTran) {
        this.sumOfTran = sumOfTran;
    }

    @Override
    public String toString() {
        return "CashBySymbolData{" +
                "cashSymbol='" + cashSymbol + '\'' +
                ", countOfTran=" + countOfTran +
                ", sumOfTran=" + sumOfTran +
                '}';
    }
}
