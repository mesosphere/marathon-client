package mesosphere.marathon.client.model.v2;

public class QueueElement {
    private int count;
    private Delay delay;
    private VersionedApp app;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Delay getDelay() {
        return delay;
    }

    public void setDelay(Delay delay) {
        this.delay = delay;
    }

    public VersionedApp getApp() {
        return app;
    }

    public void setApp(VersionedApp app) {
        this.app = app;
    }
}
