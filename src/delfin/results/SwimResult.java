package delfin.results;

import delfin.interfaces.Serializable;
import delfin.enums.Discipline;
import delfin.members.Member;

import java.time.LocalDate;

public class SwimResult implements Serializable {
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
        return String.format("%s %-12s %-15s %-14s %-17s", String.format("%04d ", member.getId()), member.getName(), discipline, swimTime, swimDate);
    }

    @Override
    public String serialize() {
        return String.format("training,%s,%s,%s,%s%n", member.getId(), discipline, swimTime, swimDate);
    }
}