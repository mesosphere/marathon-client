package mesosphere.marathon.client.model.v2;

public class Delay {
    private boolean overdue;
    private int timeLeftSeconds;

    public int getTimeLeftSeconds() {
        return timeLeftSeconds;
    }

    public void setTimeLeftSeconds(int timeLeftSeconds) {
        this.timeLeftSeconds = timeLeftSeconds;
    }

    public boolean isOverdue() {

        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }
}
