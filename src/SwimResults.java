import java.time.LocalDate;
import java.time.LocalDateTime;

public class SwimResults {
    Member member;
    Disciplines disciplines;
    private LocalDateTime swimTime;
    private LocalDate swimDate;

    public SwimResults(Disciplines disciplines, LocalDateTime swimTime, LocalDate swimDate) {
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


    public LocalDateTime getSwimTime() {
        return swimTime;
    }


    public LocalDate getSwimDate() {
        return swimDate;
    }
}