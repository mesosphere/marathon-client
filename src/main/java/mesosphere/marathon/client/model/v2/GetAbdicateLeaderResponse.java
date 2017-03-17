package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

/**
 * Created by tt044106 on 10/28/16.
 */
public class GetAbdicateLeaderResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
