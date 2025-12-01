import java.time.LocalDate;
import java.time.Period;

public class Member {
    private LocalDate birthday;
    private static int nextId = 1;
    private int id;
    private String email;
    private String name;
    private Gender gender;
    Subscriptions subscriptions;
    MembershipType membershipType;


    public Member(LocalDate birthday, String email, String name, Gender gender) {
        this.birthday = birthday;
        this.id = nextId++;
        this.email = email;
        this.name = name;
        this.gender = gender;
        assignMemberType();
        this.subscriptions = new Subscriptions();

    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public int getAge(){
        return Period.between(getBirthday(), LocalDate.now()).getYears();
    }

    private void assignMemberType(){
        if (getAge() < 18){
            setMembershipType(MembershipType.JUNIOR);
        }else setMembershipType(MembershipType.SENIOR);
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

    @Override
    public String toString() {
        return String.format("%d %s %s",id, name, email);
    }
}

