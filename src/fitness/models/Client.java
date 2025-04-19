package fitness.models;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    private final Subscription subscription;
    private final List<Payment> payments = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    public Client(String name, String email, String CNP, Subscription subscription) {
        super(name, email, CNP);
        this.subscription = subscription;
    }

    public Subscription getSubscription() { return subscription; }
    public List<Payment> getPayments() { return payments;}
    public List<Reservation> getReservations() { return reservations; }

    public void addPayment(Payment p) { payments.add(p); }
    public void addReservation(Reservation r) { reservations.add(r);}

}
