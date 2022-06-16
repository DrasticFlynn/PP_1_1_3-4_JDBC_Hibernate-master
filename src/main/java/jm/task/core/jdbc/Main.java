package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        // реализуйте алгоритм здесь


        try  {
            UserServiceImpl us = new UserServiceImpl();
            Util.getConnection();
            us.createUsersTable();
            us.saveUser("John1", "Johnson1", (byte) 10);
            us.saveUser("Bob2", "Bobson2", (byte) 20);
            us.saveUser("Zak3", "Zakson3", (byte) 30);
            us.saveUser("Wayne4", "Wayneson4", (byte) 40);
            us.removeUserById(1);
            us.getAllUsers();
            us.cleanUsersTable();
            us.dropUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

