package mesosphere.dcos.client;

import mesosphere.client.common.HttpResponseException;

/**
 * Created by jt018805 on 11/11/16.
 */
public class DCOSException extends HttpResponseException {
    private static final long serialVersionUID = 1L;

    public DCOSException(int status, String message, String methodKey, String details) {
        super(status, message, methodKey, details);
    }
}
