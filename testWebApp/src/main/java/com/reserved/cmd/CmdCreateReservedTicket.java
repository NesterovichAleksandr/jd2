package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.ReservedTicket;
import com.reserved.beans.User;
import com.reserved.dao.Dao;
import com.reserved.utils.Form;
import com.reserved.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdCreateReservedTicket extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req,resp);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();

        if (Form.isPost(req)) {
            if (req.getParameter("reservButton") != null) {
                long idFilm = (long) session.getAttribute("IdFilm");
                long idUser = user.getId();
                long idCinema =Form.getLong(req, "cinemaId");
                ReservedTicket reservedTicket = new ReservedTicket(
                        0,
                        11111111,
                        7.0,
                        idUser,
                        idFilm,
                        idCinema
                );
                dao.reservedTicket.create(reservedTicket);
                return Action.LISTRESERVEDTICKET.cmd;
            }
        }
        return null;
    }
}
