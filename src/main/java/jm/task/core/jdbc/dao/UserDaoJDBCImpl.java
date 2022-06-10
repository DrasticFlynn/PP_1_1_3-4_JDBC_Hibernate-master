package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() throws SQLException {

    }


    private Connection connection = Util.getConnection();


    @Override
    public void createUsersTable() throws SQLException {

        String sql =
                " CREATE table if not exists studyuser.User (\n" +
                        "    id BIGSERIAL primary key not null,\n" +
                        "    name VARCHAR (20) not null,\n" +
                        "    lastname VARCHAR (30) not null,\n" +
                        "    age SMALLSERIAL \n" +
                        ");";


        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            connection.commit();


        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }


    public void dropUsersTable() throws SQLException {
        String sql =
                "DROP TABLE IF EXISTS studyuser.User;";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            connection.commit();


        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastname, byte age) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO studyuser.User ( name,lastname,age) VALUES (?,?,?);")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            connection.commit();


        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }

    }

    public void removeUserById(long id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM studyuser.User WHERE id = ?;")) {
            preparedStatement.setInt(1, (int) id);
            preparedStatement.executeUpdate();
            connection.commit();


        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userslist = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM studyuser.User ORDER BY id; ")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                byte age = rs.getByte("age");

                userslist.add(new User(id, name, lastname, age));

            }
            connection.commit();

        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }

        System.out.println(userslist);
        return userslist;
    }

    public void cleanUsersTable() throws SQLException {
        String sql = "TRUNCATE TABLE studyuser.User;";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            connection.commit();


        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }
}
