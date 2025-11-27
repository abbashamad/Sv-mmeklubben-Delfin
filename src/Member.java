import java.time.LocalDate;

public class Member {
    private LocalDate birthday;
    private int id;
    private String email;
    private String name;
    Subscriptions subscriptions;

    public Member(LocalDate birthday, int id, String email, String name) {
        this.birthday = birthday;
        this.id = id;
        this.email = email;
        this.name = name;
        this.subscriptions = new Subscriptions();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }


}
