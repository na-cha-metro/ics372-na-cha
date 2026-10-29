package main.java.edu.metrostate.oodi.hotel;
import java.time.LocalDate;

public class Room {
    public String roomNumber;
    public int floor;
    public boolean inService = true;

    public RoomType type;

    public Room(String roomNumber, int floor, RoomType type) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.type = type;
    }

    public String getRoomNumber() {return this.roomNumber;}
    public int getFloor() {return this.floor;}
    public boolean getInService() {return this.inService;}
    
    public void setService(boolean b) {this.inService = b;}

    public boolean isAvailable (LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests) {
        RoomType avail = this.type.isAvailable(checkInDate, checkOutDate, numberOfGuests);
        
        if (avail != null) {
            //System.out.println(avail + "<--- Available?");
            return true;
        } else {
            //System.out.println(avail + "<--- NULL?");
            return false;
        }

    }

    public RoomType getType() {return this.type;}
}
