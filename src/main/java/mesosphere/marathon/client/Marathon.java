package mesosphere.marathon.client;

import java.util.List;
import java.util.Map;

import mesosphere.client.common.HeaderUtils;
import mesosphere.marathon.client.model.v2.App;
import mesosphere.marathon.client.model.v2.DeleteAppTaskResponse;
import mesosphere.marathon.client.model.v2.DeleteAppTasksResponse;
import mesosphere.marathon.client.model.v2.Deployment;
import mesosphere.marathon.client.model.v2.GetAppResponse;
import mesosphere.marathon.client.model.v2.GetAppTasksResponse;
import mesosphere.marathon.client.model.v2.GetAppVersionsResponse;
import mesosphere.marathon.client.model.v2.GetAppsResponse;
import mesosphere.marathon.client.model.v2.GetEventSubscriptionRegisterResponse;
import mesosphere.marathon.client.model.v2.GetEventSubscriptionsResponse;
import mesosphere.marathon.client.model.v2.GetServerInfoResponse;
import mesosphere.marathon.client.model.v2.GetTasksResponse;
import mesosphere.marathon.client.model.v2.Group;
import mesosphere.marathon.client.model.v2.QueueResponse;
import mesosphere.marathon.client.model.v2.Result;
import mesosphere.marathon.client.model.v2.VersionedApp;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface Marathon {
	// Apps
	@RequestLine("GET /v2/apps")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	GetAppsResponse getApps() throws MarathonException;

	@RequestLine("GET /v2/apps")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	GetAppsResponse getApps(@QueryMap Map<String, String> queryMap) throws MarathonException;

	@RequestLine("GET /v2/apps/{id}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	GetAppResponse getApp(@Param("id") String id) throws MarathonException;

	@RequestLine("GET /v2/apps/{id}/tasks")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	GetAppTasksResponse getAppTasks(@Param("id") String id) throws MarathonException;

	@RequestLine("GET /v2/apps/{id}/versions")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	GetAppVersionsResponse getAppVersions(@Param("id") String id) throws MarathonException;

	@RequestLine("GET /v2/apps/{id}/versions/{version}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	App getAppVersion(@Param("id") String id, @Param("version") String version) throws MarathonException;

	@RequestLine("GET /v2/tasks")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	GetTasksResponse getTasks() throws MarathonException;

	@RequestLine("POST /v2/apps")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	VersionedApp createApp(App app) throws MarathonException;

	@RequestLine("PUT /v2/apps/{app_id}?force={force}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	Result updateApp(@Param("app_id") String appId, App app,
			@Param("force") boolean force) throws MarathonException;

	@RequestLine("POST /v2/apps/{id}/restart?force={force}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	Result restartApp(@Param("id") String id, @Param("force") boolean force) throws MarathonException;

	@RequestLine("DELETE /v2/apps/{id}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	Result deleteApp(@Param("id") String id) throws MarathonException;

	@RequestLine("DELETE /v2/apps/{app_id}/tasks?host={host}&scale={scale}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	DeleteAppTasksResponse deleteAppTasks(@Param("app_id") String appId,
			@Param("host") String host, @Param("scale") String scale) throws MarathonException;

	@RequestLine("DELETE /v2/apps/{app_id}/tasks/{task_id}?scale={scale}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	DeleteAppTaskResponse deleteAppTask(@Param("app_id") String appId,
			@Param("task_id") String taskId, @Param("scale") String scale) throws MarathonException;

	// Groups
	@RequestLine("POST /v2/groups")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	Result createGroup(Group group) throws MarathonException;

	@RequestLine("DELETE /v2/groups/{id}?force={force}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	Result deleteGroup(@Param("id") String id, @Param("force") boolean force) throws MarathonException;

	@RequestLine("GET /v2/groups/{id}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	Group getGroup(@Param("id") String id) throws MarathonException;

	@RequestLine("PUT /v2/groups/{id}?force={force}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	Result updateGroup(@Param("id") String id, @Param("force") boolean force, Group group) throws MarathonException;

	// Deployments
	@RequestLine("GET /v2/deployments")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	List<Deployment> getDeployments() throws MarathonException;

	@RequestLine("DELETE /v2/deployments/{deploymentId}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	Result cancelDeploymentAndRollback(@Param("deploymentId") String id) throws MarathonException;

	@RequestLine("DELETE /v2/deployments/{deploymentId}?force=true")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	void cancelDeployment(@Param("deploymentId") String id) throws MarathonException;

	// Event Subscriptions
	@RequestLine("POST /v2/eventSubscriptions?callbackUrl={url}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	public GetEventSubscriptionRegisterResponse register(@Param("url") String url) throws MarathonException;

	@RequestLine("DELETE /v2/eventSubscriptions?callbackUrl={url}")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	public GetEventSubscriptionRegisterResponse unregister(@Param("url") String url) throws MarathonException;

	@RequestLine("GET /v2/eventSubscriptions")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	public GetEventSubscriptionsResponse subscriptions() throws MarathonException;

	// Queue
	@RequestLine("GET /v2/queue")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	QueueResponse getQueue() throws MarathonException;

	// Server Info
	@RequestLine("GET /v2/info")
	@Headers(HeaderUtils.MARATHON_API_SOURCE_HEADER)
	GetServerInfoResponse getServerInfo() throws MarathonException;

	// Miscellaneous


}
