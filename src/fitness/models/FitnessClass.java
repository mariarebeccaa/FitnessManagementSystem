package fitness.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FitnessClass {
    private final String name;
    private final LocalDateTime dateTime;
    private final Trainer trainer;
    private final List<Client> participants = new ArrayList<>();

    public FitnessClass(String name, LocalDateTime dateTime, Trainer trainer) {
        this.name = name;
        this.dateTime = dateTime;
        this.trainer = trainer;
    }

    public void addParticipant(Client c) { participants.add(c);}

    public LocalDateTime getDateTime() { return dateTime;}
    public String getName() { return name;}
    public Trainer getTrainer() { return trainer;}
    public List<Client> getParticipants() { return participants;}
}

