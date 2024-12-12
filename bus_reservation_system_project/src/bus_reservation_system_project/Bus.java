package bus_reservation_system_project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Bus {
    private int capacity;
    private boolean[] seats;

    public Bus(int capacity) {
        this.capacity = capacity;
        seats = new boolean[capacity];
        Arrays.fill(seats, false); // Initialize all seats as empty
    }

    public boolean reserveSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > capacity) {
            System.out.println("Invalid seat number. Please choose a seat between 1 and " + capacity);
            return false;
        }
        if (seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return false;
        } else {
            seats[seatNumber - 1] = true;
            System.out.println("Seat " + seatNumber + " has been successfully reserved.");
            return true;
        }
    }

    public void displaySeatStatus() {
        System.out.println("Seat Status:");
        for (int i = 0; i < capacity; i++) {
            System.out.println("Seat " + (i + 1) + ": " + (seats[i] ? "Booked" : "Empty"));
        }
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("reservations.txt")) {
            writer.write("Bus Reservation Report\n");
            writer.write("----------------------\n");
            for (int i = 0; i < capacity; i++) {
                writer.write("Seat " + (i + 1) + ": " + (seats[i] ? "Booked" : "Empty") + "\n");
            }
            System.out.println("Reservation data saved to reservations.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data to file.");
            e.printStackTrace();
        }
    }
}
