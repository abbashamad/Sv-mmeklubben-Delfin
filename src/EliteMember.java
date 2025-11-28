import java.time.LocalDate;
import java.util.ArrayList;

public class EliteMember extends Member {

    ArrayList<SwimResults> swimResults;

    public EliteMember(LocalDate birthday, String email, String name) {
        super(birthday, email, name);

        this.swimResults = new ArrayList<>();

    }

    public void addSwimResultsToList(LocalDate swimDate, SwimTimer swimTime, Disciplines disciplines) {
        this.swimResults.add(new SwimResults(disciplines, swimTime, swimDate));
    }

    public void addSwimResultsToList(Disciplines discipline, SwimTimer time, LocalDate date, int placement, String location) {
        this.swimResults.add(new StaevneTimeReg(discipline, time, date, placement, location));
    }

}
