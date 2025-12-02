import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {

    @org.junit.jupiter.api.Test
    void paymentPensioner() {
        Member member = new Member(LocalDate.of(1940,10,10),"@@","name",Gender.FEMALE);
      assertEquals(1200, member.getPayment());
    }

    @org.junit.jupiter.api.Test
    void paymentSenior() {
        Member member = new Member(LocalDate.of(2000,10,10),"@@","name",Gender.MALE);
        assertEquals(1600, member.getPayment());
    }

    @org.junit.jupiter.api.Test
    void paymentJunior() {
        Member member = new Member(LocalDate.of(2010,10,10),"@@","name",Gender.MALE);
        assertEquals(1000, member.getPayment());
    }

    @org.junit.jupiter.api.Test
    void setPassive() {
        Member member = new Member(LocalDate.of(1940,10,10),"@@","name",Gender.FEMALE);
      member.subscription.setActivity();
      assertEquals(false,member.subscription.isActive());
    }

    @org.junit.jupiter.api.Test
    void setActive() {
        Member member = new Member(LocalDate.of(1940,10,10),"@@","name",Gender.FEMALE);
        member.subscription.setActivity();
        member.subscription.setActivity();
        assertEquals(true,member.subscription.isActive());
    }

    @org.junit.jupiter.api.Test
    void setHasArrears() {
    }
}