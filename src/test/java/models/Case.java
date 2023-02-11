package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Case {
    @Expose
    @EqualsAndHashCode.Exclude
    private int id;

    @Expose
    private String title;

    @Expose
    @SerializedName("template_id")
    private int templateId;

    @Expose
    @SerializedName("type_id")
    private int typeId;

    @Expose
    @SerializedName("priority_id")
    private int priorityId;

    @Expose
    private String estimate;

    @Expose
    @SerializedName("section_id")
    private int sectionId;
}
