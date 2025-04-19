package fitness.models;

public class Employee extends Person {
    private final String position;

    public Employee(String name, String email, String CNP, String position) {
        super(name, email, CNP);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() + ", position='" + position + "'}";
    }
}
