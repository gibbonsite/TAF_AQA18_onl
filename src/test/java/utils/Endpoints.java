package utils;

public class Endpoints {
    public static final String ADD_MILESTONE = "index.php?/api/v2/add_milestone/{project_id}";
    public static final String UPDATE_MILESTONE = "index.php?/api/v2/update_milestone/{milestone_id}";
    public static final String GET_MILESTONE = "index.php?/api/v2/get_milestone/{milestone_id}";
    public static final String DELETE_MILESTONE = "index.php?/api/v2/delete_milestone/{milestone_id}";

    public static final String GET_CASE = "index.php?/api/v2/get_case/{case_id}";
    public static final String ADD_CASE = "index.php?/api/v2/add_case/{section_id}";
    public static final String UPDATE_CASE = "index.php?/api/v2/update_case/{case_id}";
    public static final String MOVE_CASES_TO_SECTION = "index.php?/api/v2/move_cases_to_section/{section_id}";
    public static final String DELETE_CASE = "index.php?/api/v2/delete_case/{case_id}";
}
