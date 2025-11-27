import java.time.LocalDateTime;

public class EliteMember extends Member {

    public EliteMember(LocalDateTime birthday, int id, String memberType, String email, String name) {
        super(birthday, id, memberType, email, name);
    }
}
