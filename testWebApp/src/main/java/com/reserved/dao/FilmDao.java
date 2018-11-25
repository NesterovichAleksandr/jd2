package com.reserved.dao;

import com.reserved.beans.Film;
import com.reserved.utils.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilmDao extends AbstractDao implements InterfaceDao<Film> {

    @Override
    public boolean create(Film film) throws SQLException {
        String sql = String.format(
                "INSERT INTO `films`(`name`, `country`, `genre`, `yearOfIssue`, `duration`)" +
                        " VALUES ('%s','%s','%s',%d,%d);",
                film.getName(),
                film.getCountry(),
                film.getGenre(),
                film.getYearOfIssue(),
                film.getDuration()
        );
        film.setId(executeUpdate(sql));
        return (film.getId() > 0);
    }

    @Override
    public Film read(int id) throws SQLException {
        List<Film> films = getAll("WHERE ID=" + id + " LIMIT 0,1");
        return (films.size() > 0) ? films.get(0) : null;
    }

    @Override
    public boolean update(Film film) throws SQLException {
        String sql = String.format(
                "UPDATE `films` SET " +
                        "`name`='%s'," +
                        "`country`='%s'," +
                        "`genre`='%s'," +
                        "`yearOfIssue`=%d," +
                        "`duration`=%d" +
                        " WHERE `id`=%d",
                film.getName(),
                film.getCountry(),
                film.getGenre(),
                film.getYearOfIssue(),
                film.getDuration(),
                film.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Film film) throws SQLException {
        String sql = String.format(
                "DELETE FROM `films` WHERE `id`=%d",
                film.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Film> getAll(String where) throws SQLException {
        List<Film> films = new ArrayList<>();
        String sql = "SELECT * FROM films " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Film film = new Film(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getString("genre"),
                        resultSet.getInt("yearOfIssue"),
                        resultSet.getInt("duration")
                );
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //тут нужно логгирование SQLException(e);
        }
        return films;
    }
}
