package dbTables;

import models.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class CustomersTable {
    Logger logger = LogManager.getLogger(CustomersTable.class);

    private DataBaseService dbService;

    public CustomersTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Создаем customers таблицу");

        String createTableSQL = "" +
                "create table public.customers " +
                "(id SERIAL PRIMARY KEY," +
                "    firstname CHARACTER VARYING(30)," +
                "    lastname CHARACTER VARYING(30)," +
                "    email CHARACTER VARYING(30)," +
                "    age INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем customers таблицу");

        String dropTableSQL = "drop table if exists public.customers;";

        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getCustomers() {
        String sql = "SELECT * FROM public.customers;";

        return dbService.executeQuery(sql);
    }

    public ResultSet getCustomerById(int id) {
        String sql = "SELECT * FROM public.customers WHERE id = " + id + ";";

        return dbService.executeQuery(sql);
    }

    public void addCustomer(CustomerBuilder customerBuilder) {
        String insertTableSQL = "INSERT INTO public.customers(" +
                "firstname, lastname, email, age)" +
                "VALUES ('" + customerBuilder.getFirstname() + "', '" + customerBuilder.getLastname() +
                "', '" + customerBuilder.getEmail() + "', " + customerBuilder.getAge() + ");";

        dbService.executeSQL(insertTableSQL);
    }

    public void updateCustomer(CustomerBuilder customerBuilder) {

    }

    public void deleteCustomer(int id) {

    }
}
