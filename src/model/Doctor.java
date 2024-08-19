package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    // Variables
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();


    // Attributes
    private String speciality;


    // Constructor
    public Doctor(String name, String email) {
        super(name, email);
    }


    // Getters and Setters
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    // Methods
    public void introduce() {
        System.out.println("Hi! I'm " + super.getName() +
                ", you can find my with the id: " + super.getId() + ". " +
                "Remember that my speciality is " + speciality + "!");
    }

    public void addAvailableAppointment(LocalDate date, String time) {
        availableAppointments.add(new AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    @Override
    public String toString() {
        // Format available appointments array
        StringBuilder listAppointments = new StringBuilder();
        for (AvailableAppointment appointment : availableAppointments) {
            listAppointments.append(appointment).append("\n");
        }

        // Print doctor information
        return "DOCTOR: \n" +
                super.toString() + "\n" +
                "Speciality: " + speciality + "\n" +
                "Available Appointments: " + "\n" +
                """
                +-------------+--------------------------------+----------+
                | Appointment |              DATE              |   TIME   |
                +-------------+--------------------------------+----------+
                """ + listAppointments +
                "+---------------------------------------------------------+";

    }


    // Sub Class
    public static class AvailableAppointment {
        // Attributes
        private static int idCounter = 1;
        private int id;
        private LocalDate date;
        private String time;


        // Constructor
        public AvailableAppointment(LocalDate date, String time) {
            this.date = date;
            this.time = time;
            id = idCounter++;
        }


        // Getters and Setters
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public LocalDate getDate() {
            return date;
        }
        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }


        // Methods
        @Override
        public String toString() {
            return
                    "|      " + id + "      |           " + date  + "           |  " + time + "   |";
        }
    }
}
