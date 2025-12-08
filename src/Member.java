import java.time.LocalDate;
import java.time.Period;

public class Member implements Serializable {
    protected final LocalDate birthday;
    private static int nextId = 1;
    protected final int id;
    protected String email;
    protected String name;
    protected final Gender gender;
    protected final Subscription subscription;


    public Member(LocalDate birthday, String email, String name, Gender gender) {
        this.birthday = birthday;
        this.id = nextId++;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.subscription = new Subscription();

    }

    public int getAge() {
        return Period.between(getBirthday(), LocalDate.now()).getYears();
    }

    public AgeGroup getAgeGroup() {
        if (getAge() < 18) {
            return AgeGroup.JUNIOR;
        } else return AgeGroup.SENIOR;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public double getPayment() {
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
        return String.format("%s %-10s %-10s", String.format("%04d ", id), name, email);
    }

    @Override
    public String serialize() {
        return String.format("member,%s,%s,%s,%s,%s,%s%n", birthday, email, name, gender, subscription.isActive(), subscription.isHasArrears());

    }
}

