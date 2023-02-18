package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
public class Milestone {
    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
    @SerializedName("project_id")
    private int projectId;

    @Expose
    private String description;

    @Expose
    @SerializedName("due_on")
    private int dueDate;

    @Expose
    @SerializedName("start_on")
    private int startDate;

    @Expose
    @SerializedName("is_completed")
    private boolean completed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milestone milestone = (Milestone) o;
        return projectId == milestone.projectId && dueDate == milestone.dueDate && startDate == milestone.startDate && completed == milestone.completed && Objects.equals(name, milestone.name) && Objects.equals(description, milestone.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectId, description, dueDate, startDate, completed);
    }
}
