package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

/**
 * Represents information about attempting a {@link HealthCheck} on a task.
 *
 * @author Eric Bottard
 */
public class HealthCheckResult {

	private boolean alive;
	private int consecutiveFailures;
	private String firstSuccess;
	private String lastFailure;
	private String lastSuccess;
	private String taskId;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getConsecutiveFailures() {
		return consecutiveFailures;
	}

	public void setConsecutiveFailures(int consecutiveFailures) {
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
