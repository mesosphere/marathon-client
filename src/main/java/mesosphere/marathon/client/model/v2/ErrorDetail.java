package mesosphere.marathon.client.model.v2;

public class ErrorDetail {
    private String path;
    private String[] errors;

    public String getPath() {
        return path;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }
}
