package mesosphere.marathon.client.model.v2;

import java.util.Collection;

import mesosphere.client.common.ModelUtils;

/**
 * Created by tt044106 on 10/28/16.
 */
public class GetAppVersionsResponse {
    private Collection<String> versions;

    public Collection<String> getVersions() {
        return versions;
    }

    public void setVersions(Collection<String> versions) {
        this.versions = versions;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
