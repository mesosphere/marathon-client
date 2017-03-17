package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class Result {
	private String deploymentId;
	private String version;

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
