package model;

public class Nurse extends User{
    // Attributes
    String specialty;


    // Constructor
    public Nurse(String name, String email) {
        super(name, email);
    }


    // Getters and Setters
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
