package mesosphere.marathon.client.model.v2;

public class ErrorResponse {
    private String message;
    private ErrorDetail[] details;

    public ErrorDetail[] getDetails() {
        return details;
    }

    public void setDetails(ErrorDetail[] details) {
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
