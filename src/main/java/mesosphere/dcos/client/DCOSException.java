package mesosphere.dcos.client;

import mesosphere.client.common.HttpResponseException;

public class DCOSException extends HttpResponseException {
    private static final long serialVersionUID = 1L;

    public DCOSException(int status, String message, String methodKey, String details) {
        super(status, message, methodKey, details);
    }
}
