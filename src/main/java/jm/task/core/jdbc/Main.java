package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
//        Connection connection = Util.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM studyuser.db113");
//        ResultSet rs = preparedStatement.executeQuery();
//        while (rs.next()){
//            System.out.print(rs.getInt("id"));
//            System.out.print(rs.getString("name"));
//            System.out.print(rs.getString("lastname"));
//            System.out.print(rs.getInt("age"));
//            System.out.println();
//        }
       UserServiceImpl us = new UserServiceImpl();
       UserDaoJDBCImpl us1 = new UserDaoJDBCImpl();
     us.getAllUsers();
  //     us.dropUsersTable(); // Работает корректно
    //  us1.createUsersTable(); // Работает корректно
   //us.saveUser("JJJJ","OOOOO", (byte) 10);
   //     us.cleanUsersTable(); // Работает корректно
        //  us.removeUserById(1); // Работает корректно
    }
}
