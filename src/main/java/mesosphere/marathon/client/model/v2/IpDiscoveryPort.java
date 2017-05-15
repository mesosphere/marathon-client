package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class IpDiscoveryPort {
    private int    number;
    private String name;
    private String protocol;

    public IpDiscoveryPort() {}

    public IpDiscoveryPort(int number, String name, String protocol) {
        this.number = number;
        this.name = name;
        this.protocol = protocol;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
