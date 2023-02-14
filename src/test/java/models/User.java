package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Expose
    private String name;

    @EqualsAndHashCode.Exclude
    private int id;

    @Expose
    private String email;

    private String password;

    @Expose
    @SerializedName(value = "is_active")
    @JsonProperty("is_active")
    private boolean isActive;

    @Expose
    @SerializedName(value = "is_admin")
    @JsonProperty("is_admin")
    private boolean isAdmin;

    @Expose
    @SerializedName(value = "role_id")
    @JsonProperty("role_id")
    private int roleId;

    @Expose
    private String role;

    @EqualsAndHashCode.Exclude
    private String email_notifications;
}
