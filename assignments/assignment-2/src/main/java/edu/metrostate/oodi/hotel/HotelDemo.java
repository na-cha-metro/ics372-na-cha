package main.java.edu.metrostate.oodi.hotel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelDemo {
    public void main(String[] args) {
        //placeholder
        //RoomType Standard = new RoomType("Standard", 129, 159, 2, 1);
        //RoomType Deluxe = new RoomType("Deluxe", 179, 219, 3, 1);
        //RoomType Suite = new RoomType("Suite", 289, 349, 4, 2);

        List<Room> rooms = new ArrayList<>();
        //List<Guest> guests = new ArrayList<>();

        Room r101 = new Room("101", 1, new RoomType("Standard", 129, 159, 2, 1));
        Room r102 = new Room("102", 1, new RoomType("Standard", 129, 159, 2, 1));
        Room r201 = new Room("201", 2, new RoomType("Deluxe", 179, 219, 3, 1));
        Room r301 = new Room("301", 3, new RoomType("Suite", 289, 349, 4, 2));

        rooms.add(r101);
        rooms.add(r102);
        rooms.add(r201);
        rooms.add(r301);

        Reservation res = new Reservation();

        // step 1
        System.out.println("-----");
        System.out.println("Step 1");
        System.out.println("Find rooms for check-in Nov 12 to Nov 15 for 2 guests.");
        res.makeReservation(LocalDate.of(2026, 11, 12), LocalDate.of(2026, 11, 15), 2, rooms);
        System.out.println("-----");

        // step 2
        System.out.println("-----");
        System.out.println("Step 2");
        System.out.println("Reserve room 201, Nov 12 to Nov 15, 2 guests, for Ana Okafor, ana.okafor@example.com, 612-555-0142.");
        res.reserveRoom("201", "Ana Okafor", "ana.okafor@example.com", "612-555-0142", LocalDate.of(2026, 11, 12), LocalDate.of(2026, 11, 15), 2, rooms);
        System.out.println("-----");

        // step 3
        System.out.println("-----");
        System.out.println("Step 3");
        System.out.println("Try to reserve room 201, Nov 14 to Nov 16, 2 guests, for Marcus Lindqvist, marcus.l@example.com, 651-555-0187.");
        res.reserveRoom("201", "Marcus Lindqvist", "marcus.l@example.com", "651-555-0187", LocalDate.of(2026, 11, 14), LocalDate.of(2026, 11, 16), 2, rooms);
        System.out.println("-----");
        
        // step n
        System.out.println("-----");
        System.out.println("I did not finish all the DEMO steps of part 6 unfortunately.");
        System.out.println("-----");
    }
}