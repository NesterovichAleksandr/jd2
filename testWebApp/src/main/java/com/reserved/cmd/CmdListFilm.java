package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.*;
import com.reserved.dao.Dao;
import com.reserved.utils.Form;
import com.reserved.utils.Patterns;
import com.reserved.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CmdListFilm extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        User user = Utils.getUser(req,resp);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();


        int filmCount = dao.film.getAll("").size();
        req.setAttribute("filmCount", filmCount);
        Integer start = 0;
        try {
            start = Form.getInt(req, "start");
        } catch (ParseException e) {
        }
        String limit = String.format(" LIMIT %s, 10", start);
        List<Film> films = dao.film.getAll(limit);
        if (films.size() > 0) {
            req.setAttribute("films", films);
        }
        List<Cinema> cinemas = dao.cinema.getAll("");
        if (cinemas.size() > 0) {
            req.setAttribute("cinemas", cinemas);
        }
        if (Form.isPost(req)) {
            if (req.getParameter("listCinemaButton") != null) {
                session.setAttribute("IdFilm", Form.getLong(req, "filmId"));
                return Action.LISTCINEMA.cmd;
            }
            if (req.getParameter("deleteFilmButton") != null) {
                dao.film.delete(
                        new Film(Form.getLong(req, "filmId"), "", "", "", 1234, 123)
                );
                List<Film> filmsU = dao.film.getAll(limit);
                req.setAttribute("films", filmsU);
            }
            if (req.getParameter("updateFilmButton") != null) {
                session.setAttribute("IdFilm", Form.getLong(req, "filmId"));
                session.setAttribute("filmIdName", Form.getString(req.getParameter("filmIdName"), Patterns.NAMEFILM));
                session.setAttribute("filmIdCountry", Form.getString(req.getParameter("filmIdCountry"), Patterns.NAMEFILM));
                session.setAttribute("filmIdGenre", Form.getString(req.getParameter("filmIdGenre"), Patterns.NAMEFILM));
                session.setAttribute("filmIdYearOfIssue", Form.getInt(req, "filmIdYearOfIssue"));
                session.setAttribute("filmIdDuration", Form.getInt(req, "filmIdDuration"));
                return Action.UPDATEFILM.cmd;
            }
        }
        return null;
    }
}
