package model;

import java.util.Date;

public class AppointmentNurse extends Appointment implements IBookable {
    // Attributes
    private Nurse nurse;


    // Getters and Setters
    public Nurse getNurse() {
        return nurse;
    }
    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    @Override
    public void book(Date date, String time) {

    }
}
