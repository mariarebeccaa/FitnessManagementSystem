package fitness.models;

import java.time.LocalDateTime;

public class Reservation {
    private final Client client;
    private final FitnessClass fitnessClass;
    private final LocalDateTime dateTimeReservation;

    public Reservation(Client client, FitnessClass fitnessClass, LocalDateTime dateTimeReservation) {
        this.client = client;
        this.fitnessClass = fitnessClass;
        this.dateTimeReservation = dateTimeReservation;
    }

    public LocalDateTime getDateTimeReservation() { return dateTimeReservation; }
    public FitnessClass getFitnessClass() { return fitnessClass;}
}
