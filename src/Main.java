import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {


        MemberList list = new MemberList();
        list.addToMemberList(LocalDate.of(2000,11,15), 1, "Normal", "kasper@@@", "Søren");
        System.out.println(list);
    }
}