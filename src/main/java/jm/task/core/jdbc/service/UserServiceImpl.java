package jm.task.core.jdbc.service;

import jm.task.core.jdbc.Main;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {


    public UserServiceImpl() throws SQLException {

    }
    private UserDaoJDBCImpl ud = new UserDaoJDBCImpl();

    public void createUsersTable() throws SQLException {
        ud.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        ud.dropUsersTable();
    }


    public void saveUser(String name, String lastName, byte age) throws SQLException {
        // Теперь работает, как надо
        String usName = name;
        String usLastname = lastName;
        byte usAge = age;
        ud.saveUser(usName, usLastname, usAge);

    }


    public void removeUserById(long id) throws SQLException {
        // теперь работает как надо
        Long usId = id;
        ud.removeUserById(usId);

    }


    public List<User> getAllUsers() throws SQLException {
        return ud.getAllUsers();

    }

    public void cleanUsersTable() throws SQLException {
        ud.cleanUsersTable();
    }


}
