import java.util.ArrayList;
import java.util.List;

public class Economy {

    public static double totalIncome(List<Member> members) {
        double i = 0;
        for (Member swimmers : members) {
            i += swimmers.getPayment();
        }
        return i;
    }

    public static List<Member> membersInArrears(List<Member> members) {
        List<Member> inArrears = new ArrayList<>();

        for (Member member : members) {
            if (member.getSubscription().isHasArrears()) {
                inArrears.add(member);
            }
        }

        return inArrears;
    }
}
