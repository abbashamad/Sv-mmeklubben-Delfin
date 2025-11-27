import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class StaevneTimeReg extends SwimResults {

    private int placement;
    private String location;

    public StaevneTimeReg(Disciplines discipline, LocalDateTime time, LocalDate date,
                          int placement, String location) {

        super(discipline, time, date);
        this.placement = placement;
        this.location = location;
    }

    public int getPlacement() {
        return placement;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "StaevneTimeReg {" +
                "discipline=" + getDisciplines()+
                ", time=" + getSwimTime() +
                ", date=" + getSwimDate() +
                ", placement=" + placement +
                ", location='" + location + '\'' +
                '}';
    }
}