package delfin.test;

import delfin.enums.Gender;
import delfin.members.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class SubscriptionTest {

    @org.junit.jupiter.api.Test
    void paymentPensioner() {
        Member member = new Member(LocalDate.of(1940, 10, 10), "@@", "name", Gender.FEMALE);
        Assertions.assertEquals(1200, member.getPayment());
    }

    @org.junit.jupiter.api.Test
    void paymentSenior() {
        Member member = new Member(LocalDate.of(2000, 10, 10), "@@", "name", Gender.MALE);
        Assertions.assertEquals(1600, member.getPayment());
    }

    @org.junit.jupiter.api.Test
    void paymentJunior() {
        Member member = new Member(LocalDate.of(2010, 10, 10), "@@", "name", Gender.MALE);
        Assertions.assertEquals(1000, member.getPayment());
    }

    @Test
    void paymentPassive() {
        Member member = new Member(LocalDate.of(2010, 10, 10), "@@", "name", Gender.MALE);
        member.getSubscription().setIsActive(false);
        Assertions.assertEquals(500, member.getPayment());
    }

    @org.junit.jupiter.api.Test
    void setPassive() {
        Member member = new Member(LocalDate.of(1940, 10, 10), "@@", "name", Gender.FEMALE);
        member.getSubscription().setIsActive(false);
        Assertions.assertFalse(member.getSubscription().isActive());
    }

    @org.junit.jupiter.api.Test
    void setActive() {
        Member member = new Member(LocalDate.of(1940, 10, 10), "@@", "name", Gender.FEMALE);
        member.getSubscription().setIsActive(false);
        member.getSubscription().setIsActive(true);
        Assertions.assertTrue(member.getSubscription().isActive());
    }

    @org.junit.jupiter.api.Test
    void setHasArrears() {
        Member member = new Member(LocalDate.of(2000, 10, 10), "@@", "name", Gender.FEMALE);

        // Starter som false
        Assertions.assertFalse(member.getSubscription().isHasArrears());

        member.getSubscription().setHasArrears(true);

        Assertions.assertTrue(member.getSubscription().isHasArrears());
    }
}