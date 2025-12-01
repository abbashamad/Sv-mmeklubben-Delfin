import java.time.LocalDate;
import java.util.ArrayList;

public class EliteMember extends Member {

    ArrayList<SwimResult> swimResults;

    public EliteMember(LocalDate birthday, String email, String name, Gender gender) {
        super(birthday, email, name, gender);

        this.swimResults = new ArrayList<>();

    }

//    public void addSwimResultsToList(LocalDate swimDate, SwimTimer swimTime, Discipline discipline) {
//        this.swimResults.add(new SwimResult(discipline, swimTime, swimDate));
//    }

    public void addSwimResultsToList(Member member, Discipline discipline, SwimTimer time, LocalDate date, int placement, String location) {
        this.swimResults.add(new CompetitionResult(member, discipline, time, date, placement, location));
    }

    @Override
    public String toString() {
        return "EliteMember" + getName();
    }
}
