package mesosphere.marathon.client.model.v2;

import java.util.HashMap;
import java.util.Map;

import mesosphere.client.common.ModelUtils;

public class Network {
	public String name;
	public String mode;
	private Map<String, String> labels = new HashMap<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
