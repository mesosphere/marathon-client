package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class LocalVolume extends Volume {
	private String hostPath;

	public String getHostPath() {
		return hostPath;
	}

	public void setHostPath(String hostPath) {
		this.hostPath = hostPath;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
