package hotel_reservation;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Room> rooms = new ArrayList<Room>();
    static ArrayList<Booking> bookings = new ArrayList<Booking>();

    static int nextBookingId = 1001;

    public static void main(String[] args) {

        addRooms();

        int choice;

        do {
            System.out.println();
            System.out.println("======================================");
            System.out.println("       HOTEL RESERVATION SYSTEM       ");
            System.out.println("======================================");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Bookings");
            System.out.println("5. Search Booking");
            System.out.println("6. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    showBookings();
                    break;

                case 5:
                    searchBooking();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }

    static void addRooms() {

        rooms.add(new Room(101, "Standard", 1800));
        rooms.add(new Room(102, "Standard", 1800));
        rooms.add(new Room(103, "Standard", 1800));

        rooms.add(new Room(201, "Deluxe", 2500));
        rooms.add(new Room(202, "Deluxe", 2500));

        rooms.add(new Room(301, "Suite", 4000));
        rooms.add(new Room(302, "Suite", 4000));
    }

    static void showRooms() {

        System.out.println();
        System.out.println("----------- AVAILABLE ROOMS -----------");

        boolean found = false;

        for (Room room : rooms) {

            if (room.available) {
                room.showRoom();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No rooms are currently available.");
        }
    }

    static void bookRoom() {

        showRooms();

        System.out.println();
        System.out.print("Enter room number: ");
        int roomNumber = sc.nextInt();

        Room selectedRoom = null;

        for (Room room : rooms) {

            if (room.roomNumber == roomNumber) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Room not found.");
            return;
        }

        if (!selectedRoom.available) {
            System.out.println("Sorry, this room is already booked.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        if (nights <= 0) {
            System.out.println("Number of nights must be greater than zero.");
            return;
        }

        double totalAmount = selectedRoom.price * nights;

        Booking booking = new Booking(
                nextBookingId,
                customerName,
                selectedRoom.roomNumber,
                nights,
                totalAmount
        );

        bookings.add(booking);

        selectedRoom.available = false;

        System.out.println();
        System.out.println("========== BOOKING SUCCESSFUL ==========");
        System.out.println("Booking ID   : " + nextBookingId);
        System.out.println("Customer     : " + customerName);
        System.out.println("Room Number  : " + selectedRoom.roomNumber);
        System.out.println("Room Type    : " + selectedRoom.roomType);
        System.out.println("Nights       : " + nights);
        System.out.println("Total Bill   : Rs. " + totalAmount);
        System.out.println("========================================");

        nextBookingId++;
    }

    static void cancelBooking() {

        if (bookings.size() == 0) {
            System.out.println("There are no bookings to cancel.");
            return;
        }

        System.out.print("Enter booking ID: ");
        int bookingId = sc.nextInt();

        Booking selectedBooking = null;

        for (Booking booking : bookings) {

            if (booking.bookingId == bookingId) {
                selectedBooking = booking;
                break;
            }
        }

        if (selectedBooking == null) {
            System.out.println("Booking not found.");
            return;
        }

        for (Room room : rooms) {

            if (room.roomNumber == selectedBooking.roomNumber) {
                room.available = true;
                break;
            }
        }

        bookings.remove(selectedBooking);

        System.out.println("Booking cancelled successfully.");
    }

    static void showBookings() {

        System.out.println();
        System.out.println("------------- ALL BOOKINGS -------------");

        if (bookings.size() == 0) {
            System.out.println("No bookings available.");
            return;
        }

        for (Booking booking : bookings) {
            booking.showBooking();
        }
    }

    static void searchBooking() {

        if (bookings.size() == 0) {
            System.out.println("No bookings available.");
            return;
        }

        System.out.print("Enter booking ID: ");
        int bookingId = sc.nextInt();

        boolean found = false;

        for (Booking booking : bookings) {

            if (booking.bookingId == bookingId) {
                booking.showBooking();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Booking not found.");
        }
    }
}