package main.java.edu.metrostate.oodi.hotel;
import java.time.LocalDate;
//import java.time.format.TextStyle;
//import java.util.Locale;

public class Stay {
    public LocalDate startedAt;
    public LocalDate endedAt;

    public Stay(LocalDate start, LocalDate end) {
        this.startedAt = start;
        this.endedAt = end;
    }

    public LocalDate getStartDate() {return this.startedAt;}
    public LocalDate getEndDate() {return this.endedAt;}

    public int getStayDuration() {
        int duration = this.endedAt.getDayOfMonth() - this.startedAt.getDayOfMonth();
        if (duration < 0) {duration = duration * -1;} //placeholder
        return duration;
    }

    public void setEndDate(LocalDate date) {
        this.endedAt = date;
    }
}
