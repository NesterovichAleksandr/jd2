package com.reserved.dao;

import com.reserved.beans.Role;
import com.reserved.utils.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends AbstractDao implements InterfaceDao<Role> {
    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles`(`role`)" +
                        " VALUES ('%s'); ",
                role.getRole()
        );
        role.setId(executeUpdate(sql));
        return (role.getId() > 0);
    }

    @Override
    public Role read(int id) throws SQLException {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        return (roles.size() > 0) ? roles.get(0) : null;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET " +
                        "`role`='%s' WHERE `id`=%d",
                role.getRole(),
                role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `id`=%d",
                role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("role")
                );
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //тут нужно логгирование SQLException(e);
        }
        return roles;
    }
}
