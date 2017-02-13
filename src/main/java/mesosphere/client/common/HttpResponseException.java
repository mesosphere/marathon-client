package mesosphere.client.common;

/**
 * Created by jt018805 on 11/11/16.
 */
public abstract class HttpResponseException extends RuntimeException {
    private int status;
    private String message;
    private final String methodKey;
    private final String details;

    protected HttpResponseException(int status, String message, String methodKey, String details) {
        this.status = status;
        this.message = message;
        this.methodKey = methodKey;
        this.details = details;
    }

    protected HttpResponseException(int status, String message) {
        this.status = status;
        this.message = message;
        details = null;
        methodKey = null;
    }

    /**
     * Gets the HTTP status code of the failure, such as 404.
     */
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message + " (http status: " + status + ")";
    }

    @Override
    public String toString() {
        final StringBuilder string = new StringBuilder();
        if (methodKey != null) {
            string.append("Error calling ").append(methodKey).append(": ");
        }
        string.append(message).append(" (http status: ").append(status)
                .append(")");
        if (details != null) {
            string.append("\n").append("Details: ").append(details);
        }
        return string.toString();
    }
}
