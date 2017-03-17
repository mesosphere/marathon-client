package mesosphere.marathon.client.model.v2;

import java.util.List;

import mesosphere.client.common.ModelUtils;

public class GetPluginsResponse {
    private List<Plugin> plugins;

    public List<Plugin> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<Plugin> plugins) {
        this.plugins = plugins;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
