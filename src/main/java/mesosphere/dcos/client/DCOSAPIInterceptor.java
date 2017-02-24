package mesosphere.dcos.client;

import java.util.Collection;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import mesosphere.client.common.ClientUtils;
import mesosphere.marathon.client.MarathonClient;

public class DCOSAPIInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        Collection<String> apiSources = template.headers().get(ClientUtils.API_SOURCE_HEADER);

        if (apiSources == null || apiSources.isEmpty()) {
            return;
        }

        if (apiSources.iterator().next().equals(MarathonClient.MARATHON_CLIENT_USER_AGENT)) {
            template.insert(0, "/marathon");
        }
    }
}
