package dbTables;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import models.Milestone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MilestonesTable {
    Logger logger = LogManager.getLogger(MilestonesTable.class);

    private DataBaseService dbService;

    public MilestonesTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Создаем milestones таблицу");

        String createTableSQL = "" +
                "create table public.milestones " +
                "(id SERIAL PRIMARY KEY," +
                "    name CHARACTER VARYING(30)," +
                "    project_id INTEGER," +
                "    description CHARACTER VARYING(30)," +
                "    due_on INTEGER," +
                "    start_on INTEGER," +
                "    is_completed BOOLEAN," +
                "    CONSTRAINT fk_project" +
                "    FOREIGN KEY(project_id)" +
                "    REFERENCES projects(id)" +
                "    ON DELETE CASCADE" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем milestones таблицу");

        String dropTableSQL = "drop table if exists public.milestones;";

        dbService.executeSQL(dropTableSQL);
    }

    public Milestone getMilestoneById(int id) {
        String sql = "SELECT * FROM public.milestones WHERE id = " + id + ";";

        ResultSet rs = dbService.executeQuery(sql);

        try {
            if (rs.next()) {
                int milestoneId = rs.getInt("id");
                int projectId = rs.getInt("project_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int dueDate = rs.getInt("due_on");
                int startDate = rs.getInt("start_on");
                boolean isCompleted = rs.getBoolean("is_completed");
                Milestone milestone = Milestone.builder()
                        .id(milestoneId)
                        .projectId(projectId)
                        .name(name)
                        .description(description)
                        .dueDate(dueDate)
                        .startDate(startDate)
                        .completed(isCompleted)
                        .build();
                logger.info(milestone);
                return milestone;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMilestone(Milestone milestone) {
        String insertTableSQL = "INSERT INTO public.milestones(" +
                "id, name, project_id, description, due_on, start_on, is_completed)" +
                "VALUES (" + milestone.getId() + ", '" + milestone.getName() + "', " + milestone.getProjectId() +
                ", '" + milestone.getDescription() +
                "', " + milestone.getDueDate() + ", " + milestone.getStartDate() +
                ", " + milestone.isCompleted() + ");";

        dbService.executeSQL(insertTableSQL);
    }

    public void updateMilestone(Milestone milestone) {
        String updateTableSQL = "UPDATE public.milestones SET " +
                "name = '" + milestone.getName() + "', " +
                "project_id = " + milestone.getProjectId() + ", " +
                "description = '" + milestone.getDescription() + "', " +
                "due_on = " + milestone.getDueDate() + ", " +
                "start_on = " + milestone.getStartDate() + ", " +
                "is_completed = " + milestone.isCompleted() + " " +
                "WHERE id = " + milestone.getId() + ";";

        dbService.executeSQL(updateTableSQL);

    }

    public void deleteMilestone(int milestoneId) {
        String deleteTableSQL = "DELETE FROM public.milestones WHERE id = " + milestoneId + ";";
        dbService.executeSQL(deleteTableSQL);
    }
}
