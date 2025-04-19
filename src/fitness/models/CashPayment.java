package fitness.models;

import java.time.LocalDate;

public class CashPayment extends Payment {
    public CashPayment(double sum, LocalDate date) {
        super(sum, date);
    }
}
