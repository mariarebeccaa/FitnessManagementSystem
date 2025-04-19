package fitness.service;

import fitness.models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class FitnessService {
    private final List<Client> clients = new ArrayList<>();
    private final List<Trainer> trainers = new ArrayList<>();
    private final List<FitnessClass> fitnessClasses = new ArrayList<>();
    private final TreeSet<FitnessClass> sortedClasses = new TreeSet<>(Comparator.comparing(FitnessClass::getDateTime));
//    private Set<Echipament> echipamente = new HashSet<>();

    public void registerClient(Client client) {
        clients.add(client);
    }

    public void registerTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public void createFitnessClass(FitnessClass fitnessClass) {
        fitnessClasses.add(fitnessClass);
        sortedClasses.add(fitnessClass);
    }

    public void reserveSpot(Client client, FitnessClass fitnessClass) {
        Reservation reservation = new Reservation(client, fitnessClass, LocalDateTime.now());
        client.addReservation(reservation);
        fitnessClass.addParticipant(client);
        System.out.println("Spot reserved for " + client.getName() + " in class " + fitnessClass.getName());
    }

    public void cancelReservation(Client client, FitnessClass fitnessClass) {
        //creez o lista temporrar in care pun rezervarile care trb sterse
        List<Reservation> toRemove = new ArrayList<>();

        //ma plimb prin toate rezervarile clientului
        for(Reservation r : client.getReservations()) {
            //daca rezervarea este pt clasa pe care vrea sa o anuleze..
            if(r.getFitnessClass().equals(fitnessClass)) {
                toRemove.add(r);
            }
        }
        //sterg toate rezervarile gasite
        client.getReservations().removeAll(toRemove);

        //sterg si clientul din lista de participanti de la clasa resp
        fitnessClass.getParticipants().remove(client);

        System.out.println("Reservation canceled for " + client.getName() + " in class " + fitnessClass.getName());
    }

    public void calculateTotalPayments(Client client) {
        double total = 0;
        for (Payment p : client.getPayments()) {
            total += p.getSum();
        }
        System.out.println("Total payments for " + client.getName() + ": " + total + " RON");
    }

    public void listActiveClients() {
        System.out.println("Active clients (with subscription or reservations):");
        for (Client c : clients) {
            boolean isActive = c.getSubscription() != null || !c.getReservations().isEmpty();
            if (isActive) {
                System.out.println("- " + c.getName());
            }
        }
    }

    public void listSortedFitnessClasses() {
        System.out.println("Available Fitness Classes (sorted by date):");
        for (FitnessClass fc : sortedClasses) {
            System.out.println("- " + fc.getName() + " at " + fc.getDateTime());
        }
    }

    public void showReservations(Client client) {
        System.out.println("Reservations for " + client.getName() + ":");
        for (Reservation r : client.getReservations()) {
            System.out.println("- " + r.getFitnessClass().getName() + " at " + r.getDateTimeReservation());
        }
    }

    public void showPayments(Client client) {
        System.out.println("Payments for " + client.getName() + ":");
        for (Payment p : client.getPayments()) {
            System.out.println("- " + p.getSum() + " RON on " + p.getDate());
        }
    }


    public Client getClientByName(String name) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }

    public FitnessClass getFitnessClassByName(String name) {
        for (FitnessClass fitnessClass : fitnessClasses) {
            if (fitnessClass.getName().equalsIgnoreCase(name)) {
                return fitnessClass;
            }
        }
        return null;
    }

    public List<Trainer> getAvailableTrainers(LocalDateTime time) {
        List<Trainer> available = new ArrayList<>();
        for (Trainer t : trainers) {
            boolean isBusy = false;
            for (FitnessClass fc : fitnessClasses) {
                if (fc.getTrainer().equals(t) && fc.getDateTime().equals(time)) {
                    isBusy = true;
                    break;
                }
            }
            if (!isBusy) {
                available.add(t);
            }
        }
        return available;
    }

    public void renewSubscription(Client client, int extraDays, double paymentAmount) {
        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        Subscription sub = client.getSubscription();
        if (sub == null) {
            System.out.println("Client does not have a subscription.");
            return;
        }

        // Prelungim valabilitatea
        sub.setValidity(sub.getValidity() + extraDays);

        // Adăugăm plata
        client.addPayment(new Payment(paymentAmount, LocalDate.now()));

        System.out.println("Subscription extended by " + extraDays + " days.");
        System.out.println("Payment of " + paymentAmount + " RON added.");
        System.out.println("New total validity: " + sub.getValidity() + " days.");
    }







}
