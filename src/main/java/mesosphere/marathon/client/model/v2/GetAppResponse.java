package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class GetAppResponse {
	private VersionedApp app;

	public VersionedApp getApp() {
		return app;
	}

	public void setApp(VersionedApp app) {
		this.app = app;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
