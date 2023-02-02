package models;

import lombok.*;

@Builder
@ToString
@EqualsAndHashCode
public class MilestoneBuilder {
    @EqualsAndHashCode.Exclude
    private int id;

    @NonNull
    private String name;
    private String references;
    private String description;
    @ToString.Exclude
    private boolean completed;
}
