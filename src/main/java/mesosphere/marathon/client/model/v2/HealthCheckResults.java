package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class HealthCheckResults {
    private Boolean alive;
    private Integer consecutiveFailures;
    private String firstSuccess;
    private String lastFailure;
    private String lastSuccess;
    private String lastFailureCause;
    private String taskId;

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Integer getConsecutiveFailures() {
        return consecutiveFailures;
    }

    public void setConsecutiveFailures(Integer consecutiveFailures) {
        this.consecutiveFailures = consecutiveFailures;
    }

    public String getFirstSuccess() {
        return firstSuccess;
    }

    public void setFirstSuccess(String firstSuccess) {
        this.firstSuccess = firstSuccess;
    }

    public String getLastFailure() {
        return lastFailure;
    }

    public void setLastFailure(String lastFailure) {
        this.lastFailure = lastFailure;
    }

    public String getLastSuccess() {
        return lastSuccess;
    }

    public void setLastSuccess(String lastSuccess) {
        this.lastSuccess = lastSuccess;
    }

    public String getLastFailureCause() {
        return lastFailureCause;
    }

    public void setLastFailureCause(String lastFailureCause) {
        this.lastFailureCause = lastFailureCause;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
