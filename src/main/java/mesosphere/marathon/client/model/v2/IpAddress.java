package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IpAddress {
    private IpDiscovery         discovery;
    private List<String>        groups;
    private Map<String, Object> labels;
    private String              networkName;

    public IpDiscovery getDiscovery() {
        return discovery;
    }

    public void setDiscovery(IpDiscovery discovery) {
        this.discovery = discovery;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public void addGroup(final String group) {
        if (this.groups == null) this.groups = new ArrayList<>(5);
        this.groups.add(group);
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }

    public void addLabel(final String key, final Object value) {
        if (key != null && key.trim().length() > 0 && value != null) {
            if (this.labels == null) {
                this.labels = new HashMap<>(5);
            }

            this.labels.put(key, value);
        }
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
