import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberList {
    List<Member> list;

    public MemberList() {
        this.list = new ArrayList<>();
    }

    public void addMemberToMemberList(LocalDate birthday, String email, String name, Gender gender) {
        Member member = new Member(birthday, email, name, gender);
        this.list.add(member);
    }


    public void addEliteToMemberList(LocalDate birthday, String email, String name, Gender gender) {
        EliteMember member = new EliteMember(birthday, email, name, gender);
        this.list.add(member);
    }

    public Member findMemberViaID(int id) {
        for (Member member : list) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    private List<EliteMember> checkMemberCriteria(AgeGroup ageGroup, Gender gender, Discipline discipline) {
        List<EliteMember> criteriaChecking = new ArrayList<>();
        for (Member member : this.list) {
            if (member instanceof EliteMember) {
                if (member.getAgeGroup() == ageGroup && member.getGender() == gender && ((EliteMember) member).isActiveInDiscipline(discipline)) {
                    criteriaChecking.add((EliteMember) member);
                }
            }
        }
        return criteriaChecking;
    }

    public List<SwimResult> top5ForDiscipline(AgeGroup ageGroup, Gender gender, Discipline discipline) {
        List<SwimResult> swimResults = new ArrayList<>();
        for (EliteMember member : checkMemberCriteria(ageGroup, gender, discipline)) {
            swimResults.add(member.getBestTimeForDiscipline(discipline));
        }
        swimResults.sort(new TimeComparator());
        return swimResults;
    }

    @Override
    public String toString() {
        String s = String.format("%-5s %-20s %-20s","ID" ,"NAME", "E-MAIL") + "\n";
        for (Member member : list) {
            s += member + "\n";

        }
        return s;
    }
}
