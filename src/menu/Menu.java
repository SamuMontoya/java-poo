package menu;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.DoctorMenu.showDoctorMenu;

public class Menu {
    // Variables
    public static final String[] MONTHS = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };
    private static final Scanner  scanner = new Scanner(System.in);
    private static int userResponse = -1;

    public static Doctor doctorLogged;
    public static Patient patientLogged;

    // Methods
    private static void printUserType(){
        System.out.print("---> ");
        userResponse = scanner.nextInt();
    }

    public static void showMainMenu() {
        System.out.println("\nWelcome to your medical app");

        do {
            // Display the main menu
            System.out.println("Please select an option:\n");
            System.out.println("1. Doctors");
            System.out.println("2. Patients");
            System.out.println("0. Exit");
            printUserType();

            switch (userResponse){
                case 1:
                    authUser(1);
                    userResponse = 0;
                    break;
                case 2:
                    authUser(2);
                    userResponse = 0;
                    break;
                case 0:
                    System.out.println("\nGoodbye!\n");
                    break;
                default:
                    System.out.println("\nInvalid option please try again!\n");
            }
        } while (userResponse != 0);
    }

    private static void showPatientMenu() {
        System.out.println("\nYou have selected Patient Menu\n");

//        do {
//            // Display the main menu
//            System.out.println("Please select an option:");
//            System.out.println("1. Book an Appointment");
//            System.out.println("2. My appointments");
//            System.out.println("0. Return \n");
//            printUserType();
//
//            switch (userResponse){
//                    case 1:
//                    showQuarterList();
//                        break;
//                    case 2:
//                        System.out.println("\nYou have selected my appointments\n");
//                        break;
//                    case 0:
//                        showMainMenu();
//                        break;
//                    default:
//                        System.out.println("\nInvalid option please try again!\n");
//                }
//
//
//        } while (userResponse != 0);
    }

    private static void authUser(int userType) {
        // Mocked doctors
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Pipe", "pipe@mail.com"));
        doctors.add(new Doctor("Gary", "gary@mail.com"));
        doctors.add(new Doctor("Mary", "mary@mail.com"));

        // Mocked patients
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Karen", "karen@mail.com"));
        patients.add(new Patient("Jake", "jake@mail.com"));
        patients.add(new Patient("Jack", "jack@mail.com"));

        // Access flag
        boolean canAccess = false;
        String userToValidate = userType == 1 ? "DOCTOR" : "PATIENT";
        System.out.print("\n" + userToValidate + ", please write your email \n---> ");

        do {
            String  authResponse = scanner.nextLine();

            if (userToValidate.equals("DOCTOR")) {
                for (Doctor doctor : doctors) {
                    if (doctor.getEmail().equals(authResponse)){
                        canAccess = true;
                        doctorLogged = doctor;
                        showDoctorMenu();
                        break;
                    }
                }
            }

            if(userToValidate.equals("PATIENT")) {
                for (Patient patient : patients) {
                    if (patient.getEmail().equals(authResponse)){
                        canAccess = true;
                        patientLogged = patient;
                        showPatientMenu();
                        break;
                    }
                }
            }

            if (!canAccess && !authResponse.isEmpty()) {
                System.out.print("\n" + userToValidate + ", please check the email and try again \n---> ");
            }

        } while (!canAccess);
    }
}
