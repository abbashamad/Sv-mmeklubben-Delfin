import java.time.LocalDate;

public class SwimResult implements Serializable, Decodable {
    protected final Member member;
    protected final Discipline discipline;
    protected final SwimTimer swimTime;
    protected final LocalDate swimDate;

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
        return String.format("%-8d %-15s %-15s %-15s %-15s",member.getId(),member.getName(), discipline,swimTime,swimDate);
    }

    @Override
    public String serialize() {
        return String.format("training,%s,%s,%s%n",discipline, swimTime, swimDate);
    }

    public void decode(String record) {
        String[] fields = record.split(",");
        //new SwimResult(fields[0],fields);
    }
}