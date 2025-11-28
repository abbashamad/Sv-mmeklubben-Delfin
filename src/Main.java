import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {


        MemberList list = new MemberList();
        list.addMemberToMemberList(LocalDate.of(2000, 11, 15), "kasper@@@", "Søren");
        System.out.println(list);

        list.addEliteToMemberList(LocalDate.of(2000,10,15) ,"kasperper@@" , "Sisse" );
        list.

    }
}