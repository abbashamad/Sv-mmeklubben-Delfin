import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        MemberList list = new MemberList();

        list.addEliteToMemberList(LocalDate.of(2011,11,5),"SS@@RR", "NAME1", Gender.FEMALE);
        EliteMember elite1 = (EliteMember)list.findMemberViaID(1);
        elite1.addCompSwimResultsToList(Discipline.CRAWL, new SwimTimer(1,3,82), LocalDate.of(2011,9,10) ,1, "Horsens");

        System.out.println(elite1.getBestTimeForDiscipline(Discipline.CRAWL));

        MenuSystem menu = new MenuSystem(list);

        menu.showMainMenu();

    }
}