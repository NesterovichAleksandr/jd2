package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.Film;
import com.reserved.beans.User;
import com.reserved.dao.Dao;
import com.reserved.utils.Form;
import com.reserved.utils.Patterns;
import com.reserved.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdUpdateFilm extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req,resp);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req)) {
            Long filmId = Long.valueOf(req.getParameter("filmId"));
            String name = Form.getString(req.getParameter("filmName"), Patterns.NAMEFILM);
            String country = Form.getString(req.getParameter("filmCountry"), Patterns.COUNTRY);
            String genre = Form.getString(req.getParameter("filmGenre"), Patterns.GENRE);
            int yearOfIssue = Integer.parseInt(Form.getString(req.getParameter("filmYearOfIssue"), Patterns.YEAROFISSUE));
            int duration = Integer.parseInt(Form.getString(req.getParameter("filmDuration"), Patterns.DURATION));
            Film film = new Film(filmId, name, country, genre, yearOfIssue, duration);
            Dao.getDao().film.update(film);
            return Action.LISTFILM.cmd;
        }
        return null;
    }
}
