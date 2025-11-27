import java.time.LocalDate;

public class EliteMember extends Member {

    public EliteMember(LocalDate birthday, int id, String memberType, String email, String name) {
        super(birthday, id, memberType, email, name);
    }
}
