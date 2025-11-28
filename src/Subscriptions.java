public class Subscriptions {
boolean isActive;
boolean hasArrears;

    public Subscriptions() {
        this.isActive = true;
        this.hasArrears = false;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setHasArrears(boolean hasArrears) {
        this.hasArrears = hasArrears;
    }
}
