import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberList {
    private List<Member> memberList;

    public MemberList() {
        this.memberList = new ArrayList<>();
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void addMemberToMemberList(LocalDate birthday, String email, String name, Gender gender) {
        this.memberList.add(new Member(birthday, email, name, gender));
    }

    public void addEliteToMemberList(LocalDate birthday, String email, String name, Gender gender) {
        this.memberList.add(new EliteMember(birthday, email, name, gender));
    }

    public Member findMemberViaID(int id) {
        for (Member member : memberList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public String totalIncome() {
        return "Forventet samlet indkomst er: " + Economy.totalIncome(memberList);
    }

    public List<Member> getMembersInArrears() {
        return Economy.membersInArrears(memberList);
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

        int limit = Math.min(swimResults.size(), 5);//returns whichever is the smallest to counter index issue
        return swimResults.subList(0, limit);
    }

    public void top5ToString(AgeGroup ageGroup, Gender gender, Discipline discipline) {
        String s = "";

        for (SwimResult swimResult : top5ForDiscipline(ageGroup, gender, discipline)) {
            s += swimResult + "\n";
        }
        System.out.println(s);
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
