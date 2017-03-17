package mesosphere.marathon.client.model.v2;

import java.util.ArrayList;
import java.util.List;

import mesosphere.client.common.ModelUtils;

public class GetEventSubscriptionsResponse {

    private List<String> callbackUrls = new ArrayList<>();

    public List<String> getCallbackUrls() {
        return callbackUrls;
    }

    public void setCallbackUrls(List<String> callbackUrls) {
        this.callbackUrls = callbackUrls;
    }

    @Override
    public String toString() {
        return ModelUtils.GSON.toString();
    }
}
