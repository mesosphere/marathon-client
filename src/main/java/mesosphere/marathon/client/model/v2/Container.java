package mesosphere.marathon.client.model.v2;

import java.util.Collection;

import mesosphere.client.common.ModelUtils;

public class Container {
	private String type;
	private Docker docker;
	private Collection<Volume> volumes;
	private Collection<Port> portMappings;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Docker getDocker() {
		return docker;
	}

	public void setDocker(Docker docker) {
		this.docker = docker;
	}

	public Collection<Volume> getVolumes() {
		return volumes;
	}

	public void setVolumes(Collection<Volume> volumes) {
		this.volumes = volumes;
	}

	public Collection<Port> getPortMappings() {
		return portMappings;
	}

	public void setPortMappings(Collection<Port> portMappings) {
		this.portMappings = portMappings;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
