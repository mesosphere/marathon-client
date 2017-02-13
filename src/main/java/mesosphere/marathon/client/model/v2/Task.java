package mesosphere.marathon.client.model.v2;

import java.util.Collection;

import mesosphere.client.common.ModelUtils;

public class Task {
    private String id;
    private String slaveId;
    private String host;
    private String state;
    private String startedAt;
    private String stagedAt;
    private Collection<Integer> ports;
    private String version;
    private Collection<IpAddress> ipAddresses;
    private String appId;
    private Collection<Integer> servicePorts;
    private Collection<HealthCheckResults> healthCheckResults;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlaveId() {
        return slaveId;
    }

    public void setSlaveId(String slaveId) {
        this.slaveId = slaveId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getStagedAt() {
        return stagedAt;
    }

    public void setStagedAt(String stagedAt) {
        this.stagedAt = stagedAt;
    }

    public Collection<Integer> getPorts() {
        return ports;
    }

    public void setPorts(Collection<Integer> ports) {
        this.ports = ports;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Collection<IpAddress> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(Collection<IpAddress> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Collection<Integer> getServicePorts() {
        return servicePorts;
    }

    public void setServicePorts(Collection<Integer> servicePorts) {
        this.servicePorts = servicePorts;
    }

    public Collection<HealthCheckResults> getHealthCheckResults() {
        return healthCheckResults;
    }

    public void setHealthCheckResults(Collection<HealthCheckResults> healthCheckResults) {
        this.healthCheckResults = healthCheckResults;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
