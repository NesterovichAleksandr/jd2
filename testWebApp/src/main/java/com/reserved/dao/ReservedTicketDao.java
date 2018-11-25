package com.reserved.dao;

import com.reserved.beans.ReservedTicket;
import com.reserved.utils.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReservedTicketDao extends AbstractDao implements InterfaceDao<ReservedTicket> {

    @Override
    public boolean create(ReservedTicket reservedTicket) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `reserved_tickets` (`code`, `cost`, `users_id`, `films_id`, `cinemas_id`)" +
                        " VALUES (%d,%5.2f,%d,%d,%d);",
                reservedTicket.getCode(),
                reservedTicket.getCost(),
                reservedTicket.getUsers_id(),
                reservedTicket.getFilms_id(),
                reservedTicket.getCinemas_id()
        );
        reservedTicket.setId(executeUpdate(sql));
        return (reservedTicket.getId() > 0);
    }

    @Override
    public ReservedTicket read(int id) throws SQLException {
        List<ReservedTicket> reservedTickets = getAll("WHERE ID=" + id + " LIMIT 0,1");
        return (reservedTickets.size() > 0) ? reservedTickets.get(0) : null;
    }

    @Override
    public boolean update(ReservedTicket reservedTicket) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `reserved_tickets` SET " +
                        "`code`=%d," +
                        "`cost`=%5.2f," +
                        "`users_id`=%d," +
                        "`films_id`=%d," +
                        "`cinemas_id`=%d" +
                        " WHERE `id`=%d",
                reservedTicket.getCode(),
                reservedTicket.getCost(),
                reservedTicket.getUsers_id(),
                reservedTicket.getFilms_id(),
                reservedTicket.getCinemas_id(),
                reservedTicket.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(ReservedTicket reservedTicket) throws SQLException {
        String sql = String.format(
                "DELETE FROM `reserved_tickets` WHERE `id`=%d",
                reservedTicket.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<ReservedTicket> getAll(String where) throws SQLException {
        List<ReservedTicket> reservedTickets = new ArrayList<>();
        String sql = "SELECT * FROM reserved_tickets " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ReservedTicket reservedTicket = new ReservedTicket(
                        resultSet.getLong("id"),
                        resultSet.getInt("code"),
                        resultSet.getDouble("cost"),  //устранить округление
                        resultSet.getLong("users_id"),
                        resultSet.getLong("films_id"),
                        resultSet.getLong("cinemas_id")
                );
                reservedTickets.add(reservedTicket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //тут нужно логгирование SQLException(e);
        }
        return reservedTickets;
    }
}
