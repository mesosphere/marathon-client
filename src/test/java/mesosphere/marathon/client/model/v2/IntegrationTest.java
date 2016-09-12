package mesosphere.marathon.client.model.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.operations.Mod;
import mesosphere.marathon.client.utils.ModelUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import mesosphere.marathon.client.Marathon;
import mesosphere.marathon.client.MarathonClient;
import mesosphere.marathon.client.utils.MarathonException;

@Ignore
public class IntegrationTest {

    private Marathon client;

    @Before
    public void setUpClass() {
        client = MarathonClient.getInstance("http://52.211.93.91:8080");
    }

    @Test
    public void testExternalVolumes() throws MarathonException {
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
        assertEquals("mongodb-testvol",
                ((ExternalVolume) appRes.getContainer().getVolumes().iterator().next()).getExternalVolumeInfo().getName());
    }
}
