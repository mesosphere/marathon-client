package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

import java.util.ArrayList;
import java.util.List;

public class IpDiscovery {
    private List<IpDiscoveryPort> ports;

    public List<IpDiscoveryPort> getPorts() {
        return ports;
    }

    public void setPorts(List<IpDiscoveryPort> ports) {
        this.ports = ports;
    }

    public void addPort(final IpDiscoveryPort port) {
        if (this.ports == null) this.ports = new ArrayList<>(5);

        this.ports.add(port);
    }

    public void addPort(int portNumber, final String portName, final String portProtocol) {
        if (this.ports == null) this.ports = new ArrayList<>(5);
        final IpDiscoveryPort port = new IpDiscoveryPort(portNumber, portName, portProtocol);
        this.ports.add(port);
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
