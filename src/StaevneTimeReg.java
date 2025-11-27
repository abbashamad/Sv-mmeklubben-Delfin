public class StaevneTimeReg extends SwimResults {

    private int placement;
    private String location;

    public StaevneTimeReg(int discipline, double time, double date, int id,
                          int placement, String location) {

        super(discipline, time, date, id);

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
                "discipline=" + getDisciplineName() +
                ", time=" + getTime() +
                ", date=" + getDate() +
                ", id=" + getId() +
                ", placement=" + placement +
                ", location='" + location + '\'' +
                '}';
    }
}