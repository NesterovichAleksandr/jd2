package com.reserved.dao;

import com.reserved.beans.Cinema;
import com.reserved.utils.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CinemaDao extends AbstractDao implements InterfaceDao<Cinema> {

    @Override
    public boolean create(Cinema cinema) throws SQLException {
        String sql = String.format(
                "INSERT INTO `cinemas`(`name`, `address`)" +
                        " VALUES ('%s','%s');",
                cinema.getName(),
                cinema.getAddress()
        );
        cinema.setId(executeUpdate(sql));
        return (cinema.getId() > 0);
    }

    @Override
    public Cinema read(int id) throws SQLException {
        List<Cinema> cinemas = getAll("WHERE ID=" + id + " LIMIT 0,1");
        return (cinemas.size() > 0) ? cinemas.get(0) : null;
    }

    @Override
    public boolean update(Cinema cinema) throws SQLException {
        String sql = String.format(
                "UPDATE `cinemas` SET " +
                        "`name`='%s'," +
                        "`address`='%s'" +
                        " WHERE `id`=%d",
                cinema.getName(),
                cinema.getAddress(),
                cinema.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Cinema cinema) throws SQLException {
        String sql = String.format(
                "DELETE FROM `cinemas` WHERE `id`=%d",
                cinema.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Cinema> getAll(String where) throws SQLException {
        List<Cinema> cinemas = new ArrayList<>();
        String sql = "SELECT * FROM cinemas " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Cinema cinema = new Cinema(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address")
                );
                cinemas.add(cinema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //тут нужно логгирование SQLException(e);
        }
        return cinemas;
    }
}
