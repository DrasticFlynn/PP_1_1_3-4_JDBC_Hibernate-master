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


    public UserServiceImpl()  {

    }
    private UserDaoJDBCImpl ud;

    {
        try {
            ud = new UserDaoJDBCImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUsersTable()  {
        ud.createUsersTable();
    }

    public void dropUsersTable()  {
        ud.dropUsersTable();
    }


    public void saveUser(String name, String lastName, byte age)  {
        // Теперь работает, как надо
        String usName = name;
        String usLastname = lastName;
        byte usAge = age;
        ud.saveUser(usName, usLastname, usAge);

    }


    public void removeUserById(long id)  {
        // теперь работает как надо
        Long usId = id;
        ud.removeUserById(usId);

    }


    public List<User> getAllUsers()  {
        return ud.getAllUsers();

    }

    public void cleanUsersTable()  {
        ud.cleanUsersTable();
    }


}
