package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.Cinema;
import com.reserved.beans.Film;
import com.reserved.beans.ReservedTicket;
import com.reserved.beans.User;
import com.reserved.dao.Dao;
import com.reserved.utils.Form;
import com.reserved.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdListReservedTicket extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req, resp);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        Dao dao = Dao.getDao();
        List<ReservedTicket> reservedTickets = dao.reservedTicket.getAll(" WHERE `users_id`=" + Utils.getUser(req, resp).getId());
        List<Film> films = dao.film.getAll("");
        List<Cinema> cinemas = dao.cinema.getAll("");
        if (reservedTickets.size() > 0) {
            req.setAttribute("reservedTickets", reservedTickets);
            req.setAttribute("films", films);
            req.setAttribute("cinemas", cinemas);
        }
        if (Form.isPost(req)) {
            if (req.getParameter("Delete") != null) {

                dao.reservedTicket.delete(
                        new ReservedTicket(
                                Form.getLong(req, "id"),
                                111111,
                                1.0,
                                2,
                                2,
                                2
                        )
                );
                // req.setAttribute("reservedTickets", com.reserved.dao.reservedTicket.getAll(" WHERE `users_id`=" + Utils.getUser(req).getId()));
            }
        }
        return null;
    }
}
