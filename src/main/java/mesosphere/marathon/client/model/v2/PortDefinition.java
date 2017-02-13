package mesosphere.marathon.client.model.v2;

import java.util.HashMap;
import java.util.Map;

import mesosphere.client.common.ModelUtils;

public class PortDefinition {
    private Integer port;
    private String protocol;
    private Map<String, String> labels = new HashMap<>();

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
