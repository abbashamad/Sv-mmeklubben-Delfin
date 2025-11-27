import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberList {
    List<Member> list;

    public MemberList() {
        this.list = new ArrayList<>();
    }

    public void addMemberToMemberList(LocalDate birthday, int id, String memberType, String email, String name) {
        Member member = new Member(birthday, id, memberType, email, name);
        this.list.add(member);
    }

    public void addEliteToMemberList(LocalDate birthday, int id, String memberType, String email, String name) {
        Member member = new Member(birthday, id, memberType, email, name);
        this.list.add(member);
    }


    @Override
    public String toString() {
        return "MemberList{" +
                "list=" + list +
                '}';
    }
}
