package mesosphere.marathon.client.model.v2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest {
    private App app;

    @Before
    public void setUp() {
        this.app = new App();
    }

    /**
     * Test that roles can be added individually and duplicate roles
     * do not cause an issue.
     *
     * @throws Exception
     */
    @Test
    public void testAddAcceptedResourceRole() throws Exception {
        final String firstRole  = "arole";
        final String secondRole = "another";

        app.addAcceptedResourceRole(firstRole);
        assertTrue("Added role exists",
                app.getAcceptedResourceRoles().contains(firstRole));
        app.addAcceptedResourceRole(secondRole);
        assertTrue("Second added role exists",
                app.getAcceptedResourceRoles().contains(secondRole));
        app.addAcceptedResourceRole(firstRole);
        assertTrue("Duplicate role exists",
                app.getAcceptedResourceRoles().contains(firstRole));
    }

    @Test
    public void testAddDependency() throws Exception {
        final String firstDep  = "adep";
        final String secondDep = "another";

        app.addDependency(firstDep);
        assertTrue("Added dependency exists",
                app.getDependencies().contains(firstDep));
        app.addDependency(secondDep);
        assertTrue("Second dependency exists",
                app.getDependencies().contains(secondDep));
        app.addDependency(firstDep);
        assertTrue("Duplicate dependency exists and no errors",
                app.getDependencies().contains(firstDep));
    }

    @Test
    public void testBackoffFactor() throws Exception {
        app.setBackoffFactor(0.1);
        assertEquals(app.getBackoffFactor(), Double.valueOf(0.1));
        app.setBackoffFactor(1d);
        assertEquals(app.getBackoffFactor(), Double.valueOf(1.0));
    }
}