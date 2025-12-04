import java.time.LocalDate;
import java.time.Period;

public class Member implements Serializable, Decodable{
    private final LocalDate birthday;
    private static int nextId = 1;
    private final int id;
    private String email;
    private String name;
    private final Gender gender;
    private final Subscription subscription;


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
        return String.format("M,%s,%s,%s,%s,%s%n",birthday, email, name, gender, subscription.isActive());

    }

    @Override
    public void decode(String record) {
        String[] fields = record.split(",");
        Member member = new Member(LocalDate.parse(fields[1]),fields[2],fields[3],Gender.valueOf(fields[4]));

        if (!Boolean.parseBoolean(fields[5])){
            member.getSubscription().changeSubscriptionType();
        }

    }
}

