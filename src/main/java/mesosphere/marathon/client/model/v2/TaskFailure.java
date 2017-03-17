package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class TaskFailure {
	private String appId;
	private String host;
	private String message;
	private String state;
	private String taskId;
	private String timestamp;
	private String version;
	private String slaveId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSlaveId() {
		return slaveId;
	}

	public void setSlaveId(String slaveId) {
		this.slaveId = slaveId;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}

}
