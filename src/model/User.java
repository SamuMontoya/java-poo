package model;

public class User {
    // Attributes
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;


    // Constructor
    User(String name, String email){
        this.name = name;
        this.email = email;
    }


    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Methods
    @Override
    public String toString(){
        return "model.User: " + name + "\n" +
                "Email: " + email + "\n" +
                "Address: " + address + "\n" +
                "Phone: " + phoneNumber;
    }
}
