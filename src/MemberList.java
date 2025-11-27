import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberList {
   List<Member> list;



   public void addToMemberList(LocalDate birthday, int id, String memberType, String email, String name){
       Member member = new Member(birthday, id, memberType, email, name);
       this.list.add(member);
   }

    public MemberList() {
        this.list = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "MemberList{" +
                "list=" + list +
                '}';
    }
}
