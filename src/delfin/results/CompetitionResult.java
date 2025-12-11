package delfin.results;

import delfin.enums.Discipline;
import delfin.members.Member;

import java.time.LocalDate;

/**
 *
 * Competition Results for Elite Swimmers, Uses Swim Result as template
 */
public class CompetitionResult extends SwimResult {
    private int placement;
    private String competitionName;

    public CompetitionResult(Member member, Discipline discipline, SwimTimer time, LocalDate date,
                             int placement, String competitionName) {

        super(member, discipline, time, date);
        this.placement = placement;
        this.competitionName = competitionName;
    }

    public int getPlacement() {
        return placement;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-7d %s", placement, competitionName);
    }

    @Override
    public String serialize() {
        return String.format("comp,%s,%s,%s,%s,%s,%s%n", member.getId(), discipline, swimTime, swimDate, placement, competitionName);
    }
}