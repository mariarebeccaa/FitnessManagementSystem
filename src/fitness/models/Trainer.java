package fitness.models;

public class Trainer extends Person {
    private final String specialty;

    public Trainer(String name, String email, String CNP, String specialty) {
        super(name, email, CNP);
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Trainer{" + super.toString() + ", specialty='" + specialty + "'}";
    }

    public String getDetails() {
        return getName() + " - " + specialty;
    }

}
