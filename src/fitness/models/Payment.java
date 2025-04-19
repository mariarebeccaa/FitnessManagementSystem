package fitness.models;

import java.time.LocalDate;

public class Payment {
    protected double sum;
    protected LocalDate date;

    public Payment(double sum, LocalDate date) {
        this.date = date;
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    public LocalDate getDate() {
        return date;
    }
}
