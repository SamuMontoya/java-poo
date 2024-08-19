package model;

public class Patient extends User {
    // Attributes
    private  String birthday;
    private double weight;
    private double height;
    private  String blood;


    // Constructor
    public Patient(String name, String email){
        super(name, email);
    }


    // Getters and Setters
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }
    public void setBlood(String blood) {
        this.blood = blood;
    }


    // Methods
    @Override
    public String toString(){
        return "PATIENT: \n" +
                super.toString() + "\n" +
                "Birthday: " + birthday + "\n" +
                "Weight: " + weight + " Kg.\n" +
                "Height: " + height + " Mts. \n" +
                "Blood: " + blood;
    }
}
