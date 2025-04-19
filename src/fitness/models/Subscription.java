package fitness.models;

public class Subscription {
    protected String type;
    protected double price;
    protected int validity;

    public Subscription(String type, double price, int validity) {
        this.type = type;
        this.price = price;
        this.validity = validity;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int valability) {
        this.validity = valability;
    }

    @Override
    public String toString() {
        return type + " (" + price + " RON, " + validity + " days)";
    }


}
