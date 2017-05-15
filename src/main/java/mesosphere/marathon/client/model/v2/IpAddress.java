package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

import java.util.ArrayList;
import java.util.List;

public class IpAddress {
    private IpDiscovery  discovery;
    private List<String> groups;
    private String       networkName;

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
