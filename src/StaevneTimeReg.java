import java.time.LocalDate;

public class StaevneTimeReg extends SwimResult {

    private int placement;
    private String location;

    public StaevneTimeReg(Discipline discipline, SwimTimer time, LocalDate date,
                          int placement, String location) {

        super(discipline, time, date);
        this.placement = placement;
        this.location = location;}

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