package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class IpAddress {
    private String ipAddress;
    private String protocol;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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
