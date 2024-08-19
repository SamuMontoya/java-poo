package model;

import java.util.Date;

public class AppointmentDoctor extends Appointment implements IBookable {
    // Attributes
    private Doctor doctor;


    // Getters and Setters
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public void book(Date date, String time) {

    }
}