package mesosphere.marathon.client;

import java.util.List;

import mesosphere.client.common.ClientUtils;
import mesosphere.marathon.client.model.v2.App;
import mesosphere.marathon.client.model.v2.DeleteAppTaskResponse;
import mesosphere.marathon.client.model.v2.DeleteAppTasksResponse;
import mesosphere.marathon.client.model.v2.Deployment;
import mesosphere.marathon.client.model.v2.GetAppResponse;
import mesosphere.marathon.client.model.v2.GetAppTasksResponse;
import mesosphere.marathon.client.model.v2.GetAppsResponse;
import mesosphere.marathon.client.model.v2.GetEventSubscriptionRegisterResponse;
import mesosphere.marathon.client.model.v2.GetEventSubscriptionsResponse;
import mesosphere.marathon.client.model.v2.GetServerInfoResponse;
import mesosphere.marathon.client.model.v2.GetTasksResponse;
import mesosphere.marathon.client.model.v2.Group;
import mesosphere.marathon.client.model.v2.QueueResponse;
import mesosphere.marathon.client.model.v2.Result;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface Marathon {
    // Apps
	@RequestLine("GET /v2/apps")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	GetAppsResponse getApps() throws MarathonException;

	@RequestLine("GET /v2/apps/{id}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	GetAppResponse getApp(@Param("id") String id) throws MarathonException;

	@RequestLine("GET /v2/apps/{id}/tasks")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	GetAppTasksResponse getAppTasks(@Param("id") String id) throws MarathonException;

	@RequestLine("GET /v2/tasks")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	GetTasksResponse getTasks() throws MarathonException;

	@RequestLine("POST /v2/apps")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	App createApp(App app) throws MarathonException;

	@RequestLine("PUT /v2/apps/{app_id}?force={force}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	Result updateApp(@Param("app_id") String appId, App app,
            @Param("force") boolean force) throws MarathonException;

	@RequestLine("POST /v2/apps/{id}/restart?force={force}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	void restartApp(@Param("id") String id,@Param("force") boolean force) throws MarathonException;

	@RequestLine("DELETE /v2/apps/{id}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	Result deleteApp(@Param("id") String id) throws MarathonException;

	@RequestLine("DELETE /v2/apps/{app_id}/tasks?host={host}&scale={scale}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	DeleteAppTasksResponse deleteAppTasks(@Param("app_id") String appId,
			@Param("host") String host, @Param("scale") String scale) throws MarathonException;

	@RequestLine("DELETE /v2/apps/{app_id}/tasks/{task_id}?scale={scale}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	DeleteAppTaskResponse deleteAppTask(@Param("app_id") String appId,
			@Param("task_id") String taskId, @Param("scale") String scale) throws MarathonException;

    // Groups
	@RequestLine("POST /v2/groups")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	Result createGroup(Group group) throws MarathonException;
	
	@RequestLine("DELETE /v2/groups/{id}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	Result deleteGroup(@Param("id") String id) throws MarathonException;
	
	@RequestLine("GET /v2/groups/{id}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	Group getGroup(@Param("id") String id) throws MarathonException;

    // Tasks

    // Deployments
	@RequestLine("GET /v2/deployments")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	List<Deployment> getDeployments() throws MarathonException;
	
	@RequestLine("DELETE /v2/deployments/{deploymentId}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	void cancelDeploymentAndRollback(@Param("deploymentId") String id) throws MarathonException;
	
	@RequestLine("DELETE /v2/deployments/{deploymentId}?force=true")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	void cancelDeployment(@Param("deploymentId") String id) throws MarathonException;

    // Event Subscriptions

    @RequestLine("POST /v2/eventSubscriptions?callbackUrl={url}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    public GetEventSubscriptionRegisterResponse register(@Param("url") String url) throws MarathonException;

    @RequestLine("DELETE /v2/eventSubscriptions?callbackUrl={url}")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    public GetEventSubscriptionRegisterResponse unregister(@Param("url") String url) throws MarathonException;

    @RequestLine("GET /v2/eventSubscriptions")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    public GetEventSubscriptionsResponse subscriptions() throws MarathonException;

    // Queue
	@RequestLine("GET /v2/queue")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
	QueueResponse getQueue() throws MarathonException;

    // Server Info
    @RequestLine("GET /v2/info")
	@Headers(ClientUtils.API_SOURCE_HEADER + ": " + MarathonClient.MARATHON_CLIENT_USER_AGENT)
    GetServerInfoResponse getServerInfo() throws MarathonException;

    // Miscellaneous


}
