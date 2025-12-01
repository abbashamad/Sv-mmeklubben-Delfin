import java.time.LocalDate;

public class SwimResult {
    Member member;
    Discipline discipline;
    private SwimTimer swimTime;
    private LocalDate swimDate;

    public SwimResult(Discipline discipline, SwimTimer swimTime, LocalDate swimDate) {
        this.swimDate = swimDate;
        this.swimTime = swimTime;
        this.discipline = discipline;
    }

    public Member getMember() {
        return member;
    }

    public Discipline getDiscipline() {
        return discipline;
    }


    public SwimTimer getSwimTime() {
        return swimTime;
    }


    public LocalDate getSwimDate() {
        return swimDate;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-15s %-15s %-15s",member.getId(),member.getName(), discipline,swimTime,swimDate);
    }
}