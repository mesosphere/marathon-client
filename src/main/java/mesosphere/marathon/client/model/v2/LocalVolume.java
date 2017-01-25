package mesosphere.marathon.client.model.v2;

import mesosphere.marathon.client.utils.ModelUtils;

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
