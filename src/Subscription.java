public class Subscription {
    private boolean isActive;
    private boolean hasArrears;


    public Subscription() {
        this.isActive = true;
        this.hasArrears = false;
    }

    public double payment(int age) {
        if (isActive == false) {
            return 500;
        }
        if (age < 18) {
            return 1000;
        } else if (age > 60)
            return 1600 * 0.75;
        return 1600;
    }

    public boolean isHasArrears() {
        return hasArrears;
    }

    public boolean isActive() {
        return isActive;
    }

    public String setActivity() {
        this.isActive = !isActive;
        if (isActive == false) {
            return "Is Inactive";
        }
        return "Is Active";
    }

    public void setHasArrears(boolean hasArrears) {
        this.hasArrears = hasArrears;
    }


}
