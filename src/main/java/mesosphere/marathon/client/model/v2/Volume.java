package mesosphere.marathon.client.model.v2;

import com.google.gson.*;
import mesosphere.client.common.ModelUtils;

import java.lang.reflect.Type;

public abstract class Volume {
	private String containerPath;
	private String mode;

	public String getContainerPath() {
		return containerPath;
	}

	public void setContainerPath(String containerPath) {
		this.containerPath = containerPath;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}

	public static class VolumeAdapter implements JsonDeserializer<Volume>, JsonSerializer<Volume> {

		@Override
		public Volume deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
			if (jsonElement.getAsJsonObject().has("external"))
				return jsonDeserializationContext.deserialize(jsonElement, ExternalVolume.class);
			else if (jsonElement.getAsJsonObject().has("persistent"))
				return jsonDeserializationContext.deserialize(jsonElement, PersistentLocalVolume.class);
			else return jsonDeserializationContext.deserialize(jsonElement, LocalVolume.class);
		}

		@Override
		public JsonElement serialize(Volume volume, Type type, JsonSerializationContext jsonSerializationContext) {
			return jsonSerializationContext.serialize(volume);
		}
	}
}
