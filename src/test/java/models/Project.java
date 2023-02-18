package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Project {
    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
    private String announcement;

    @Expose
    @SerializedName("show_announcement")
    private boolean showAnnouncement;

    @Expose
    @SerializedName("suite_mode")
    private int projectType;
}
