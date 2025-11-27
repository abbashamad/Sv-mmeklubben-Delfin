import java.time.LocalDateTime;

public class Member {
    private LocalDateTime birthday;
    private int id;
    private String memberType;
    private String email;
    private String name;

    public Member(LocalDateTime birthday, int id, String memberType, String email, String name) {
        this.birthday = birthday;
        this.id = id;
        this.memberType = memberType;
        this.email = email;
        this.name = name;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public String getMemberType() {
        return memberType;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }



}
