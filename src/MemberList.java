import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberList {
    private List<Member> memberList;

    public MemberList() {
        this.memberList = new ArrayList<>();
    }

    public String totalIncome(){
        return "Forventet samlet indkomst er: " + Economy.totalIncome(memberList);
    }

    public void addMemberToMemberList(LocalDate birthday, String email, String name, Gender gender) {
        Member member = new Member(birthday, email, name, gender);
        this.memberList.add(member);
    }


    public void addEliteToMemberList(LocalDate birthday, String email, String name, Gender gender) {
        EliteMember member = new EliteMember(birthday, email, name, gender);
        this.memberList.add(member);
    }

    public Member findMemberViaID(int id) {
        for (Member member : memberList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    private List<EliteMember> checkMemberCriteria(AgeGroup ageGroup, Gender gender, Discipline discipline) {
        List<EliteMember> list = new ArrayList<>();
        for (Member member : this.memberList) {
            if (member instanceof EliteMember) {
                if (member.getAgeGroup() == ageGroup && member.getGender() == gender && ((EliteMember) member).isActiveInDiscipline(discipline)) {
                    list.add((EliteMember) member);
                }
            }
        }
        return list;
    }

    public List<SwimResult> top5ForDiscipline(AgeGroup ageGroup, Gender gender, Discipline discipline) {
        List<SwimResult> swimResults = new ArrayList<>();
        for (EliteMember eliteMember : checkMemberCriteria(ageGroup, gender, discipline)) {
            swimResults.add(eliteMember.getBestTimeForDiscipline(discipline));
        }
        swimResults.sort(new TimeComparator());
        return swimResults;
    }

    @Override
    public String toString() {
        String s = "";
        for (Member member : memberList) {
            s += member + "\n";

        }
        return s;
    }
}
