package utils;

public class Endpoints {
    public static final String ADD_MILESTONE = "index.php?/api/v2/add_milestone/{project_id}";
    public static final String UPDATE_MILESTONE = "index.php?/api/v2/update_milestone/{milestone_id}";
    public static final String GET_MILESTONE = "index.php?/api/v2/get_milestone/{milestone_id}";
    public static final String DELETE_MILESTONE = "index.php?/api/v2/delete_milestone/{milestone_id}";

    public static final String ADD_PROJECT = "index.php?/api/v2/add_project";
    public static final String DELETE_PROJECT = "index.php?/api/v2/delete_project/{project_id}";
}
