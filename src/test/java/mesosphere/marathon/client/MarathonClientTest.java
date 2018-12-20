package mesosphere.marathon.client;

import feign.Response;
import mesosphere.marathon.client.MarathonClient;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MarathonClientTest {
    @Test
    public void exceptionContainErrorMessage() {
        MarathonClient.MarathonErrorDecoder errorDecoder = new MarathonClient.MarathonErrorDecoder();
        Exception result = errorDecoder.decode("", Response.create(400, "", new HashMap<>(), "{\"message\":\"Invalid JSON\"}".getBytes()));
        assertTrue(result.getMessage() + " should contain text 'Invalid JSON'", result.getMessage().contains("Invalid JSON"));
    }

    @Test
    public void exceptionWithErrorDetails() {
        MarathonClient.MarathonErrorDecoder errorDecoder = new MarathonClient.MarathonErrorDecoder();
        Exception result = errorDecoder.decode("", Response.create(400, "reason", new HashMap<>(), "{\"message\":\"Invalid JSON\", \"details\": [ { \"path\": \"/upgradeStrategy/minimumHealthCapacity\", \"errors\": [ \"is greater than 1\" ] } ]}".getBytes()));
        assertEquals("reason: Invalid JSON (/upgradeStrategy/minimumHealthCapacity: is greater than 1) (http status: 400)", result.getMessage());
    }

    @Test
    public void exceptionContainsOnlyReasonForDifferentFormattedMessage() {
        MarathonClient.MarathonErrorDecoder errorDecoder = new MarathonClient.MarathonErrorDecoder();
        Exception result = errorDecoder.decode("", Response.create(400, "reason", new HashMap<>(), "{\"nonExistingField\":\"Invalid JSON\"}".getBytes()));
        assertEquals("reason (http status: 400)", result.getMessage());
    }
}
