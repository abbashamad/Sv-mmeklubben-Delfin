public class Subscription {
    private boolean isActive;
    private boolean hasArrears;

    /**
     * Handles payment calculations for members in clubs
     *
     */

    public Subscription() {
        this.isActive = true;
        this.hasArrears = false;
    }

    /**
     * Auto-calculates payment by age and if they have an active or inactive subscription
     * @param age: Age of member
     * @return : calculated amount
     */
    public double payment(int age) {
        if (!isActive) {
            return 500;
        }
        if (age < 18) {
            return 1000;
        } else if (age > 60) {
            return 1600 * 0.75;
        }
        return 1600;
    }

    public boolean isHasArrears() {
        return hasArrears;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setHasArrears(boolean hasArrears) {
        this.hasArrears = hasArrears;
    }


}
