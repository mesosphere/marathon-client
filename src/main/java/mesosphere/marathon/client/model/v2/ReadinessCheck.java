package mesosphere.marathon.client.model.v2;

import java.util.Set;

import mesosphere.client.common.ModelUtils;

/**
 * @author Lewis Headden <lewis_headden@condenast.com>
 */
public class ReadinessCheck {
	private String name;
	private String protocol;
	private String path;
	private String portName;
	private int intervalSeconds;
	private int timeoutSeconds;
	private Set<Integer> httpStatusCodesForReady;
	private boolean preserveLastResponse;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(final String protocol) {
		this.protocol = protocol;
	}

	public String getPath() {
		return path;
	}

	public void setPath(final String path) {
		this.path = path;
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(final String portName) {
		this.portName = portName;
	}

	public int getIntervalSeconds() {
		return intervalSeconds;
	}

	public void setIntervalSeconds(final int intervalSeconds) {
		this.intervalSeconds = intervalSeconds;
	}

	public int getTimeoutSeconds() {
		return timeoutSeconds;
	}

	public void setTimeoutSeconds(final int timeoutSeconds) {
		this.timeoutSeconds = timeoutSeconds;
	}

	public Set<Integer> getHttpStatusCodesForReady() {
		return httpStatusCodesForReady;
	}

	public void setHttpStatusCodesForReady(final Set<Integer> httpStatusCodesForReady) {
		this.httpStatusCodesForReady = httpStatusCodesForReady;
	}

	public boolean isPreserveLastResponse() {
		return preserveLastResponse;
	}

	public void setPreserveLastResponse(final boolean preserveLastResponse) {
		this.preserveLastResponse = preserveLastResponse;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
