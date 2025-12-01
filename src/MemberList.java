import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberList {
    List<Member> list;

    public MemberList() {
        this.list = new ArrayList<>();
    }

    public void addMemberToMemberList(LocalDate birthday, String email, String name) {
        Member member = new Member(birthday, email, name);
        this.list.add(member);
    }


    public void addEliteToMemberList(LocalDate birthday, String email, String name) {
        Member member = new Member(birthday, email, name);
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
        return "MemberList{" +
                "list=" + list +
                '}';
    }
}

