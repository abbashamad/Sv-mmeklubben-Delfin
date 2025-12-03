import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EconomyTest {

    @Test
    void totalIncome() {
        List<Member> members = new ArrayList<>();

        Member m1 = new Member(LocalDate.of(2000, 1, 1), "a@mail.com", "A", Gender.MALE);
        Member m2 = new Member(LocalDate.of(2010, 1, 1), "b@mail.com", "B", Gender.FEMALE);


        members.add(m1);
        members.add(m2);

        double expected = m1.getPayment() + m2.getPayment();

        assertEquals(expected, Economy.totalIncome(members));


    }

    @Test
    void memberInArrears() {
        List<Member> members = new ArrayList<>();

        Member m1 = new Member(LocalDate.of(2000, 1, 1), "a@mail.com", "A", Gender.MALE);
        Member m2 = new Member(LocalDate.of(2010, 1, 1), "b@mail.com", "B", Gender.FEMALE);

        m2.getSubscription().setHasArrears(true);

        members.add(m1);
        members.add(m2);

        List<Member> inArrears = Economy.membersInArrears(members);

        assertEquals(1, inArrears.size());
        assertTrue(inArrears.contains(m2));
        assertFalse(inArrears.contains(m1));
    }
}