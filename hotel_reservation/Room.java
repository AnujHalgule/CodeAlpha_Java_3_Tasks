package hotel_reservation;

public class Room {

    int roomNumber;
    String roomType;
    double price;
    boolean available;

    Room(int roomNumber, String roomType, double price) {

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.available = true;
    }

    void showRoom() {

        System.out.println(
            "Room No: " + roomNumber +
            " | Type: " + roomType +
            " | Price: Rs. " + price +
            " | Available: " + available
        );
    }
}
