package bus_reservation_system_project;

import java.util.Scanner;

public class ReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the bus capacity: ");
        int capacity = scanner.nextInt();
        Bus bus = new Bus(capacity);

        boolean run = true;
        while (run) {
            System.out.println("\nBus Reservation System:");
            System.out.println("1. Reserve a seat");
            System.out.println("2. View seat status");
            System.out.println("3. Save reservation data to file");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter seat number to reserve: ");
                    int seatNumber = scanner.nextInt();
                    bus.reserveSeat(seatNumber);
                    break;
                case 2:
                    bus.displaySeatStatus();
                    break;
                case 3:
                    bus.saveToFile();
                    break;
                case 4:
                    run = false;
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}

