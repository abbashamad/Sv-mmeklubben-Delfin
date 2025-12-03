import java.util.List;

public class Economy {


    public static double totalIncome(List<Member>members){
        double i = 0;
        for(Member swimmers : members){
            i+=swimmers.getPayment();
        }
        return i;
    }
}
