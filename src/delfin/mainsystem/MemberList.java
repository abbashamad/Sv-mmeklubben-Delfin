package delfin.mainsystem;

import delfin.economy.Economy;
import delfin.enums.AgeGroup;
import delfin.enums.Discipline;
import delfin.members.EliteMember;
import delfin.enums.Gender;
import delfin.members.Member;
import delfin.results.SwimResult;
import delfin.results.TimeComparator;

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

    public void addMemberToMemberList(Member member){
        this.memberList.add(member);
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


    /**
     * Sorts elite members in memberlists based on age group, gender and discipline
     * @param ageGroup : uses enum to sort by JUNIOR and SENIOR
     * @param gender: uses enum to sort by MALE or FEMALE
     * @param discipline: uses enum to sort by swim discipline
     * @return returns sorted list of elite members by indicated criteria
     */

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


    /**
     * Sorts elite members in memberlists based on age group and gender
     * @param ageGroup : uses enum to sort by JUNIOR and SENIOR
     * @param gender: uses enum to sort by MALE or FEMALE
     * @return returns sorted list of elite members by indicated criteria
     */

    private List<EliteMember> checkMemberCriteria(AgeGroup ageGroup, Gender gender) {
        List<EliteMember> list = new ArrayList<>();
        for (Member member : this.memberList) {
            if (member instanceof EliteMember) {
                if (member.getAgeGroup() == ageGroup && member.getGender() == gender) {
                    list.add((EliteMember) member);
                }
            }
        }
        return list;
    }

    /**
     * Sorts elite members in memberlists based on age group and gender
     * @param ageGroup : uses enum to sort by JUNIOR and SENIOR
     * @return returns sorted list of elite members by indicated criteria
     */

    private List<EliteMember> checkMemberCriteria(AgeGroup ageGroup) {
        List<EliteMember> list = new ArrayList<>();
        for (Member member : this.memberList) {
            if (member instanceof EliteMember) {
                if (member.getAgeGroup() == ageGroup) {
                    list.add((EliteMember) member);
                }
            }
        }
        return list;
    }

    public List<EliteMember> sortTeamByAgeGroup(AgeGroup ageGroup){
        return new ArrayList<>(checkMemberCriteria(ageGroup));
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

        if (top5ForDiscipline(ageGroup, gender, discipline).isEmpty()){
            System.out.println("No Record");
        }

        for (SwimResult swimResult : top5ForDiscipline(ageGroup, gender, discipline)) {
            s += swimResult + "\n";
        }
        System.out.println(s);
    }

    @Override
    public String toString() {
        String s = String.format("%-5s %-15s %-25s %s","ID", "NAME", "EMAIL","STATUS")+"\n";
        s += "-".repeat(60)+"\n";
        for (Member member : memberList) {
            s += member + "\n";

        }
        return s;
    }
}
