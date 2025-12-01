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
    AgeGroup ageGroup;


    public Member(LocalDate birthday, String email, String name, Gender gender) {
        this.birthday = birthday;
        this.id = nextId++;
        this.email = email;
        this.name = name;
        this.gender = gender;
        assignMemberType();
        this.subscriptions = new Subscriptions();

    }

    public void setMembershipType(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public AgeGroup getMembershipType() {
        return ageGroup;
    }

    public int getAge(){
        return Period.between(getBirthday(), LocalDate.now()).getYears();
    }

    private void assignMemberType(){
        if (getAge() < 18){
            setMembershipType(AgeGroup.JUNIOR);
        }else setMembershipType(AgeGroup.SENIOR);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
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

