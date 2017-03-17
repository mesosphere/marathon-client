package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class SecretSource {
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(final String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
