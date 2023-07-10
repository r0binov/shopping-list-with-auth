package ee.sdacademy.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLScriptRunner {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String JDBC_USERNAME = "postgres";
    private static final String JDBC_PASSWORD = "thisispassword";

    public static void main(String[] args) {
        String sqlFilePath = "src/main/resources/DDL.sql";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath))) {

            StringBuilder sqlStatements = new StringBuilder();
            String line;

            // Read the content of ddl.sql
            while ((line = reader.readLine()) != null) {
                sqlStatements.append(line.trim());
                if (line.endsWith(";")) {
                    String sql = sqlStatements.toString();
                    executeStatement(connection, sql);
                    sqlStatements.setLength(0); // Reset the StringBuilder
                }
            }

            System.out.println("DDL script executed successfully.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static void executeStatement(Connection connection, String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }
}

