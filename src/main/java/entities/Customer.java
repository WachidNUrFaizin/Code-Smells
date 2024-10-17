package entities;

public class Customer {

    private String name;
    private String membership;
    private String address;

    public Customer(String name, String membership, String address) {
        this.name = name;
        this.membership = membership;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getMembership() {
        return membership;
    }

    public String getAddress() {
        return address;
    }
}
