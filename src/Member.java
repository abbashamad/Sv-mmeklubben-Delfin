import java.time.LocalDate;
import java.time.Period;

public class Member {
    private LocalDate birthday;
    private static int nextId = 1;
    private int id;
    private String email;
    private String name;
    private Gender gender;
    private Subscription subscription;
    private AgeGroup ageGroup;


    public Member(LocalDate birthday, String email, String name, Gender gender) {
        this.birthday = birthday;
        this.id = nextId++;
        this.email = email;
        this.name = name;
        this.gender = gender;
        assignAgeGroup();
        this.subscription = new Subscription();

    }

    public void setMembershipType(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public int getAge(){
        return Period.between(getBirthday(), LocalDate.now()).getYears();
    }

    private void assignAgeGroup(){
        if (getAge() < 18){
            setMembershipType(AgeGroup.JUNIOR);
        }else setMembershipType(AgeGroup.SENIOR);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public double getPayment(){
        return subscription.payment(getAge());
    }

    public Subscription getSubscription() {
        return subscription;
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
        return String.format("%s %-10s %-10s",String.format("%04d ", id) ,name, email);
    }
}

