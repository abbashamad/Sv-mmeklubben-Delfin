public class SwimResult {
    Member member;
    Discipline discipline;
    private SwimTimer swimTime;
    private String competition;

    public SwimResult(Member member, Discipline discipline, SwimTimer swimTime, String competition) {
        this.member = member;
        this.competition = competition;
        this.swimTime = swimTime;
        this.discipline = discipline;
    }

    public Member getMember() {
        return member;
    }

    public Discipline getDisciplines() {
        return discipline;
    }


    public SwimTimer getSwimTime() {
        return swimTime;
    }


    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public void setDisciplines(Discipline discipline) {
        this.discipline = discipline;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}