package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.Cinema;
import com.reserved.beans.FilmCinema;
import com.reserved.beans.User;
import com.reserved.dao.Dao;
import com.reserved.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdListCinema extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req,resp);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();

        List<Cinema> cinemas = dao.cinema.getAll("");
        if (cinemas.size() > 0) {
            req.setAttribute("cinemas", cinemas);
        }
        long idFilm = (long) session.getAttribute("IdFilm");
        String formatFilmCinema = String.format(" WHERE films_cinemas.films_id=%d", idFilm);
        List<FilmCinema> listCinemasForFilm = dao.filmCinema.getAll(formatFilmCinema);
        if (listCinemasForFilm.size() > 0) {
            req.setAttribute("listCinemaForFilm", listCinemasForFilm);
        }
        return null;
    }
}
