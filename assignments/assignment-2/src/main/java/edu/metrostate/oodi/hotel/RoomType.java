package main.java.edu.metrostate.oodi.hotel;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
//import java.util.List;
import java.util.Locale;
import java.time.format.TextStyle;

public class RoomType {
    public String name;
    public int weekdayRate;
    public int weekendRate;
    public int maximumGuests;
    public int minimumNights;

    public Guest assigned = null;
    public int cost = 0;
    
    public RoomType(String name, int weekdayRate, int weekendRate, int maximumGuests, int minimumNights) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.maximumGuests = maximumGuests;
        this.minimumNights = minimumNights;
    }

    public String getName() {return this.name;}
    public int getWeekdayRate() {return this.weekdayRate;}
    public int getWeekendRate() {return this.weekendRate;}
    public int getMaxGuests() {return this.maximumGuests;}
    public int getMinNights() {return this.minimumNights;}

    public Guest getGuest() {return this.assigned;} //placeholder
    public int getCost() {return this.cost;}

    public RoomType isAvailable(LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests) {
        int days = checkOutDate.getDayOfYear() - checkInDate.getDayOfYear();
        try {
            if (days >= minimumNights && numberOfGuests <= maximumGuests && this.assigned == null) {
                //System.out.println("Passed check. " + days);

                // note revisit later for bill calc (cost)
                //System.out.println(checkOutDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US));

                // if (checkOutDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US) == "Saturday" || checkOutDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US) == "Sunday") {
                //     this.cost += this.weekendRate;
                // } else {
                //     this.cost += this.weekdayRate;
                // }

                LocalDate currentDate = checkInDate;
                while (currentDate.isBefore(checkOutDate)) {
                    DayOfWeek day = currentDate.getDayOfWeek();
                    if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY || day == DayOfWeek.FRIDAY) {
                        this.cost += this.weekendRate;
                    } else {
                        this.cost += this.weekdayRate;
                    }
                    currentDate = currentDate.plusDays(1);
                }

                //System.out.println("cost: $" + this.cost);

                return this;
            } else if (days < minimumNights || numberOfGuests > maximumGuests && this.assigned != null) {
                throw new IllegalStateException("Room occupied");
            }
        } catch (IllegalStateException e) {
            System.out.println("Caught error check. Either days too low, guests too high, or room occupied.");
            this.cost = 0;
            return null;
        }
        this.cost = 0;
        return null;
    }

    public void setGuest(Guest g) {this.assigned = g;}

    public int calculateRate(LocalDate date) {
        return weekdayRate * minimumNights;
    }
}
