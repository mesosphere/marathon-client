package mesosphere.marathon.client;

import mesosphere.client.common.HttpResponseException;

public class MarathonException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public MarathonException(int status, String message) {
		super(status, message);
	}
}
