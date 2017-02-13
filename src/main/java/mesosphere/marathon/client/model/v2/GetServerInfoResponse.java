package mesosphere.marathon.client.model.v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mesosphere.client.common.ModelUtils;

public class GetServerInfoResponse {
    private String name;
    private String version;
    private String buildref;
    private Boolean elected;
    private String leader;
    private String frameworkId;
    private MarathonConfig marathon_config;
    private ZookeeperConfig zookeeper_config;
    private EventSubscriber event_subscriber;
    private HttpConfig http_config;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuildref() {
        return buildref;
    }

    public void setBuildref(String buildref) {
        this.buildref = buildref;
    }

    public Boolean getElected() {
        return elected;
    }

    public void setElected(Boolean elected) {
        this.elected = elected;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getFrameworkId() {
        return frameworkId;
    }

    public void setFrameworkId(String frameworkId) {
        this.frameworkId = frameworkId;
    }

    public MarathonConfig getMarathon_config() {
        return marathon_config;
    }

    public void setMarathon_config(MarathonConfig marathon_config) {
        this.marathon_config = marathon_config;
    }

    public ZookeeperConfig getZookeeper_config() {
        return zookeeper_config;
    }

    public void setZookeeper_config(ZookeeperConfig zookeeper_config) {
        this.zookeeper_config = zookeeper_config;
    }

    public EventSubscriber getEvent_subscriber() {
        return event_subscriber;
    }

    public void setEvent_subscriber(EventSubscriber event_subscriber) {
        this.event_subscriber = event_subscriber;
    }

    public HttpConfig getHttp_config() {
        return http_config;
    }

    public void setHttp_config(HttpConfig http_config) {
        this.http_config = http_config;
    }

    public class MarathonConfig {
        private String master;
        private Integer failover_timeout;
        private String framework_name;
        private Boolean ha;
        private Boolean checkpoint;
        private Integer local_port_min;
        private Integer local_port_max;
        private String executor;
        private String hostname;
        private String webui_url;
        private String mesos_role;
        private Integer task_launch_timeout;
        private Integer task_reservation_timeout;
        private Integer reconciliation_initial_delay;
        private Integer reconciliation_interval;
        private String mesos_user;
        private Integer leader_proxy_connection_timeout_ms;
        private Integer leader_proxy_read_timeout_ms;
        private List<String> features = new ArrayList<>();
        private String mesos_leader_ui_url;

        public String getMaster() {
            return master;
        }

        public void setMaster(String master) {
            this.master = master;
        }

        public Integer getFailover_timeout() {
            return failover_timeout;
        }

        public void setFailover_timeout(Integer failover_timeout) {
            this.failover_timeout = failover_timeout;
        }

        public String getFramework_name() {
            return framework_name;
        }

        public void setFramework_name(String framework_name) {
            this.framework_name = framework_name;
        }

        public Boolean getHa() {
            return ha;
        }

        public void setHa(Boolean ha) {
            this.ha = ha;
        }

        public Boolean getCheckpoint() {
            return checkpoint;
        }

        public void setCheckpoint(Boolean checkpoint) {
            this.checkpoint = checkpoint;
        }

        public Integer getLocal_port_min() {
            return local_port_min;
        }

        public void setLocal_port_min(Integer local_port_min) {
            this.local_port_min = local_port_min;
        }

        public Integer getLocal_port_max() {
            return local_port_max;
        }

        public void setLocal_port_max(Integer local_port_max) {
            this.local_port_max = local_port_max;
        }

        public String getExecutor() {
            return executor;
        }

        public void setExecutor(String executor) {
            this.executor = executor;
        }

        public String getHostname() {
            return hostname;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        public String getWebui_url() {
            return webui_url;
        }

        public void setWebui_url(String webui_url) {
            this.webui_url = webui_url;
        }

        public String getMesos_role() {
            return mesos_role;
        }

        public void setMesos_role(String mesos_role) {
            this.mesos_role = mesos_role;
        }

        public Integer getTask_launch_timeout() {
            return task_launch_timeout;
        }

        public void setTask_launch_timeout(Integer task_launch_timeout) {
            this.task_launch_timeout = task_launch_timeout;
        }

        public Integer getTask_reservation_timeout() {
            return task_reservation_timeout;
        }

        public void setTask_reservation_timeout(Integer task_reservation_timeout) {
            this.task_reservation_timeout = task_reservation_timeout;
        }

        public Integer getReconciliation_initial_delay() {
            return reconciliation_initial_delay;
        }

        public void setReconciliation_initial_delay(Integer reconciliation_initial_delay) {
            this.reconciliation_initial_delay = reconciliation_initial_delay;
        }

        public Integer getReconciliation_interval() {
            return reconciliation_interval;
        }

        public void setReconciliation_interval(Integer reconciliation_interval) {
            this.reconciliation_interval = reconciliation_interval;
        }

        public String getMesos_user() {
            return mesos_user;
        }

        public void setMesos_user(String mesos_user) {
            this.mesos_user = mesos_user;
        }

        public Integer getLeader_proxy_connection_timeout_ms() {
            return leader_proxy_connection_timeout_ms;
        }

        public void setLeader_proxy_connection_timeout_ms(Integer leader_proxy_connection_timeout_ms) {
            this.leader_proxy_connection_timeout_ms = leader_proxy_connection_timeout_ms;
        }

        public Integer getLeader_proxy_read_timeout_ms() {
            return leader_proxy_read_timeout_ms;
        }

        public void setLeader_proxy_read_timeout_ms(Integer leader_proxy_read_timeout_ms) {
            this.leader_proxy_read_timeout_ms = leader_proxy_read_timeout_ms;
        }

        public List<String> getFeatures() {
            return features;
        }

        public void setFeatures(List<String> features) {
            this.features = features;
        }

        public String getMesos_leader_ui_url() {
            return mesos_leader_ui_url;
        }

        public void setMesos_leader_ui_url(String mesos_leader_ui_url) {
            this.mesos_leader_ui_url = mesos_leader_ui_url;
        }

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }

    public class ZookeeperConfig {
        private String zk;
        private Integer zk_timeout;
        private Integer zk_session_timeout;
        private Integer zk_max_versions;

        public String getZk() {
            return zk;
        }

        public void setZk(String zk) {
            this.zk = zk;
        }

        public Integer getZk_timeout() {
            return zk_timeout;
        }

        public void setZk_timeout(Integer zk_timeout) {
            this.zk_timeout = zk_timeout;
        }

        public Integer getZk_session_timeout() {
            return zk_session_timeout;
        }

        public void setZk_session_timeout(Integer zk_session_timeout) {
            this.zk_session_timeout = zk_session_timeout;
        }

        public Integer getZk_max_versions() {
            return zk_max_versions;
        }

        public void setZk_max_versions(Integer zk_max_versions) {
            this.zk_max_versions = zk_max_versions;
        }

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }

    public class EventSubscriber {
        private String type;
        private Collection<String> http_endpoints;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Collection<String> getHttp_endpoints() {
            return http_endpoints;
        }

        public void setHttp_endpoints(Collection<String> http_endpoints) {
            this.http_endpoints = http_endpoints;
        }

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }

    public class HttpConfig {
        private String http_port;
        private String https_port;

        public String getHttp_port() {
            return http_port;
        }

        public void setHttp_port(String http_port) {
            this.http_port = http_port;
        }

        public String getHttps_port() {
            return https_port;
        }

        public void setHttps_port(String https_port) {
            this.https_port = https_port;
        }

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
