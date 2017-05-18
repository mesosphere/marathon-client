package mesosphere.client.common;

import com.google.common.base.MoreObjects;

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
     *
     * @return status code
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
        return MoreObjects.toStringHelper(this).omitNullValues().toString();
    }
}
