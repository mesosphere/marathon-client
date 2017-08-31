package mesosphere.marathon.client.model.v2;

public class VersionedApp extends App {
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}
}
