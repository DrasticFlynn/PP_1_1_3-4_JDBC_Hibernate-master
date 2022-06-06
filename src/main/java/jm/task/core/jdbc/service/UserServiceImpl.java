package jm.task.core.jdbc.service;

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
        ud.saveUser("Ivan", "Ivanov", (byte) 5);
    }


    public void removeUserById(long idd) throws SQLException {
        ud.removeUserById(4);

    }


    public List<User> getAllUsers() throws SQLException {
        return ud.getAllUsers();

    }

    public void cleanUsersTable() throws SQLException {
        ud.cleanUsersTable();
    }
}
