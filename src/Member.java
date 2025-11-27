import java.time.LocalDate;

public class Member {
    private LocalDate birthday;
    private int id;
    private String memberType;
    private String email;
    private String name;

    public Member(LocalDate birthday, int id, String memberType, String email, String name) {
        this.birthday = birthday;
        this.id = id;
        this.memberType = memberType;
        this.email = email;
        this.name = name;
    }

    public LocalDate getBirthday() {
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

    @Override
    public String toString() {
        return "Member{" +
                "birthday=" + birthday +
                ", id=" + id +
                ", memberType='" + memberType + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
