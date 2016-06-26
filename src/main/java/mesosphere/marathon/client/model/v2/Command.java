package mesosphere.marathon.client.model.v2;

public class Command {

	private String value;
	
	public Command() {}
	
	public Command(String value) {
        this.value = value;
    }
	
	public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
