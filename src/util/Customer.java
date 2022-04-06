package util;

public class Customer {
    private int timeIn;
    private int choosingTime;
    private int amountOfGoods;

    public Customer(int timeIn, int choosingTime, int amountOfGoods) {
        this.timeIn = timeIn;
        this.choosingTime = choosingTime;
        this.amountOfGoods = amountOfGoods;
    }


    public Customer() {
        this.timeIn = -1;
        this.choosingTime = -1;
        this.amountOfGoods = -1;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public int getChoosingTime() {
        return choosingTime;
    }

    public int getAmountOfGoods() {
        return amountOfGoods;
    }

    public int getTimeToQueue(){
        return timeIn + choosingTime;
    }

    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }

    public void setChoosingTime(int choosingTime) {
        this.choosingTime = choosingTime;
    }

    public void setAmountOfGoods(int amountOfGoods) {
        this.amountOfGoods = amountOfGoods;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "timeIn=" + timeIn +
                ", choosingTime=" + choosingTime +
                ", amountOfGoods=" + amountOfGoods +
                '}';
    }
}
