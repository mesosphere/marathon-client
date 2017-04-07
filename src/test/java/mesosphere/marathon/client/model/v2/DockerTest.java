package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class DockerTest {
    /**
     * Test that JSON app with portMappings is correctly handled by the client
     * and expected payload is delivered to the server.
     *
     * @throws Exception if problems arise
     */
    @Test
    public void testPortMappingsFromString() throws Exception {
        final String jsonString = "{\"id\":\"test\", " +
                "\"cmd\":\"echo\", " +
                "\"container\": {" +
                "   \"docker\":{" +
                "       \"image\":\"ubuntu\", " +
                "       \"portMappings\": [\n" +
                "        {\n" +
                "          \"containerPort\": 8080,\n" +
                "          \"protocol\": \"tcp\",\n" +
                "          \"labels\": {\n" +
                "            \"VIP_0\": \"/foo:8080\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]}}}";

        App app = ModelUtils.GSON.fromJson(jsonString, App.class);
        final Collection<Port> portMappings = app
                .getContainer()
                .getDocker()
                .getPortMappings();
        assertEquals(1, portMappings.size());

        for (Port p : portMappings) {
            assertEquals(Integer.valueOf(8080), p.getContainerPort());
            assertEquals("tcp", p.getProtocol());
            assertEquals(1, p.getLabels().size());
        }
    }

    /**
     * Test that "labels" in portMappings are handled correctly.
     *
     * @throws Exception on issues
     */
    @Test
    public void testDockerVIPFromString() throws Exception {
        final String jsonString = "{\"id\":\"test\", " +
                "\"cmd\":\"echo\", " +
                "\"container\": {" +
                "\"docker\":{" +
                "   \"image\":\"ubuntu\",  " +
                "   \"portMappings\": [\n" +
                "        {\n" +
                "          \"containerPort\": 8080,\n" +
                "          \"protocol\": \"tcp\",\n" +
                "          \"labels\": {\n" +
                "            \"VIP_0\": \"/foo:8080\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]}}}";

        App app = ModelUtils.GSON.fromJson(jsonString, App.class);
        final Collection<Port> portMappings = app
                .getContainer()
                .getDocker()
                .getPortMappings();
        assertEquals(1, portMappings.size());

        for (Port p : portMappings) {
            assertEquals("/foo:8080", p.getLabels().get("VIP_0"));
        }
    }
}