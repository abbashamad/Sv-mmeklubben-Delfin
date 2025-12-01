import java.util.ArrayList;

public class SwimResultsList {

    private ArrayList<SwimResult> results = new ArrayList<>();

    public void addResult(SwimResult result) {
        results.add(result);
    }
    public void printResults(){}

    public ArrayList<SwimResult> getResults() { return results;}

}
