package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {


    public void createUsersTable() {
        String sql = "CREATE table if not exists studyuser.User (\n" +
                "    id BIGSERIAL primary key not null ,\n" +
                "    name VARCHAR (20) not null,\n" +
                "    lastname VARCHAR (30) not null,\n" +
                "    age SMALLSERIAL \n" +
                ");";
        try (Connection connection = Util.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS studyuser.User";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO studyuser.User (name,lastName,age) VALUES (?,?,?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void removeUserById(long idd) {
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM studyuser.User WHERE id = ?")) {

            preparedStatement.setInt(1, (int) idd);
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public List<User> getAllUsers() {
        List<User> userslist = new ArrayList<>();
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM studyuser.User ORDER BY id")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                byte age = rs.getByte("age");

                userslist.add(new User(id, name, lastname, age));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(userslist);
        return userslist;

    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE studyuser.User";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
