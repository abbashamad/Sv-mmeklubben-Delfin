import java.time.LocalDate;

public class SwimResult{
    private final Member member;
    private final Discipline discipline;
    private final SwimTimer swimTime;
    private final LocalDate swimDate;

    public SwimResult(Member member, Discipline discipline, SwimTimer swimTime, LocalDate swimDate) {
        this.member = member;
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