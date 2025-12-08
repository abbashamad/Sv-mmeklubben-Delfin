import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {

    @org.junit.jupiter.api.Test
    void paymentPensioner() {
        Member member = new Member(LocalDate.of(1940, 10, 10), "@@", "name", Gender.FEMALE);
        assertEquals(1200, member.getPayment());
    }

    @org.junit.jupiter.api.Test
    void paymentSenior() {
        Member member = new Member(LocalDate.of(2000, 10, 10), "@@", "name", Gender.MALE);
        assertEquals(1600, member.getPayment());
    }

    @org.junit.jupiter.api.Test
    void paymentJunior() {
        Member member = new Member(LocalDate.of(2010, 10, 10), "@@", "name", Gender.MALE);
        assertEquals(1000, member.getPayment());
    }

    @org.junit.jupiter.api.Test
    void paymentPassive() {
        Member member = new Member(LocalDate.of(2010, 10, 10), "@@", "name", Gender.MALE);
        member.getSubscription().setIsActive(false);
        assertEquals(500, member.getPayment());
    }

    @org.junit.jupiter.api.Test
    void setPassive() {
        Member member = new Member(LocalDate.of(1940, 10, 10), "@@", "name", Gender.FEMALE);
        member.getSubscription().setIsActive(false);
        assertFalse(member.getSubscription().isActive());
    }

    @org.junit.jupiter.api.Test
    void setActive() {
        Member member = new Member(LocalDate.of(1940, 10, 10), "@@", "name", Gender.FEMALE);
        member.getSubscription().setIsActive(true);
        assertTrue(member.getSubscription().isActive());
    }

    @org.junit.jupiter.api.Test
    void setHasArrears() {
        Member member = new Member(LocalDate.of(2000, 10, 10), "@@", "name", Gender.FEMALE);

        // Starter som false
        assertFalse(member.getSubscription().isHasArrears());

        member.getSubscription().setHasArrears(true);

        assertTrue(member.getSubscription().isHasArrears());
    }
}