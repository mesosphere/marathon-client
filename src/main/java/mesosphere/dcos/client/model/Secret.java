package mesosphere.dcos.client.model;

import mesosphere.client.common.ModelUtils;

import java.util.List;

/**
 * Created by jt018805 on 11/11/16.
 */
public class Secret {

    private String author;
    private String created;
    private String description;
    private List<String> labels;
    private String value;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
