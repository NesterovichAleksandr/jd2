package com.reserved.dao;

import com.reserved.beans.FilmCinema;
import com.reserved.utils.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilmCinemaDao extends AbstractDao implements InterfaceDao<FilmCinema> {

    @Override
    public boolean create(FilmCinema filmCinema) throws SQLException {
        String sql = String.format(
                "INSERT INTO `films_cinemas`(`films_id`, `cinemas_id`)" +
                        " VALUES (%d,%d);",
                filmCinema.getFilms_id(),
                filmCinema.getCinemas_id()
        );
        filmCinema.setId(executeUpdate(sql));
        return (filmCinema.getId() > 0);
    }

    @Override
    public FilmCinema read(int id) throws SQLException {
        List<FilmCinema> filmCinemas = getAll("WHERE ID=" + id + " LIMIT 0,1");
        return (filmCinemas.size() > 0) ? filmCinemas.get(0) : null;
    }

    @Override
    public boolean update(FilmCinema filmCinema) throws SQLException {
        String sql = String.format(
                "UPDATE `films_cinemas` SET " +
                        "`films_id`=%d," +
                        "`cinemas_id`=%d " +
                        "WHERE `id`=%d",
                filmCinema.getFilms_id(),
                filmCinema.getCinemas_id(),
                filmCinema.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(FilmCinema filmCinema) throws SQLException {
        String sql = String.format(
                "DELETE FROM `films_cinemas` WHERE `id`=%d",
                filmCinema.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<FilmCinema> getAll(String where) throws SQLException {
        List<FilmCinema> filmCinemas = new ArrayList<>();
        String sql = "SELECT * FROM films_cinemas " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                FilmCinema filmCinema = new FilmCinema(
                        resultSet.getLong("id"),
                        resultSet.getLong("films_id"),
                        resultSet.getLong("cinemas_id")
                );
                filmCinemas.add(filmCinema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //тут нужно логгирование SQLException(e);
        }
        return filmCinemas;
    }
}
