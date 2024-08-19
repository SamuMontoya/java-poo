package menu;
import model.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorMenu {
    public static void showDoctorMenu() {
        System.out.println("\nWelcome Doctor " + Menu.doctorLogged.getName() + "!");
        Scanner scanner = new Scanner(System.in);

        int response = 0;
        do{
            // Display the main menu
            System.out.println("Please select an option:\n");
            System.out.println("1. Add available date");
            System.out.println("2. See my available details");
            System.out.println("0. Logout");
            System.out.print("---> ");
            response = scanner.nextInt();

            // Handle response
            switch (response){
                case 1:
                    showAddAvailableDateMenu();
                    response = 0;
                    break;
                case 2:
                    showMyAvailableDates();
                    showDoctorMenu();
                    break;
                case 0:
                    Menu.showMainMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void showAddAvailableDateMenu() {
        String finalDate = "";
        String finalTime = "";
        Scanner scanner = new Scanner(System.in);

        int response = 0;
        do {
            System.out.println("\nMonths to book and appointment");
            System.out.println("Please select an option:\n");

            // Display the moths menu
            for (int i = 0; i < 3; i++) {
                System.out.println((i + 1) + ". " + Menu.MONTHS[i]);
            }
            System.out.println("0. Go Back");
            System.out.print("---> ");
            response = scanner.nextInt();


            if (response > 0 && response <= 3) {
                // Handle confirmation month
                printConfirmationMessage(Menu.MONTHS[response-1]);
                int checkMonth = scanner.nextInt();

                // STEP 2: Add date
                int checkDate = -1;
                if (checkMonth == 1){
                    do {
                        String date = scanner.nextLine();

                        if (!date.isEmpty()){
                            printConfirmationMessage(date);
                            checkDate = scanner.nextInt();
                            if (checkDate != 1){
                                continue;
                            } else {
                                finalDate = date;
                            };
                        }

                        if (checkDate != 1){
                            System.out.println("\nPlease provide a date for your appointment:");
                            System.out.println("Follow the format YYYY-MM-DD");
                            System.out.print("---> ");
                        }


                    } while (checkDate != 1);

                }

                // STEP 3: Add time
                int checkTime = -1;
                if (checkDate == 1){
                    do {
                        String time = scanner.nextLine();

                        if (!time.isEmpty()){
                            printConfirmationMessage(time);
                            checkTime = scanner.nextInt();
                            if (checkTime != 1) {
                                continue;
                            } else {
                                finalTime = time;
                            }
                        }

                        if (checkTime != 1){
                            System.out.println("\nPlease provide a time for your appointment:");
                            System.out.println("Follow the format HH:MM");
                            System.out.print("---> ");
                        }
                    } while (checkTime != 1);

                    LocalDate date = LocalDate.parse(finalDate);
                    Menu.doctorLogged.addAvailableAppointment(date, finalTime);

                    // Continue adding
                    System.out.println("\nDo you want to continue adding available appointments?");
                    System.out.println("1. Yes, continue");
                    System.out.println("2. No");
                    System.out.print("---> ");
                    int wantToContinue = scanner.nextInt();

                    if (wantToContinue == 1){
                        continue;
                    } else {
                        // Add the appointment to the Doctor
                        response = 0;
                        showDoctorMenu();
                    }
                }

            } else if (response == 0){
                showDoctorMenu();
            }
        } while(response != 0);
    }

    private static void printConfirmationMessage(String value) {
        System.out.println("\nYou provided: " + value);
        System.out.println("Is that correct?");
        System.out.println("1. Yes, continue");
        System.out.println("2. No, change");
        System.out.print("---> ");
    }

    private static void showMyAvailableDates() {
        ArrayList<Doctor.AvailableAppointment> doctorAvailableAppointments = Menu.doctorLogged.getAvailableAppointments();
        System.out.print("""
                
                You have the following available appointments:
                
                +-------------+--------------------------------+----------+
                | Appointment |              DATE              |   TIME   |
                +-------------+--------------------------------+----------+
                """);
        for (Doctor.AvailableAppointment doctor : doctorAvailableAppointments) {
            System.out.println(doctor);
        }
        System.out.print("+---------------------------------------------------------+\n");
    }
}
