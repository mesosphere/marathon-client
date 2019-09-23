package mesosphere.marathon.client;

import mesosphere.client.common.HttpResponseException;
import mesosphere.marathon.client.model.v2.ErrorDetail;
import mesosphere.marathon.client.model.v2.ErrorResponse;

public class MarathonException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public MarathonException(int status, String message) {
		super(status, message);
	}

	public MarathonException(int status, String reason, ErrorResponse response) {
		super(status, getDetailedMessage(response, reason));
	}

	private static String getDetailedMessage(ErrorResponse response, String reason) {
		if (response.getMessage() != null && !response.getMessage().equals("")) {
			StringBuilder newMessage = new StringBuilder();

			if (reason != null && !reason.equals("")) {
				newMessage.append(reason);
				newMessage.append(": ");
			}

			newMessage.append(response.getMessage());

			if (response.getDetails() != null && response.getDetails().length > 0) {
				newMessage.append(" (");
				newMessage.append(String.join(",", detailsAsStrings(response.getDetails())));
				newMessage.append(")");
			}

			return newMessage.toString();
		}
		return reason;
	}

	private static String[] detailsAsStrings(ErrorDetail[] details) {
		String[] result = new String[details.length];
		for (int i = 0; i < details.length; i++) {
			result[i] = details[i].getPath() + ": " + String.join(", ", details[i].getErrors());
		}
		return result;
	}
}
