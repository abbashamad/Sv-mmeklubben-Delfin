import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EliteMember extends Member {
    private ArrayList<SwimResult> swimResults;

    public EliteMember(LocalDate birthday, String email, String name, Gender gender) {
        super(birthday, email, name, gender);
        this.swimResults = new ArrayList<>();
    }

    public void addSwimResultsToList(Discipline discipline, SwimTimer time, LocalDate date) {
        this.swimResults.add(new SwimResult(this, discipline, time, date));
    }

    public void addCompSwimResultsToList(Discipline discipline, SwimTimer time, LocalDate date, int placement, String location) {
        this.swimResults.add(new CompetitionResult(this, discipline, time, date, placement, location));
    }

    public boolean isActiveInDiscipline(Discipline discipline) {
        for (SwimResult r : swimResults) {
            if (r.getDiscipline() == discipline) {
                return true;
            }
        }
        return false;
    }

    public List<SwimResult> getSwimResultForDiscipline(Discipline discipline) {
        List<SwimResult> checkingSwimResults = new ArrayList<>();
        for (SwimResult result : swimResults) {
            if (discipline == result.getDiscipline()) {
                checkingSwimResults.add(result);
            }
        }
        return checkingSwimResults;
    }

    public List<SwimResult> sortListByTime(Discipline discipline) {
        List<SwimResult> list = getSwimResultForDiscipline(discipline);
        list.sort(new TimeComparator());
        return list;
    }

    public SwimResult getBestTimeForDiscipline(Discipline discipline) {
        return sortListByTime(discipline).getFirst();
    }

}
