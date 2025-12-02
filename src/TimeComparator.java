import java.util.Comparator;

public class TimeComparator implements Comparator<SwimResult> {
    @Override
    public int compare(SwimResult result1, SwimResult result2) {
        return result1.getSwimTime().compareTo(result2.getSwimTime());
    }
}
