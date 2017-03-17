package mesosphere.marathon.client.model.v2;

import com.google.gson.annotations.SerializedName;
import mesosphere.client.common.ModelUtils;

public class PersistentLocalVolume extends Volume {

    @SerializedName("persistent")
    PersistentLocalVolumeInfo persistentLocalVolumeInfo;

    public PersistentLocalVolume() {
        this.persistentLocalVolumeInfo = new PersistentLocalVolumeInfo();
    }

    public PersistentLocalVolumeInfo getPersistentLocalVolumeInfo() {
        return persistentLocalVolumeInfo;
    }

    public void setPersistentLocalVolumeInfo(PersistentLocalVolumeInfo persistentLocalVolumeInfo) {
        this.persistentLocalVolumeInfo = persistentLocalVolumeInfo;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }

    class PersistentLocalVolumeInfo {
        private Integer size;

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }

}
