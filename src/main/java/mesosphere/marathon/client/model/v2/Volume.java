package mesosphere.marathon.client.model.v2;

import mesosphere.marathon.client.utils.ModelUtils;

public abstract class Volume {
	private String containerPath;
	private String mode;

	public String getContainerPath() {
		return containerPath;
	}

	public void setContainerPath(String containerPath) {
		this.containerPath = containerPath;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
