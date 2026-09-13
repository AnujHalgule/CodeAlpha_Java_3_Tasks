package hotel_reservation;

public class Booking {

    int bookingId;
    String customerName;
    int roomNumber;
    int nights;
    double totalAmount;

    Booking(int bookingId, String customerName,
            int roomNumber, int nights, double totalAmount) {

        this.bookingId = bookingId;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.nights = nights;
        this.totalAmount = totalAmount;
    }

    void showBooking() {

        System.out.println();
        System.out.println("========== BOOKING DETAILS ==========");
        System.out.println("Booking ID    : " + bookingId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Room Number   : " + roomNumber);
        System.out.println("Number Nights : " + nights);
        System.out.println("Total Amount  : Rs. " + totalAmount);
        System.out.println("=====================================");
    }
}
