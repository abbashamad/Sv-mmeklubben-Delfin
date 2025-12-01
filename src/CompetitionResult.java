import java.time.LocalDate;

public class CompetitionResult extends SwimResult {
    private int placement;
    private String location;

    public CompetitionResult(Discipline discipline, SwimTimer time, LocalDate date,
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
        return String.format("%-30s %-10d %s", super.toString(), placement, location);
    }
}