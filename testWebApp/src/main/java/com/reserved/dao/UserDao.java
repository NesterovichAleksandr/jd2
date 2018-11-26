package com.reserved.dao;

import com.reserved.beans.User;
import com.reserved.utils.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements InterfaceDao<User> {

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users`(`login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`)" +
                        " VALUES ('%s','%s','%s','%s','%s',%d,%d);",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getRoles_id()
        );
        user.setId(executeUpdate(sql));
        return (user.getId() > 0);
    }

    @Override
    public User read(int id) throws SQLException {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        return (users.size() > 0) ? users.get(0) : null;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`login`='%s'," +
                        "`password`='%s'," +
                        "`email`='%s'," +
                        "`firstName`='%s'," +
                        "`lastName`='%s'," +
                        "`phoneNumber`=%d," +
                        "`roles_id`=%d WHERE `id`=%d",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getRoles_id(),
                user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `id`=%d",
                user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("phoneNumber"),
                        resultSet.getLong("roles_id")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //тут нужно логгирование SQLException(e);
        }
        return users;
    }
}
