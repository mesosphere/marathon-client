package mesosphere.marathon.client.model.v2;

import java.util.List;

import mesosphere.client.common.ModelUtils;

public class DeleteTaskCriteria {
    private List<String> ids;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
