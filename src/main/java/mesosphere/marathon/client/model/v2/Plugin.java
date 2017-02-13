package mesosphere.marathon.client.model.v2;

import java.util.List;

import mesosphere.client.common.ModelUtils;

public class Plugin {
    private String id;
    private String implementation;
    private Info info;
    private String plugin;
    private List<String> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImplementation() {
        return implementation;
    }

    public void setImplementation(String implementation) {
        this.implementation = implementation;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public static class Info {
        private String version;
        private List<Object> array;
        private Boolean test;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public List<Object> getArray() {
            return array;
        }

        public void setArray(List<Object> array) {
            this.array = array;
        }

        public Boolean getTest() {
            return test;
        }

        public void setTest(Boolean test) {
            this.test = test;
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
