package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.Film;
import com.reserved.dao.Dao;
import com.reserved.utils.Form;
import com.reserved.utils.Patterns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdCreateFilm extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isPost(req)) {
            String name = Form.getString(req.getParameter("name"), Patterns.NAMEFILM);
            String country = Form.getString(req.getParameter("country"), Patterns.COUNTRY);
            String genre = Form.getString(req.getParameter("genre"), Patterns.GENRE);
            int yearOfIssue = Integer.parseInt(Form.getString(req.getParameter("yearOfIssue"), Patterns.YEAROFISSUE));
            int duration = Integer.parseInt(Form.getString(req.getParameter("duration"), Patterns.DURATION));
            Film film = new Film(0, name, country, genre, yearOfIssue, duration);
            Dao dao = Dao.getDao();
            dao.film.create(film);
            return Action.LISTFILM.cmd;
        }
        return null;
    }
}
