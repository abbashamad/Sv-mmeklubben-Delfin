import java.time.LocalDate;
import java.time.LocalDateTime;

public class SwimResults {
    Member member;
    Disciplines disciplines;
    private SwimTimer swimTime;
    private LocalDate swimDate;

    public SwimResults(Disciplines disciplines, SwimTimer swimTime, LocalDate swimDate) {
        this.swimDate = swimDate;
        this.swimTime = swimTime;
        this.disciplines = disciplines;
    }

    public Member getMember() {
        return member;
    }

    public Disciplines getDisciplines() {
        return disciplines;
    }


    public SwimTimer getSwimTime() {
        return swimTime;
    }


    public LocalDate getSwimDate() {
        return swimDate;
    }
}