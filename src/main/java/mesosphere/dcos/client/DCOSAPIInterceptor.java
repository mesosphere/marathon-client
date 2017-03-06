package mesosphere.dcos.client;

import java.util.Collection;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import mesosphere.client.common.HeaderUtils;

public class DCOSAPIInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        Collection<String> apiSources = template.headers().get(HeaderUtils.API_SOURCE_HEADER);

        if (apiSources == null || apiSources.isEmpty()) {
            return;
        }

        if (apiSources.iterator().next().equals(HeaderUtils.MARATHON_API_SOURCE)) {
            template.insert(0, "/marathon");
        }

        template.header(HeaderUtils.API_SOURCE_HEADER);
    }
}
