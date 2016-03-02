package mesosphere.marathon.client.model.v2;

public class UpgradeStrategy {
    private Double minimumHealthCapacity;
    private Double maximumOverCapacity;

    public Double getMinimumHealthCapacity() {
        return minimumHealthCapacity;
    }

    public void setMinimumHealthCapacity(Double minimumHealthCapacity) {
        this.minimumHealthCapacity = minimumHealthCapacity;
    }

    public Double getMaximumOverCapacity() {
        return maximumOverCapacity;
    }

    public void setMaximumOverCapacity(Double maximumOverCapacity) {
        this.maximumOverCapacity = maximumOverCapacity;
    }
}
