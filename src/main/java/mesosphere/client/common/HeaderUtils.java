package mesosphere.client.common;

public class HeaderUtils {
    // Used to designate what client the request is from since DCOS has several different APIs that can be used. This
    // allows us to flex some things specific to that API, such as adding "/marathon" to paths for all marathon calls.
    public static final String API_SOURCE_HEADER = "X-API-Source";
    public static final String MARATHON_API_SOURCE = "marathon/client";
    public static final String AUTH_API_SOURCE = "auth/client";
    public static final String SECRETS_API_SOURCE = "secret/client";
    public static final String MARATHON_API_SOURCE_HEADER = API_SOURCE_HEADER + ": " + MARATHON_API_SOURCE;
    public static final String AUTH_API_SOURCE_HEADER = API_SOURCE_HEADER + ": " + AUTH_API_SOURCE;
    public static final String SECRETS_API_SOURCE_HEADER = API_SOURCE_HEADER + ": " + SECRETS_API_SOURCE;
}
