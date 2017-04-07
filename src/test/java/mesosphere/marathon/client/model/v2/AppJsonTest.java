package mesosphere.marathon.client.model.v2;

import mesosphere.client.common.ModelUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Tests for creating an App from a JSON string.
 */
public class AppJsonTest {
    /**
     * Test the example app JSON from the Marathon docs website.
     * https://mesosphere.github.io/marathon/api-console/index.html
     *
     * @throws Exception if bad things happen
     */
    @Test
    public void testExampleJson() throws Exception {
        final String exampleString = "{\n" +
                "  \"id\": \"/foo\",\n" +
                "  \"instances\": 2,\n" +
                "  \"cmd\": \"sleep 1000\",\n" +
                "  \"cpus\": 0.1,\n" +
                "  \"disk\": 0,\n" +
                "  \"mem\": 16,\n" +
                "  \"acceptedResourceRoles\": [\n" +
                "    \"mesos_role\"\n" +
                "  ],\n" +
                "  \"args\": [\n" +
                "    \"sleep\",\n" +
                "    \"100\"\n" +
                "  ],\n" +
                "  \"backoffFactor\": 1.15,\n" +
                "  \"backoffSeconds\": 1,\n" +
                "  \"constraints\": [\n" +
                "    [\n" +
                "      \"hostname\",\n" +
                "      \"LIKE\",\n" +
                "      \"srv2.*\"\n" +
                "    ]\n" +
                "  ],\n" +
                "  \"container\": {\n" +
                "    \"docker\": {\n" +
                "      \"forcePullImage\": false,\n" +
                "      \"image\": \"mesosphere:marathon/latest\",\n" +
                "      \"network\": \"BRIDGE\",\n" +
                "      \"parameters\": [\n" +
                "        {\n" +
                "          \"key\": \"name\",\n" +
                "          \"value\": \"kdc\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"portMappings\": [\n" +
                "        {\n" +
                "          \"containerPort\": 80,\n" +
                "          \"hostPort\": 0,\n" +
                "          \"protocol\": \"tcp\",\n" +
                "          \"servicePort\": 10019,\n" +
                "          \"name\": \"http\",\n" +
                "          \"labels\": {\n" +
                "            \"vip\": \"192.168.0.1:80\"\n" +
                "          }\n" +
                "        }\n" +
                "      ],\n" +
                "      \"privileged\": false\n" +
                "    },\n" +
                "    \"type\": \"DOCKER\",\n" +
                "    \"volumes\": [\n" +
                "      {\n" +
                "        \"containerPath\": \"/docker_storage\",\n" +
                "        \"hostPath\": \"/hdd/tools/docker/registry\",\n" +
                "        \"mode\": \"RW\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"dependencies\": [\n" +
                "    \"/prod/group\"\n" +
                "  ],\n" +
                "  \"env\": {\n" +
                "    \"XPS1\": \"Test\",\n" +
                "    \"XPS2\": \"Rest\",\n" +
                "    \"PASSWORD\": {\n" +
                "      \"secret\": \"/db/password\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"executor\": \"\",\n" +
                "  \"healthChecks\": [\n" +
                "    {\n" +
                "      \"gracePeriodSeconds\": 300,\n" +
                "      \"ignoreHttp1xx\": false,\n" +
                "      \"intervalSeconds\": 20,\n" +
                "      \"maxConsecutiveFailures\": 3,\n" +
                "      \"path\": \"/\",\n" +
                "      \"portIndex\": 0,\n" +
                "      \"protocol\": \"HTTP\",\n" +
                "      \"timeoutSeconds\": 20\n" +
                "    }\n" +
                "  ],\n" +
                "  \"readinessChecks\": [\n" +
                "    {\n" +
                "      \"name\": \"myReadyCheck\",\n" +
                "      \"protocol\": \"HTTP\",\n" +
                "      \"path\": \"/v1/plan\",\n" +
                "      \"portName\": \"http\",\n" +
                "      \"intervalSeconds\": 10,\n" +
                "      \"timeoutSeconds\": 3,\n" +
                "      \"httpStatusCodesForReady\": [\n" +
                "        200\n" +
                "      ],\n" +
                "      \"preserveLastResponse\": true\n" +
                "    }\n" +
                "  ],\n" +
                "  \"labels\": {\n" +
                "    \"owner\": \"zeus\",\n" +
                "    \"note\": \"Away from olympus\"\n" +
                "  },\n" +
                "  \"maxLaunchDelaySeconds\": 3600,\n" +
//                "  \"ipAddress\": {\n" +
//                "    \"discovery\": {\n" +
//                "      \"ports\": [\n" +
//                "        {\n" +
//                "          \"number\": 8080,\n" +
//                "          \"name\": \"rest-endpoint\",\n" +
//                "          \"protocol\": \"tcp\"\n" +
//                "        }\n" +
//                "      ]\n" +
//                "    },\n" +
//                "    \"groups\": [\n" +
//                "      \"dev\"\n" +
//                "    ],\n" +
//                "    \"labels\": {\n" +
//                "      \"environment\": \"dev\"\n" +
//                "    }\n" +
//                "  },\n" +
                "  \"portDefinitions\": [\n" +
                "    {\n" +
                "      \"port\": 0,\n" +
                "      \"protocol\": \"tcp\",\n" +
                "      \"name\": \"http\",\n" +
                "      \"labels\": {\n" +
                "        \"vip\": \"192.168.0.1:80\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"requirePorts\": false,\n" +
                "  \"upgradeStrategy\": {\n" +
                "    \"maximumOverCapacity\": 1,\n" +
                "    \"minimumHealthCapacity\": 1\n" +
                "  },\n" +
                "  \"fetch\": [\n" +
                "    {\n" +
                "      \"uri\": \"https://foo.com/setup.py\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"uri\": \"https://foo.com/archive.zip\",\n" +
                "      \"executable\": false,\n" +
                "      \"extract\": true,\n" +
                "      \"cache\": true,\n" +
                "      \"outputFile\": \"newname.zip\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"user\": \"root\",\n" +
                "  \"secrets\": {\n" +
                "    \"secret1\": {\n" +
                "      \"source\": \"/db/password\"\n" +
                "    },\n" +
                "    \"secret3\": {\n" +
                "      \"source\": \"/foo2\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"taskKillGracePeriodSeconds\": 30\n" +
                "}";

        final App                  app             = ModelUtils.GSON.fromJson(exampleString, App.class);
        final Map<String, String>  envSecret       = (Map<String, String>) app.getEnv().get("PASSWORD");
        final List<PortDefinition> portDefinitions = app.getPortDefinitions();
        final List<Fetchable>      fetch           = app.getFetch();
        final SecretSource         secret3         = app.getSecrets().get("secret3");

        // env tests
        assertEquals("/db/password", envSecret.get("secret"));

        // portDefinitions
        assertEquals(1, portDefinitions.size());
        final PortDefinition port0 = portDefinitions.get(0);
        assertEquals("Random port should be 0", Integer.valueOf(0), port0.getPort());
        assertEquals("Protocol should be 'tcp'", "tcp", port0.getProtocol());
        assertEquals("Name should be 'http'", "http", port0.getName());
        final Map<String, String> portLabels = port0.getLabels();
        assertEquals("'vip' should be ipaddress:port", "192.168.0.1:80", portLabels.get("vip"));

        // fetch
        assertEquals(2, fetch.size());
        final Fetchable fetch2 = fetch.get(1);
        assertEquals("https://foo.com/archive.zip", fetch2.getUri());
        assertFalse(fetch2.getExecutable());
        assertTrue(fetch2.getExtract());
        assertTrue(fetch2.getCache());
        assertEquals("newname.zip", fetch2.getOutputFile());

        // secrets
        assertEquals(2, app.getSecrets().size());
        assertEquals("/foo2", secret3.getSource());
    }


}
