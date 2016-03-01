package mesosphere.marathon.client.model.v2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    /**
     * Test that roles can be added individually and duplicate roles
     * do not cause an issue.
     *
     * @throws Exception
     */
    @Test
    public void testAddAcceptedResourceRole() throws Exception {
        final App app = new App();
        app.addAcceptedResourceRole("arole");
        assertTrue("Added role exists",
                app.getAcceptedResourceRoles().contains("arole"));
        app.addAcceptedResourceRole("another");
        assertTrue("Second added role exists",
                app.getAcceptedResourceRoles().contains("another"));
        app.addAcceptedResourceRole("arole");
        assertTrue("Duplicate role exists",
                app.getAcceptedResourceRoles().contains("arole"));
    }
}