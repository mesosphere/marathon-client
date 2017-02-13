package mesosphere.dcos.client;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import mesosphere.client.common.ThrowingSupplier;
import mesosphere.dcos.client.model.AuthenticateResponse;
import mesosphere.dcos.client.model.DCOSAuthCredentials;
import mesosphere.dcos.client.model.Secret;
import mesosphere.marathon.client.model.v2.App;
import mesosphere.marathon.client.model.v2.DeleteAppTasksResponse;
import mesosphere.marathon.client.model.v2.DeleteTaskCriteria;
import mesosphere.marathon.client.model.v2.Deployment;
import mesosphere.marathon.client.model.v2.GetAbdicateLeaderResponse;
import mesosphere.marathon.client.model.v2.GetAppNamespaceResponse;
import mesosphere.marathon.client.model.v2.GetAppResponse;
import mesosphere.marathon.client.model.v2.GetAppTasksResponse;
import mesosphere.marathon.client.model.v2.GetAppVersionResponse;
import mesosphere.marathon.client.model.v2.GetAppsResponse;
import mesosphere.marathon.client.model.v2.GetEventSubscriptionRegisterResponse;
import mesosphere.marathon.client.model.v2.GetEventSubscriptionsResponse;
import mesosphere.marathon.client.model.v2.GetServerInfoResponse;
import mesosphere.marathon.client.model.v2.GetLeaderResponse;
import mesosphere.marathon.client.model.v2.GetMetricsResponse;
import mesosphere.marathon.client.model.v2.GetPluginsResponse;
import mesosphere.marathon.client.model.v2.GetTasksResponse;
import mesosphere.marathon.client.model.v2.Group;
import mesosphere.marathon.client.model.v2.Queue;
import mesosphere.marathon.client.model.v2.Result;

/**
 * Created by jt018805 on 11/14/16.
 */
@Headers({ "Content-Type: application/json", "Accept: application/json" })
public interface DCOS {

    // DCOS Auth
    @RequestLine("GET /acs/api/v1/auth/login")
    AuthenticateResponse authenticate(DCOSAuthCredentials credentials);

    // DCOS Secrets
    @RequestLine("GET /secrets/v1/secret/{secretStore}/{secretPath}")
    Secret getSecret(@Param("secretStore") String secretStore, @Param("secretPath") String secretPath)
            throws DCOSException;

    // Apps
    @RequestLine("GET /marathon/v2/apps")
    GetAppsResponse getApps() throws DCOSException;

    /**
     * @param namespace - All apps under this group/subgroups will be returned. Example "/products/us-east"
     * @return
     * @throws DCOSException
     */
    @RequestLine("GET /marathon/v2/apps/{namespace}/*")
    GetAppNamespaceResponse getApps(@Param("namespace") String namespace) throws DCOSException;

    /**
     * @param namespace - All apps under this group/subgroups will be returned. Example "/products/us-east" * @param
     * @param queryMap - Map of query parameters
     * @return
     * @throws DCOSException
     */
    @RequestLine("GET /marathon/v2/apps/{namespace}/*")
    GetAppNamespaceResponse getApps(@Param("namespace") String namespace, @QueryMap Map<String, String> queryMap)
            throws DCOSException;

    @RequestLine("GET /marathon/v2/apps")
    GetAppsResponse getApp(@QueryMap Map<String, String> queryMap)
            throws DCOSException;

    @RequestLine("PUT /marathon/v2/apps")
    Result modifyApp(List<App> apps) throws DCOSException;

    @RequestLine("PUT /marathon/v2/apps?force=true")
    Result forceModifyApp(List<App> apps) throws DCOSException;

    @RequestLine("POST /marathon/v2/apps")
    App createApp(App app) throws DCOSException;

    @RequestLine("GET /marathon/v2/apps/{appId}")
    GetAppResponse getApp(@Param("appId") String appId) throws DCOSException;

    @RequestLine("PUT /marathon/v2/apps/{appId}")
    Result modifyApp(@Param("appId") String appId, App app) throws DCOSException;

    @RequestLine("PUT /marathon/v2/apps/{appId}?force=true")
    Result forceModifyApp(@Param("appId") String appId, App app)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}")
    Result deleteApp(@Param("appId") String appId) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}?force=true")
    Result forceDeleteApp(@Param("appId") String appId) throws DCOSException;

    @RequestLine("PUT /marathon/v2/apps/{appId}/restart")
    Result restartApp(@Param("appId") String appId, App app) throws DCOSException;

    @RequestLine("PUT /marathon/v2/apps/{appId}/restart?force=true")
    Result forceRestartApp(@Param("appId") String appId, App app)
            throws DCOSException;

    @RequestLine("GET /marathon/v2/apps/{appId}/tasks")
    GetAppTasksResponse getAppTasks(@Param("appId") String appId)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks?host={host}")
    DeleteAppTasksResponse deleteAppTasksWithHost(@Param("appId") String appId,
                                                  @Param("host") String host)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks?host={host}&force=true")
    DeleteAppTasksResponse forceDeleteAppTasksWithHost(@Param("appId") String appId,
            @Param("host") String host)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks?host={host}&scale=true")
    Result deleteAppTasksAndScaleWithHost(@Param("appId") String appId,
            @Param("host") String host)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks?host={host}&force=true&scale=true")
    Result forceDeleteAppTasksAndScaleWithHost(@Param("appId") String appId,
            @Param("host") String host)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks?host={host}&wipe=true")
    DeleteAppTasksResponse deleteAppTasksAndWipeWithHost(@Param("appId") String appId,
            @Param("host") String host)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks?host={host}&force=true&wipe=true")
    DeleteAppTasksResponse forceDeleteAppTasksAndWipeWithHost(@Param("appId") String appId,
            @Param("host") String host)
            throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks/{taskId}")
    DeleteAppTasksResponse deleteAppTasksWithTaskId(@Param("appId") String appId,
            @Param("taskId") String taskId) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks/{taskId}?force=true")
    DeleteAppTasksResponse forceDeleteAppTasksWithTaskId(@Param("appId") String appId,
            @Param("taskId") String taskId) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks/{taskId}?scale=true")
    Result deleteAppTasksAndScaleWithTaskId(@Param("appId") String appId,
            @Param("taskId") String taskId) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks/{taskId}?force=true&scale=true")
    Result forceDeleteAppTasksAndScaleWithTaskId(@Param("appId") String appId,
            @Param("taskId") String taskId) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks/{taskId}?wipe=true")
    DeleteAppTasksResponse deleteAppTasksAndWipeWithTaskId(@Param("appId") String appId,
            @Param("taskId") String taskId) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/apps/{appId}/tasks/{taskId}?force=true&wipe=true")
    DeleteAppTasksResponse forceDeleteAppTasksAndWipeWithTaskId(@Param("appId") String appId,
            @Param("taskId") String taskId) throws DCOSException;

    @RequestLine("GET /marathon/v2/apps/{appId}/versions")
    GetAppVersionResponse getAppVersion(@Param("id") String appId) throws DCOSException;

    @RequestLine("GET /marathon/v2/apps/{appId}/versions/{version}")
    App getAppVersion(@Param("appId") String appId, @Param("version") String version) throws DCOSException;

    // Deployments
    @RequestLine("GET /marathon/v2/deployments")
    List<Deployment> getDeployments() throws DCOSException;

    @RequestLine("DELETE /marathon/v2/deployments/{deploymentId}")
    Result deleteDeployment(@Param("deploymentId") String id) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/deployments/{deploymentId}?force=true")
    Result forceDeleteDeployment(@Param("deploymentId") String id) throws DCOSException;

    // Groups
    @RequestLine("GET /marathon/v2/groups")
    Group getGroups() throws DCOSException;

    @RequestLine("PUT /marathon/v2/groups")
    Result modifyGroup(Group group) throws DCOSException;

    @RequestLine("PUT /marathon/v2/groups?force=true")
    Result forceModifyGroup(Group group) throws DCOSException;

    @RequestLine("POST /marathon/v2/groups")
    Result createGroup(Group group) throws DCOSException;

    @RequestLine("POST /marathon/v2/groups?force=true")
    Result forceCreateGroup(Group group) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/groups")
    Result deleteGroup() throws DCOSException;

    @RequestLine("DELETE /marathon/v2/groups?force=true")
    Result forceDeleteGroup() throws DCOSException;

    @RequestLine("GET /marathon/v2/groups/versions")
    List<String> getGroupVersion() throws DCOSException;

    @RequestLine("GET /marathon/v2/groups/{id}")
    Group getGroup(@Param("id") String id) throws DCOSException;

    @RequestLine("PUT /marathon/v2/groups/{id}")
    Group modifyGroups(@Param("id") String id) throws DCOSException;

    @RequestLine("PUT /marathon/v2/groups/{id}?force=true")
    Group forceModifyGroup(@Param("id") String id) throws DCOSException;

    @RequestLine("POST /marathon/v2/groups/{id}")
    Group createGroup(@Param("id") String id) throws DCOSException;

    @RequestLine("POST /marathon/v2/groups/{id}?force=true")
    Group forceCreateGroup(@Param("id") String id) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/groups/{id}")
    Result deleteGroup(@Param("id") String id) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/groups/{id}")
    Result forceDeleteGroup(@Param("id") String id) throws DCOSException;

    @RequestLine("GET /marathon/v2/groups/{id}/versions")
    Result getGroupVersion(@Param("id") String id) throws DCOSException;

    // Tasks
    @RequestLine("GET /marathon/v2/tasks")
    GetTasksResponse getTasks() throws DCOSException;

    @RequestLine("GET /marathon/v2/tasks?status={status}")
    GetTasksResponse getTasks(@Param("status") String status) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/tasks/delete")
    GetTasksResponse deleteTask(DeleteTaskCriteria deleteTaskBody) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/tasks/delete?force=true")
    GetTasksResponse forceDeleteTask(DeleteTaskCriteria deleteTaskBody) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/tasks/delete?scale=true")
    GetTasksResponse deleteTaskAndScale(DeleteTaskCriteria deleteTaskBody) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/tasks/delete?force=true&scale=true")
    GetTasksResponse forceDeleteTaskAndScale(DeleteTaskCriteria deleteTaskBody) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/tasks/delete?wipe=true")
    GetTasksResponse deleteTaskAndWipe(DeleteTaskCriteria deleteTaskBody) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/tasks/delete?force=true&wipe=true")
    GetTasksResponse forceDeleteTaskAndWipe(DeleteTaskCriteria deleteTaskBody) throws DCOSException;

    // Artifacts
    // TODO can we or even should we support Artifacts?

    // Events
    // @RequestLine("GET /v2/events")
    // Object getEvents() throws DCOSException;

    // Event Subscriptions
    @RequestLine("GET /marathon/v2/eventSubscriptions")
    GetEventSubscriptionsResponse getSubscriptions() throws DCOSException;

    @RequestLine("POST /marathon/v2/eventSubscriptions?callbackUrl={url}")
    GetEventSubscriptionRegisterResponse postSubscriptions(@Param("url") String url) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/eventSubscriptions?callbackUrl={url}")
    GetEventSubscriptionRegisterResponse deleteSubscriptions(@Param("url") String url) throws DCOSException;

    // Server Info
    @RequestLine("GET /marathon/v2/info")
    GetServerInfoResponse getInfo() throws DCOSException;

    // GetLeaderResponse
    @RequestLine("GET /marathon/v2/leader")
    GetLeaderResponse getLeader() throws DCOSException;

    @RequestLine("DELETE /marathon/v2/leader")
    GetAbdicateLeaderResponse deleteLeader() throws DCOSException;

    // Plugins
    @RequestLine("GET /marathon/v2/plugins")
    GetPluginsResponse getPlugin() throws DCOSException;

    @RequestLine("GET /marathon/v2/plugins/{pluginId}/{path}")
    void getPlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    @RequestLine("PUT /marathon/v2/plugins/{pluginId}/{path}")
    void putPlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    @RequestLine("POST /marathon/v2/plugins/{pluginId}/{path}")
    void postPlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    @RequestLine("DELETE /marathon/v2/plugins/{pluginId}/{path}")
    void deletePlugin(@Param("pluginId") String pluginId, @Param("path") String path) throws DCOSException;

    // Queue
    @RequestLine("GET /marathon/v2/queue")
    Queue getQueue() throws DCOSException;

    @RequestLine("DELETE /marathon/v2/queue/{appId}/delay")
    void deleteQueueDelay(@Param("appId") String appId) throws DCOSException;

    // Miscellaneous
    @RequestLine("GET /marathon/ping")
    String getPing() throws DCOSException;

    @RequestLine("GET /marathon/metrics")
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

    default DeleteAppTasksResponse deleteAppTasksWithTaskId(String appId, String taskId, boolean force) throws DCOSException {
        if (force) {
            return deleteAppTasksWithTaskId(appId, taskId);
        } else {
            return forceDeleteAppTasksWithTaskId(appId, taskId);
        }
    }

    default Result deleteAppTasksAndScaleWithTaskId(String appId, String taskId, boolean force) throws DCOSException {
        if (force) {
            return deleteAppTasksAndScaleWithTaskId(appId, taskId);
        } else {
            return forceDeleteAppTasksAndScaleWithTaskId(appId, taskId);
        }
    }

    default DeleteAppTasksResponse deleteAppTasksAndWipeWithTaskId(String appId, String taskId, boolean force) throws DCOSException {
        if (force) {
            return deleteAppTasksAndWipeWithTaskId(appId, taskId);
        } else {
            return forceDeleteAppTasksAndWipeWithTaskId(appId, taskId);
        }
    }

    default DeleteAppTasksResponse deleteAppTasksFromHost(String appId, String host, boolean force) throws DCOSException {
        if (force) {
            return deleteAppTasksWithHost(appId, host);
        } else {
            return forceDeleteAppTasksWithHost(appId, host);
        }
    }

    default Result deleteAppTasksAndScaleFromHost(String appId, String host, boolean force) throws DCOSException {
        if (force) {
            return deleteAppTasksAndScaleWithHost(appId, host);
        } else {
            return forceDeleteAppTasksAndScaleWithHost(appId, host);
        }
    }

    default DeleteAppTasksResponse deleteAppTasksAndWipeFromHost(String appId, String host, boolean force) throws DCOSException {
        if (force) {
            return deleteAppTasksAndWipeWithHost(appId, host);
        } else {
            return forceDeleteAppTasksAndWipeWithHost(appId, host);
        }
    }

    default GetTasksResponse deleteTask(DeleteTaskCriteria deleteTaskBody, boolean force) throws DCOSException {
        if (force) {
            return forceDeleteTask(deleteTaskBody);
        } else {
            return deleteTask(deleteTaskBody);
        }
    }

    default GetTasksResponse deleteTaskAndWipe(DeleteTaskCriteria deleteTaskBody, boolean force) throws DCOSException {
        if (force) {
            return forceDeleteTaskAndWipe(deleteTaskBody);
        } else {
            return deleteTaskAndWipe(deleteTaskBody);
        }
    }

    default GetTasksResponse deleteTaskAndScale(DeleteTaskCriteria deleteTaskBody, boolean force) throws DCOSException {
        if (force) {
            return forceDeleteTaskAndScale(deleteTaskBody);
        } else {
            return deleteTaskAndScale(deleteTaskBody);
        }
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
