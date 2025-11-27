import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EliteMember extends Member {

ArrayList <SwimResults> swimResults;

    public EliteMember(LocalDate birthday, int id, String email, String name) {
        super(birthday, id, email, name);

       this.swimResults = new ArrayList<>();

    }

    public void addSwimResultsToList(LocalDate swimDate, LocalDateTime swimTime, Disciplines disciplines){
        this.swimResults.add(new SwimResults(swimDate,swimTime,disciplines));
    }
public void addCompetitionResultToList(int discipline, double time, double date, int placement, String location){
        this.swimResults.add(new SwimResults(discipline,time,date,placement,location));
}

}
