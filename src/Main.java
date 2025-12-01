import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {


        MemberList list = new MemberList();
        list.addMemberToMemberList(LocalDate.of(2000, 11, 15), "kasper@@@", "Søren");


        list.addEliteToMemberList(LocalDate.of(2000,10,15) ,"kasperper@@" , "Sisse" );
        System.out.println(list.findMemberViaID(2));
        EliteMember eleteme = (EliteMember)list.findMemberViaID(2);
        eleteme.addSwimResultsToList(LocalDate.of(2004,11,5), new SwimTimer(1,22,44), Discipline.BACKCRAWL);


        MenuSystem menu = new MenuSystem(list);

        menu.showMainMenu();

    }
}