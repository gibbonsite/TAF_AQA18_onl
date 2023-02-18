package baseEntities;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import dbTables.MilestonesTable;
import dbTables.ProjectsTable;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import models.Project;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import services.DataBaseService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected DataBaseService dbService;
    protected ProjectsTable projectsTable;
    protected MilestonesTable milestonesTable;
    protected ProjectAdapter projectAdapter;
    protected MilestoneAdapter milestoneAdapter;
    protected Project expectedProject;

    @BeforeClass
    public void setupApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(new ObjectMapperConfig().gsonObjectMapperFactory(
                        (cls, charset) -> {
                            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                            return gson;
                        }
                ));

        dbService = new DataBaseService();
        projectsTable = new ProjectsTable(dbService);
        milestonesTable = new MilestonesTable(dbService);

        // Эмулируем создание таблиц в базе при работе с API TestRail
        projectsTable.createTable();
        milestonesTable.createTable();

        milestoneAdapter = new MilestoneAdapter(dbService);
        projectAdapter = new ProjectAdapter(dbService);
        expectedProject = projectAdapter.add(Project.builder()
                .name("PR_Test_project_01")
                .announcement("Test project")
                .showAnnouncement(true)
                .projectType(1)
                .build());
    }

    @AfterClass
    public void tearDown() {
        milestonesTable.dropTable();
        projectsTable.dropTable();
        dbService.closeConnection();
    }
}
