package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class AppVersionInfo {
    private String lastScalingAt;
    private String lastConfigChangeAt;

    public String getLastScalingAt() {
        return lastScalingAt;
    }

    public void setLastScalingAt(String lastScalingAt) {
        this.lastScalingAt = lastScalingAt;
    }

    public String getLastConfigChangeAt() {
        return lastConfigChangeAt;
    }

    public void setLastConfigChangeAt(String lastConfigChangeAt) {
        this.lastConfigChangeAt = lastConfigChangeAt;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
