package mesosphere.dcos.client;

import java.util.List;
import java.util.Optional;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import mesosphere.client.common.ClientUtils;
import mesosphere.client.common.ThrowingSupplier;
import mesosphere.dcos.client.model.AuthenticateResponse;
import mesosphere.dcos.client.model.DCOSAuthCredentials;
import mesosphere.dcos.client.model.Secret;
import mesosphere.marathon.client.Marathon;
import mesosphere.marathon.client.MarathonClient;
import mesosphere.marathon.client.model.v2.App;
import mesosphere.marathon.client.model.v2.DeleteAppTasksResponse;
import mesosphere.marathon.client.model.v2.DeleteTaskCriteria;
import mesosphere.marathon.client.model.v2.GetAbdicateLeaderResponse;
import mesosphere.marathon.client.model.v2.GetAppNamespaceResponse;
import mesosphere.marathon.client.model.v2.GetAppVersionResponse;
import mesosphere.marathon.client.model.v2.GetEventSubscriptionRegisterResponse;
import mesosphere.marathon.client.model.v2.GetEventSubscriptionsResponse;
import mesosphere.marathon.client.model.v2.GetLeaderResponse;
import mesosphere.marathon.client.model.v2.GetMetricsResponse;
import mesosphere.marathon.client.model.v2.GetPluginsResponse;
import mesosphere.marathon.client.model.v2.GetServerInfoResponse;
import mesosphere.marathon.client.model.v2.GetTasksResponse;
import mesosphere.marathon.client.model.v2.Group;
import mesosphere.marathon.client.model.v2.Result;

@Headers({ "Content-Type: application/json", "Accept: application/json" })
public interface DCOS extends Marathon {
    // DCOS Auth
    @RequestLine("GET /acs/api/v1/auth/login")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + DCOSClient.DCOS_CLIENT_USER_AGENT)
    AuthenticateResponse authenticate(DCOSAuthCredentials credentials);

    // DCOS Secrets
    @RequestLine("GET /secrets/v1/secret/{secretStore}/{secretPath}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + DCOSClient.DCOS_CLIENT_USER_AGENT)
    Secret getSecret(@Param("secretStore") String secretStore,
                     @Param("secretPath") String secretPath)
            throws DCOSException;

    // Apps
    /**
     * @param namespace - All apps under this group/subgroups will be returned. Example "/products/us-east"
     * @return
     * @throws DCOSException
     */
    @RequestLine("GET /marathon/v2/apps/{namespace}/*")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetAppNamespaceResponse getApps(@Param("namespace") String namespace) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}?force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Result deleteApp(@Param("appId") String appId,
                     @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks?host={host}&force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    DeleteAppTasksResponse deleteAppTasksWithHost(@Param("appId") String appId,
                                                  @Param("host") String host,
                                                  @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks?host={host}&force={force}&scale=true")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Result deleteAppTasksAndScaleWithHost(@Param("appId") String appId,
                                          @Param("host") String host,
                                          @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks?host={host}&force={force}&wipe=true")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    DeleteAppTasksResponse deleteAppTasksAndWipeWithHost(@Param("appId") String appId,
                                                         @Param("host") String host,
                                                         @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks/{taskId}?force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    DeleteAppTasksResponse deleteAppTasksWithTaskId(@Param("appId") String appId,
                                                    @Param("taskId") String taskId,
                                                    @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks/{taskId}?force={force}&scale=true")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Result deleteAppTasksAndScaleWithTaskId(@Param("appId") String appId,
                                            @Param("taskId") String taskId,
                                            @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks/{taskId}?force={force}&wipe=true")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    DeleteAppTasksResponse deleteAppTasksAndWipeWithTaskId(@Param("appId") String appId,
                                                           @Param("taskId") String taskId,
                                                           @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("GET /marathon/v2/apps/{appId}/versions")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetAppVersionResponse getAppVersion(@Param("id") String appId) throws DCOSException;

    @RequestLine("GET /marathon/v2/apps/{appId}/versions/{version}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    App getAppVersion(@Param("appId") String appId,
                      @Param("version") String version)
            throws DCOSException;

    // Deployments
    @RequestLine("DELETE /marathon/v2/deployments/{deploymentId}?force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Result deleteDeployment(@Param("deploymentId") String id) throws DCOSException;

    // Groups
    @RequestLine("GET /marathon/v2/groups")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Group getGroups() throws DCOSException;

    @RequestLine("PUT /marathon/v2/groups?force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Result modifyGroup(@Param("force") boolean force, Group group) throws DCOSException;

    @RequestLine("POST /marathon/v2/groups?force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Result createGroup(@Param("force") boolean force, Group group) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/groups?force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Result deleteGroup(@Param("force") boolean force) throws DCOSException;

    @RequestLine("GET /marathon/v2/groups/versions")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    List<String> getGroupVersion() throws DCOSException;

    @RequestLine("PUT /marathon/v2/groups/{id}?force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Group modifyGroups(@Param("id") String id,
                       @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("POST /marathon/v2/groups/{id}?force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Group createGroups(@Param("id") String id,
                       @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/groups/{id}?force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Result deleteGroups(@Param("id") String id,
                        @Param("force") boolean force)
            throws DCOSException;

    @RequestLine("GET /marathon/v2/groups/{id}/versions")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    Result getGroupVersion(@Param("id") String id) throws DCOSException;

    // Tasks
    @RequestLine("GET /marathon/v2/tasks?status={status}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetTasksResponse getTasks(@Param("status") String status) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/tasks/delete?force={force}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetTasksResponse deleteTask(@Param("force") boolean force, DeleteTaskCriteria deleteTaskBody) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/tasks/delete?force={force}&scale=true")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetTasksResponse deleteTaskAndScale(@Param("force") boolean force, DeleteTaskCriteria deleteTaskBody)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/tasks/delete?force={force}&wipe=true")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetTasksResponse deleteTaskAndWipe(@Param("force") boolean force, DeleteTaskCriteria deleteTaskBody)
            throws DCOSException;

    // Event Subscriptions
    @RequestLine("GET /marathon/v2/eventSubscriptions")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetEventSubscriptionsResponse getSubscriptions() throws DCOSException;

    @RequestLine("POST /marathon/v2/eventSubscriptions?callbackUrl={url}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetEventSubscriptionRegisterResponse postSubscriptions(@Param("url") String url) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/eventSubscriptions?callbackUrl={url}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetEventSubscriptionRegisterResponse deleteSubscriptions(@Param("url") String url) throws DCOSException;

    // Server Info
    @RequestLine("GET /marathon/v2/info")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetServerInfoResponse getInfo() throws DCOSException;

    // GetLeaderResponse
    @RequestLine("GET /marathon/v2/leader")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetLeaderResponse getLeader() throws DCOSException;

    @RequestLine("DELETE /marathon/v2/leader")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetAbdicateLeaderResponse deleteLeader() throws DCOSException;

    // Plugins
    @RequestLine("GET /marathon/v2/plugins")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetPluginsResponse getPlugin() throws DCOSException;

    @RequestLine("GET /marathon/v2/plugins/{pluginId}/{path}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    void getPlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    @RequestLine("PUT /marathon/v2/plugins/{pluginId}/{path}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    void putPlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    @RequestLine("POST /marathon/v2/plugins/{pluginId}/{path}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    void postPlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/plugins/{pluginId}/{path}")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    void deletePlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    // Queue

    @RequestLine("DELETE /marathon/v2/queue/{appId}/delay")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    void deleteQueueDelay(@Param("appId") String appId) throws DCOSException;

    // Miscellaneous
    @RequestLine("GET /marathon/ping")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    String getPing() throws DCOSException;

    @RequestLine("GET /marathon/metrics")
    @Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetMetricsResponse getMetrics() throws DCOSException;

    // Convenience methods for identifiable resources.
    default Optional<App> maybeApp(final String id) throws DCOSException {
        return resource(() -> getApp(id).getApp());
    }

    default Optional<Group> maybeGroup(String id) throws DCOSException {
        return resource(() -> getGroup(id));
    }

    default Optional<Secret> maybeSecret(final String secretStore, final String secretPath) throws DCOSException {
        return resource(() -> getSecret(secretStore, secretPath));
    }

    default Optional<GetAppNamespaceResponse> maybeApps(final String namespace) throws DCOSException {
        return resource(() -> getApps(namespace));
    }

    /**
     * Calls the supplied {@code resourceSupplier} to retrieve a DCOS resource of type T.
     * <p/>
     * If a {@link DCOSException} is thrown by the {@code resourceSupplier}, it will be caught. If
     * {@link DCOSException#getStatus()} is 404, then an empty optional will be returned. Any other
     * {@link DCOSException} will be rethrown.
     * @param resourceSupplier {@link ThrowingSupplier} instance for accessing the resource.
     * @param <T> The resource type
     * @return The optional resource.
     * @throws DCOSException if a non-404 DCOSException is thrown.
     */
    default <T> Optional<T> resource(
            ThrowingSupplier<T, DCOSException> resourceSupplier)
            throws DCOSException {
        try {
            return Optional.of(resourceSupplier.get());
        } catch (DCOSException e) {
            if (e.getStatus() == 404) {
                return Optional.empty();
            }

            throw e;
        }
    }
}
