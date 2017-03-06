package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;

public class Fetchable {
    private String uri;
    private Boolean executable;
    private Boolean extract;
    private Boolean cache;
    private String outputFile;

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Boolean getExecutable() {
        return executable;
    }

    public void setExecutable(Boolean executable) {
        this.executable = executable;
    }

    public Boolean getExtract() {
        return extract;
    }

    public void setExtract(Boolean extract) {
        this.extract = extract;
    }

    public Boolean getCache() {
        return cache;
    }

    public void setCache(Boolean cache) {
        this.cache = cache;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }
}
