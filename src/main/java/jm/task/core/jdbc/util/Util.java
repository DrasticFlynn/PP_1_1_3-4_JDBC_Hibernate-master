package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=studyuser";
    private static final String Username = "postgres";
    private static final String Password = "postgres";


    public static Connection getConnection() {
        Connection connection = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
            connection = DriverManager.getConnection(URL, Username, Password);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        try {
//            connection.setAutoCommit(false);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return connection;
    }

}
