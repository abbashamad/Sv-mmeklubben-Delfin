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



    @Override
    public String toString() {
          String s = "";
        for (Member member : list) {
              s += member + "\n";

        }
        return s;
    }
}
