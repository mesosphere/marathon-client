package mesosphere.marathon.client.model.v2;

import com.google.gson.annotations.SerializedName;
import mesosphere.marathon.client.utils.ModelUtils;

public class ExternalVolume extends Volume {

    @SerializedName("external")
    private ExternalVolumeInfo externalVolumeInfo;

    public ExternalVolume() {
        this.externalVolumeInfo = new ExternalVolumeInfo();
    }

    public ExternalVolumeInfo getExternalVolumeInfo() {
        return externalVolumeInfo;
    }

    public void setExternalVolumeInfo(ExternalVolumeInfo externalVolumeInfo) {
        this.externalVolumeInfo = externalVolumeInfo;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }

    class ExternalVolumeInfo {
        private String name;
        private Integer size;
        private String provider = "dvdi";
        private Options options;

        ExternalVolumeInfo() {
            this.options = new Options();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public Options getOptions() {
            return options;
        }

        public void setOptions(Options options) {
            this.options = options;
        }
        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }

        class Options {
            @SerializedName("dvdi/driver")
            private String driver;
            private Integer size;
            @SerializedName("IOPS")
            private Integer iops;
            private String volumeType;
            private String newFsType;
            private Boolean overwriteFs;

            public String getDriver() {
                return driver;
            }

            public void setDriver(String driver) {
                this.driver = driver;
            }

            public Integer getSize() {
                return size;
            }

            public void setSize(Integer size) {
                this.size = size;
            }

            public Integer getIops() {
                return iops;
            }

            public void setIops(Integer iops) {
                this.iops = iops;
            }

            public String getVolumeType() {
                return volumeType;
            }

            public void setVolumeType(String volumeType) {
                this.volumeType = volumeType;
            }

            public String getNewFsType() {
                return newFsType;
            }

            public void setNewFsType(String newFsType) {
                this.newFsType = newFsType;
            }

            public Boolean getOverwriteFs() {
                return overwriteFs;
            }

            public void setOverwriteFs(Boolean overwriteFs) {
                this.overwriteFs = overwriteFs;
            }
            @Override
            public String toString() {
                return ModelUtils.toString(this);
            }
        }
    }
}
