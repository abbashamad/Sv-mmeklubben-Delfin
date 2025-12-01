import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EliteMember extends Member {

    ArrayList<SwimResult> swimResults;

    public EliteMember(LocalDate birthday, String email, String name, Gender gender) {
        super(birthday, email, name, gender);

        this.swimResults = new ArrayList<>();

    }
    public List<SwimResult>timer(Discipline discipline){
        List<SwimResult>checkingSwimResults = new ArrayList<>();
        for(SwimResult result : swimResults){
            if(discipline == result.discipline){
                checkingSwimResults.add(result);
            }
        }
        return swimResults;
    }

    public void addSwimResultsToList(Member member, Discipline discipline, SwimTimer time, LocalDate date) {
        this.swimResults.add(new SwimResult(member, discipline, time, date));
    }

    public void addCompSwimResultsToList(Member member, Discipline discipline, SwimTimer time, LocalDate date, int placement, String location) {
        this.swimResults.add(new CompetitionResult(member, discipline, time, date, placement, location));
    }

}
