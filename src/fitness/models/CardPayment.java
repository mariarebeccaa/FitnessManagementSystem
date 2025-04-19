package fitness.models;

import java.time.LocalDate;

public class CardPayment extends Payment {
    public CardPayment(double sum, LocalDate date) {
        super(sum, date);
    }
}
