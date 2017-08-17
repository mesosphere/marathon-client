package mesosphere.marathon.client.model.v2;

/**
 * @author Lewis Headden <lewis_headden@condenast.com>
 */
public class VersionedApp extends App {
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}
}
