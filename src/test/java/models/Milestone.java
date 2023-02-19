package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Milestone {
    @EqualsAndHashCode.Exclude
    private int id;

    @Expose
    private String name;

    @Expose
    @SerializedName("project_id")
    private int projectId;

    @Expose
    @SerializedName("refs")
    private String references;

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
}
