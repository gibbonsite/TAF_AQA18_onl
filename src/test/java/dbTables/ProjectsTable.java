package dbTables;

import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class ProjectsTable {
    Logger logger = LogManager.getLogger(ProjectsTable.class);

    private DataBaseService dbService;

    public ProjectsTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Создаем projects таблицу");

        String createTableSQL = "" +
                "create table public.projects " +
                "(id SERIAL PRIMARY KEY," +
                "    name CHARACTER VARYING(30)," +
                "    announcement CHARACTER VARYING(30)," +
                "    show_announcement BOOLEAN," +
                "    suite_mode INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем projects таблицу");

        String dropTableSQL = "drop table if exists public.projects;";

        dbService.executeSQL(dropTableSQL);
    }

    public void addProject(Project project) {
        String insertTableSQL = "INSERT INTO public.projects(" +
                "id, name, announcement, show_announcement, suite_mode)" +
                "VALUES (" + project.getId() + ", '" + project.getName() + "', '" + project.getAnnouncement() +
                "', '" + project.isShowAnnouncement() + "', " + project.getProjectType() + ");";

        dbService.executeSQL(insertTableSQL);
    }

    public void deleteProject(int projectId) {
        String deleteTableSQL = "DELETE FROM public.projects WHERE id = " + projectId + ";";
        dbService.executeSQL(deleteTableSQL);
    }
}
