package mesosphere.marathon.client.model.v2;

public class Residency {
    private int    relaunchEscalationTimeoutSeconds;
    private String taskLostBehavior;

    public int getRelaunchEscalationTimeoutSeconds() {
        return relaunchEscalationTimeoutSeconds;
    }

    public void setRelaunchEscalationTimeoutSeconds(int relaunchEscalationTimeoutSeconds) {
        this.relaunchEscalationTimeoutSeconds = relaunchEscalationTimeoutSeconds;
    }

    public String getTaskLostBehavior() {
        return taskLostBehavior;
    }

    public void setTaskLostBehavior(final String taskLostBehavior) {
        this.taskLostBehavior = taskLostBehavior;
    }
}
