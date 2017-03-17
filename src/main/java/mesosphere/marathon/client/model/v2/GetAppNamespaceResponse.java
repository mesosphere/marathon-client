package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAppNamespaceResponse {
    @SerializedName("*")
    private List<App> apps;

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
