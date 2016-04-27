package mesosphere.marathon.client.model.v2;

import mesosphere.marathon.client.utils.ModelUtils;

import java.util.Collection;

public class QueueResponse {

    private Collection<QueueElement> queue;

    public Collection<QueueElement> getQueue() {
        return queue;
    }

    public void setQueue(Collection<QueueElement> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
