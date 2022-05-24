package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=studyuser";
    private static final String Username = "postgres";
    private static final String Password = "postgres";


    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, Username, Password);
            connection.setAutoCommit(false);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }

}
