package models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Project {
    @SerializedName(value = "name")
    private String nameA;

    private String announcement;

    @SerializedName(value = "suite_mode")
    private int type;

    @SerializedName(value = "show_announcement")
    private boolean showAnnouncement;

    private boolean deleted;

    public String getName() {
        return nameA;
    }

    public void setName(String name) {
        this.nameA = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isShowAnnouncement() {
        return showAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + nameA + '\'' +
                ", announcement='" + announcement + '\'' +
                ", type=" + type +
                ", showAnnouncement=" + showAnnouncement +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return getType() == project.getType() && isShowAnnouncement() == project.isShowAnnouncement() && Objects.equals(getName(), project.getName()) && Objects.equals(getAnnouncement(), project.getAnnouncement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAnnouncement(), getType(), isShowAnnouncement());
    }
}
