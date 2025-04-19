package fitness.models;

public class Person {
    protected String name;
    protected String email;
    protected String CNP;

    public Person(String name, String email, String CNP) {
        this.name = name;
        this.email = email;
        this.CNP = CNP;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}
