package mesosphere.marathon.client.model.v2;

import com.google.gson.annotations.SerializedName;
import mesosphere.client.common.ModelUtils;

public class ExternalVolume extends Volume {

    @SerializedName("external")
    private ExternalVolumeInfo externalVolumeInfo;

    public ExternalVolume() {
        this.externalVolumeInfo = new ExternalVolumeInfo();
    }

    ExternalVolumeInfo getExternalVolumeInfo() {
        return externalVolumeInfo;
    }

    void setExternalVolumeInfo(ExternalVolumeInfo externalVolumeInfo) {
        this.externalVolumeInfo = externalVolumeInfo;
    }

    /*
        Proxies
    */
    public void setName(String name) {
        this.externalVolumeInfo.name = name;
    }

    public void setProvider(String provider) {
        this.externalVolumeInfo.provider = provider;
    }

    public void setSize(Integer size) {
        this.externalVolumeInfo.size = size;
    }

    public void setDriver(String driver) {
        this.externalVolumeInfo.options.driver = driver;
    }

    public void setOptSize(Integer size) {
        this.externalVolumeInfo.options.size = size;
    }

    public void setOptIops(Integer iops) {
        this.externalVolumeInfo.options.iops = iops;
    }

    public void setOptVolumeType(String volumeType) {
        this.externalVolumeInfo.options.volumeType = volumeType;
    }

    public void setOptNewFsType(String newFsType) {
        this.externalVolumeInfo.options.newFsType = newFsType;
    }

    public void setOptOverwriteFs(Boolean overwriteFs) {
        this.externalVolumeInfo.options.overwriteFs = overwriteFs;
    }

    public String getName() {
        return this.externalVolumeInfo.name;
    }

    public String getProvider() {
        return this.externalVolumeInfo.provider;
    }

    public Integer getSize() {
        return this.externalVolumeInfo.size;
    }

    public String getDriver() {
        return this.externalVolumeInfo.options.driver;
    }

    public Integer getOptSize() {
        return this.externalVolumeInfo.options.size;
    }

    public Integer getOptIops() {
        return this.externalVolumeInfo.options.iops;
    }

    public String getOptVolumeType() {
        return this.externalVolumeInfo.options.volumeType;
    }

    public String getOptNewFsType() {
        return this.externalVolumeInfo.options.newFsType;
    }

    public Boolean getOptOverwriteFs() {
        return this.externalVolumeInfo.options.overwriteFs;
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

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        Integer getSize() {
            return size;
        }

        void setSize(Integer size) {
            this.size = size;
        }

        String getProvider() {
            return provider;
        }

        void setProvider(String provider) {
            this.provider = provider;
        }

        Options getOptions() {
            return options;
        }

        void setOptions(Options options) {
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

            String getDriver() {
                return driver;
            }

            void setDriver(String driver) {
                this.driver = driver;
            }

            Integer getSize() {
                return size;
            }

            void setSize(Integer size) {
                this.size = size;
            }

            Integer getIops() {
                return iops;
            }

            void setIops(Integer iops) {
                this.iops = iops;
            }

            String getVolumeType() {
                return volumeType;
            }

            void setVolumeType(String volumeType) {
                this.volumeType = volumeType;
            }

            String getNewFsType() {
                return newFsType;
            }

            void setNewFsType(String newFsType) {
                this.newFsType = newFsType;
            }

            Boolean getOverwriteFs() {
                return overwriteFs;
            }

            void setOverwriteFs(Boolean overwriteFs) {
                this.overwriteFs = overwriteFs;
            }
            @Override
            public String toString() {
                return ModelUtils.toString(this);
            }
        }
    }
}
