package main.java.edu.metrostate.oodi.hotel;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    public String confirmationNumber;
    public LocalDate checkInDate;
    public LocalDate checkOutDate;
    public int numberOfGuests;
    public LocalDate madeOn;
    public int rateBookedForEachNight;
    public String status; //confirmed, cancelled, checked in, completed
    
    //public List<Guest> guests;
    //public List<Room> offers = new ArrayList<>();

    public Reservation() {}

    public void makeReservation(LocalDate ci, LocalDate co, int g, List<Room> rooms) {
        this.checkInDate = ci;
        this.checkOutDate = co;
        this.numberOfGuests = g;
        this.madeOn = ci;
        
        System.out.println();
        System.out.print("Offered: ");
        for (Room r : rooms) {
            if (r.isAvailable(ci, co, g)) {
                //offers.add(r);
                System.out.print(r.getRoomNumber() + " " + r.type.getName() + " $" + r.type.getCost() + ", ");
                r.getType().cost = 0;
            }
        }
        System.out.println();
    }

    public void makeReservation(LocalDate ci, LocalDate co, int g, List<Room> rooms, String roomNumber, Guest gt) {
        this.checkInDate = ci;
        this.checkOutDate = co;
        this.numberOfGuests = g;
        this.madeOn = ci;
        
        System.out.println();
        for (Room r : rooms) {
            if (r.isAvailable(ci, co, g)) {
                if (r.getRoomNumber() == roomNumber) {
                    r.getType().setGuest(gt);
                    
                    if (r.getType().getGuest() != null) {
                        String a = "%s\n Confirmation Number: %d\n Room %s\n %s to %s \n Total: $%d";
                        System.out.println(String.format(a, 
                            "Succeeded.",
                            Integer.parseInt(r.getRoomNumber()) * r.getFloor() * 100, 
                            r.getRoomNumber(),
                            ci.atStartOfDay(ZoneId.systemDefault()).toInstant(),
                            co.atStartOfDay(ZoneId.systemDefault()).toInstant(),
                            r.getType().getCost()));
                    }
                }
            } else {
                //marcus
                String b = "Rejected: Room %s is not free for the night of %s";
                System.out.println(String.format(b, r.getRoomNumber(), ci.getMonth() + " " + ci.getDayOfMonth()));
            }
        }
    }

    public String getConfirmation() {return this.confirmationNumber;}
    public LocalDate getCheckInDate() {return this.checkInDate;}
    public LocalDate getCheckOutDate() {return this.checkOutDate;}
    public int getNumberOfGuests() {return this.numberOfGuests;}
    public LocalDate getCreationDate() {return this.madeOn;}
    public int getBookedRate() {return this.rateBookedForEachNight;}
    public String getStatus() {return this.status;}

    public void reserveRoom(String roomNumber, String name, String email, String phone, LocalDate ci, LocalDate co, int g, List<Room> r) {
        Guest gt = new Guest(name, email, phone);
        makeReservation(ci, co, g, r, roomNumber, gt);
    }

    //public void addGuest(Guest g) {this.guests.add(g);}

    // public int generateConfirmationNumber() {
    //     return this.numberOfGuests * rateBookedForEachNight * 100;
    // }
}
