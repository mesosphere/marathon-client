package mesosphere.marathon.client.model.v2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import mesosphere.marathon.client.Marathon;
import mesosphere.marathon.client.MarathonClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExternalVolumeTest {

    @Test
    public void testExternalVolumes() throws Exception {
        final MockWebServer server = new MockWebServer();
        final String mockResponse = "{\"container\": {\"volumes\": [" +
                "{\"containerPath\":\"/data/db\",\"mode\":\"RW\",\"external\":" +
                "{\"name\":\"mongodb-testvol\",\"provider\":\"dvdi\",\"options\":" +
                "{\"dvdi/driver\":\"rexray\"}}}]}}";

        try {
            server.enqueue(new MockResponse().setBody(mockResponse));
            server.start();
            Marathon client = MarathonClient.getInstance(server.url("/").toString());

            App app = new App();
            app.setId("mongo");
            app.setCpus(1.0);
            app.setMem(256.0);
            app.setContainer(new Container());
            app.getContainer().setDocker(new Docker());
            app.getContainer().getDocker().setImage("mongo");
            app.getContainer().setVolumes(new ArrayList<Volume>());

            ExternalVolume externalVolume = new ExternalVolume();
            externalVolume.setName("mongodb-testvol");
            externalVolume.setMode("RW");
            externalVolume.setContainerPath("/data/db");
            externalVolume.setProvider("dvdi");
            externalVolume.setDriver("rexray");

            app.getContainer().getVolumes().add(externalVolume);

            final App appRes = client.createApp(app);
            assertFalse(appRes.getContainer().getVolumes().isEmpty());

            ExternalVolume responseVolume = (ExternalVolume) appRes.getContainer().getVolumes().iterator().next();
            assertEquals("mongodb-testvol", responseVolume.getExternalVolumeInfo().getName());

            RecordedRequest request = server.takeRequest();
            assertNotNull(request);

            final String requestBody = request.getBody().readUtf8();
            assertNotNull(requestBody);

            // request to JSON
            JsonObject requestPayload = new Gson().fromJson(requestBody, JsonObject.class);
            assertNotNull(requestPayload);
            JsonObject requestVolume = requestPayload.getAsJsonObject("container").getAsJsonArray("volumes").get(0).getAsJsonObject();
            assertNotNull(requestVolume);
            assertEquals("RW", requestVolume.get("mode").getAsString());
            assertEquals("/data/db", requestVolume.get("containerPath").getAsString());
        } finally {
            server.shutdown();
        }
    }

}