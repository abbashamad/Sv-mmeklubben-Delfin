import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EliteMemberTest {

    @Test
    void isActiveInDiscipline() {
        EliteMember eliteMember = new EliteMember(LocalDate.of(2001, 11, 5), "KASPER@RR", "KASPER", Gender.MALE);
        eliteMember.addSwimResultsToList(Discipline.CRAWL,new SwimTimer(1,43,245),LocalDate.of(2024,10,10));
        eliteMember.addCompSwimResultsToList(Discipline.BREASTSTROKE,new SwimTimer(2,1,5),LocalDate.of(2022,1,23),2,"DM");

        assertTrue(eliteMember.isActiveInDiscipline(Discipline.CRAWL));
        assertTrue(eliteMember.isActiveInDiscipline(Discipline.BREASTSTROKE));
        assertFalse(eliteMember.isActiveInDiscipline(Discipline.BUTTERFLY));
        assertFalse(eliteMember.isActiveInDiscipline(Discipline.BACKCRAWL));
    }

    @Test
    void getBestTimeForDiscipline() {
        EliteMember eliteMember = new EliteMember(LocalDate.of(2001, 11, 5), "KASPER@RR", "KASPER", Gender.MALE);
        eliteMember.addSwimResultsToList(Discipline.CRAWL,new SwimTimer(1,43,245),LocalDate.of(2024,10,10));
        eliteMember.addCompSwimResultsToList(Discipline.CRAWL,new SwimTimer(2,1,5),LocalDate.of(2022,1,23),1,"DM");

        eliteMember.addSwimResultsToList(Discipline.CRAWL,new SwimTimer(1,30,245),LocalDate.of(2020,10,10));

        eliteMember.addCompSwimResultsToList(Discipline.CRAWL,new SwimTimer(2,13,591),LocalDate.of(2021,4,13),5,"EM");
        eliteMember.addSwimResultsToList(Discipline.BUTTERFLY,new SwimTimer(1,30,0),LocalDate.of(2023,5,14));
        eliteMember.addCompSwimResultsToList(Discipline.CRAWL,new SwimTimer(1,57,5),LocalDate.of(2022,5,3),7,"VM");

        assertEquals(1,eliteMember.getBestTimeForDiscipline(Discipline.CRAWL).getSwimTime().getMin());
        assertEquals(30,eliteMember.getBestTimeForDiscipline(Discipline.CRAWL).getSwimTime().getSec());
        assertEquals(245,eliteMember.getBestTimeForDiscipline(Discipline.CRAWL).getSwimTime().getMilSec());
    }
}