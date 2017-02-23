package mesosphere.marathon.client.model.v2;

import java.util.*;

import mesosphere.client.common.ModelUtils;

public class App {

	public App() {
	}

	public static class Deployment {
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return ModelUtils.toString(this);
		}
	}

	private String id;
	private String cmd;
	private List<String> args;
	private String user;
	private Integer instances;
	private Double cpus;
	private Double mem;
	private Double disk;
	private Double gpus;
	private Collection<String> uris;
	private List<List<String>> constraints;
	private Collection<String> acceptedResourceRoles;
	private Container container;
	private Map<String, Object> env;
	private Map<String, String> labels;
	private String ipAddress;
	private String version;
	private String residency;
	private Integer taskKillGracePeriodSeconds;
	private Map<String, Object> secrets;
	private String executor;
	private List<String> fetch;
	private List<String> storeUrls;
	private List<Integer> ports;
	private List<PortDefinition> portDefinitions;
	private Boolean requirePorts;
	private Collection<String> dependencies;
	private Integer backoffSeconds;
	private Double backoffFactor;
	private Integer maxLaunchDelaySeconds;
	private Collection<Task> tasks;
    private AppVersionInfo versionInfo;
	private Integer tasksStaged;
	private Integer tasksRunning;
	private Integer tasksHealthy;
	private Integer tasksUnhealthy;
	private List<HealthCheck> healthChecks;
	private List<Object> readinessChecks;
	private UpgradeStrategy upgradeStrategy;

	private List<Deployment> deployments;
	private TaskFailure lastTaskFailure;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(final List<String> args) {
		this.args = args;
	}

	public String getUser() {
		return user;
	}

	public void setUser(final String user) {
		this.user = user;
	}

	public Integer getInstances() {
		return instances;
	}

	public void setInstances(Integer instances) {
		this.instances = instances;
	}

	public Double getCpus() {
		return cpus;
	}

	public void setCpus(Double cpus) {
		this.cpus = cpus;
	}

	public Double getMem() {
		return mem;
	}

	public void setMem(Double mem) {
		this.mem = mem;
	}

	public Double getDisk() {
		return disk;
	}

	public void setDisk(final Double disk) {
		this.disk = disk;
	}

	public Double getGpus() {
		return gpus;
	}

	public void setGpus(final Double gpus) {
		this.gpus = gpus;
	}

	public Collection<String> getUris() {
		return uris;
	}

	public void setUris(Collection<String> uris) {
		this.uris = uris;
	}

	public List<List<String>> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<List<String>> constraints) {
		this.constraints = constraints;
	}

	public void addConstraint(String attribute, String operator, String value) {
		if (this.constraints == null) {
			this.constraints = new ArrayList<List<String>>();
		}
		List<String> constraint = new ArrayList<String>(3);
		constraint.add(attribute == null ? "" : attribute);
		constraint.add(operator == null ? "" : operator);
		constraint.add(value == null ? "" : value);
		this.constraints.add(constraint);
	}

	public Collection<String> getAcceptedResourceRoles() {
		return acceptedResourceRoles;
	}

	public void setAcceptedResourceRoles(Collection<String> acceptedResourceRoles) {
		this.acceptedResourceRoles = acceptedResourceRoles;
	}

	public void addAcceptedResourceRole(String role) {
		if (this.acceptedResourceRoles == null) {
			this.acceptedResourceRoles = new HashSet<String>();
		}

		this.acceptedResourceRoles.add(role);
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Map<String, Object> getEnv() {
		return env;
	}

	public void setEnv(Map<String, Object> env) {
		this.env = env;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(final String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	public String getResidency() {
		return residency;
	}

	public void setResidency(final String residency) {
		this.residency = residency;
	}

	public Integer getTaskKillGracePeriodSeconds() {
		return taskKillGracePeriodSeconds;
	}

	public void setTaskKillGracePeriodSeconds(final Integer taskKillGracePeriodSeconds) {
		this.taskKillGracePeriodSeconds = taskKillGracePeriodSeconds;
	}

	public Map<String, Object> getSecrets() {
		return secrets;
	}

	public void setSecrets(final Map<String, Object> secrets) {
		this.secrets = secrets;
	}

	public void addLabel(final String key, final String value) {
		if (key != null && key.trim().length() > 0) {
			if (this.labels == null) {
				this.labels = new HashMap<String, String>();
			}
			this.labels.put(key, value == null ? "" : value);
		}
	}

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public List<String> getFetch() {
		return fetch;
	}

	public void setFetch(final List<String> fetch) {
		this.fetch = fetch;
	}

	public List<String> getStoreUrls() {
		return storeUrls;
	}

	public void setStoreUrls(final List<String> storeUrls) {
		this.storeUrls = storeUrls;
	}

	public List<Integer> getPorts() {
		return ports;
	}

	public void setPorts(List<Integer> ports) {
		this.ports = ports;
	}

	public List<PortDefinition> getPortDefinitions() {
		return portDefinitions;
	}

	public void setPortDefinitions(List<PortDefinition> portDefinitions) {
		this.portDefinitions = portDefinitions;
	}

	public Boolean getRequirePorts() {
		return requirePorts;
	}

	public void setRequirePorts(final Boolean requirePorts) {
		this.requirePorts = requirePorts;
	}

	public Collection<String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(final Collection<String> dependencies) {
		this.dependencies = dependencies;
	}

	public void addDependency(final String dependency) {
		if (dependency != null && dependency.trim().length() > 0) {
			if (this.dependencies == null) {
				this.dependencies = new HashSet<String>();
			}
			this.dependencies.add(dependency);
		}
	}

	public Integer getBackoffSeconds() {
		return backoffSeconds;
	}

	public void setBackoffSeconds(final Integer backoffSeconds) {
		this.backoffSeconds = backoffSeconds;
	}

	public Double getBackoffFactor() {
		return backoffFactor;
	}

	public void setBackoffFactor(final Double backoffFactor) {
		this.backoffFactor = backoffFactor;
	}

	public Integer getMaxLaunchDelaySeconds() {
		return maxLaunchDelaySeconds;
	}

	public void setMaxLaunchDelaySeconds(final Integer maxLaunchDelaySeconds) {
		this.maxLaunchDelaySeconds = maxLaunchDelaySeconds;
	}

	public void addUri(String uri) {
		if (this.uris == null) {
			this.uris = new ArrayList<String>();
		}
		this.uris.add(uri);
	}

	public void addPort(int port) {
		if (this.ports == null) {
			this.ports = new ArrayList<Integer>();
		}
		this.ports.add(port);
	}

	public Collection<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Collection<Task> tasks) {
		this.tasks = tasks;
	}

    public AppVersionInfo getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(final AppVersionInfo versionInfo) {
        this.versionInfo = versionInfo;
    }

	public Integer getTasksStaged() {
		return tasksStaged;
	}

	public void setTasksStaged(Integer tasksStaged) {
		this.tasksStaged = tasksStaged;
	}

	public Integer getTasksRunning() {
		return tasksRunning;
	}

	public void setTasksRunning(Integer tasksRunning) {
		this.tasksRunning = tasksRunning;
	}

	public Integer getTasksHealthy() {
		return tasksHealthy;
	}

	public void setTasksHealthy(Integer tasksHealthy) {
		this.tasksHealthy = tasksHealthy;
	}

	public Integer getTasksUnhealthy() {
		return tasksUnhealthy;
	}

	public void setTasksUnhealthy(Integer tasksUnhealthy) {
		this.tasksUnhealthy = tasksUnhealthy;
	}

	public List<HealthCheck> getHealthChecks() {
		return healthChecks;
	}

	public void setHealthChecks(List<HealthCheck> healthChecks) {
		this.healthChecks = healthChecks;
	}

	public List<Object> getReadinessChecks() {
		return readinessChecks;
	}

	public void setReadinessChecks(final List<Object> readinessChecks) {
		this.readinessChecks = readinessChecks;
	}

	public UpgradeStrategy getUpgradeStrategy() {
		return upgradeStrategy;
	}

	public List<Deployment> getDeployments() {
		return deployments;
	}

	public void setDeployments(List<Deployment> deployments) {
		this.deployments = deployments;
	}

	public void setUpgradeStrategy(final UpgradeStrategy upgradeStrategy) {
		this.upgradeStrategy = upgradeStrategy;
	}

	public TaskFailure getLastTaskFailure() {
		return lastTaskFailure;
	}

	public void setLastTaskFailure(TaskFailure lastTaskFailure) {
		this.lastTaskFailure = lastTaskFailure;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}


	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final App app = (App) o;
		return Objects.equals(id, app.id) && Objects.equals(cmd, app.cmd) && Objects.equals(args, app.args) && Objects
				.equals(user, app.user) && Objects.equals(instances, app.instances) && Objects.equals(cpus, app.cpus)
				&& Objects.equals(mem, app.mem) && Objects.equals(disk, app.disk) && Objects.equals(gpus, app.gpus)
				&& Objects.equals(uris, app.uris) && Objects.equals(constraints, app.constraints) && Objects
				.equals(acceptedResourceRoles, app.acceptedResourceRoles) && Objects.equals(container, app.container)
				&& Objects.equals(env, app.env) && Objects.equals(labels, app.labels) && Objects
				.equals(ipAddress, app.ipAddress) && Objects.equals(version, app.version) && Objects
				.equals(residency, app.residency) && Objects
				.equals(taskKillGracePeriodSeconds, app.taskKillGracePeriodSeconds) && Objects
				.equals(secrets, app.secrets) && Objects.equals(executor, app.executor) && Objects
				.equals(fetch, app.fetch) && Objects.equals(storeUrls, app.storeUrls) && Objects
				.equals(ports, app.ports) && Objects.equals(portDefinitions, app.portDefinitions) && Objects
				.equals(requirePorts, app.requirePorts) && Objects.equals(dependencies, app.dependencies) && Objects
				.equals(backoffSeconds, app.backoffSeconds) && Objects.equals(backoffFactor, app.backoffFactor)
				&& Objects.equals(maxLaunchDelaySeconds, app.maxLaunchDelaySeconds) && Objects.equals(tasks, app.tasks)
				&& Objects.equals(versionInfo, app.versionInfo) && Objects.equals(tasksStaged, app.tasksStaged)
				&& Objects.equals(tasksRunning, app.tasksRunning) && Objects.equals(tasksHealthy, app.tasksHealthy)
				&& Objects.equals(tasksUnhealthy, app.tasksUnhealthy) && Objects.equals(healthChecks, app.healthChecks)
				&& Objects.equals(readinessChecks, app.readinessChecks) && Objects
				.equals(upgradeStrategy, app.upgradeStrategy) && Objects.equals(deployments, app.deployments) && Objects
				.equals(lastTaskFailure, app.lastTaskFailure);
	}

	@Override
	public int hashCode() {
		return Objects
				.hash(id, cmd, args, user, instances, cpus, mem, disk, gpus, uris, constraints, acceptedResourceRoles,
						container, env, labels, ipAddress, version, residency, taskKillGracePeriodSeconds, secrets,
						executor, fetch, storeUrls, ports, portDefinitions, requirePorts, dependencies, backoffSeconds,
						backoffFactor, maxLaunchDelaySeconds, tasks, versionInfo, tasksStaged, tasksRunning,
						tasksHealthy, tasksUnhealthy, healthChecks, readinessChecks, upgradeStrategy, deployments,
						lastTaskFailure);
	}
}
