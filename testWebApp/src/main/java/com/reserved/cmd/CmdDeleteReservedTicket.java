package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.ReservedTicket;
import com.reserved.beans.User;
import com.reserved.dao.Dao;
import com.reserved.utils.Form;
import com.reserved.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdDeleteReservedTicket extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req,resp);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req)) {
            if (req.getParameter("deleteButton") != null) {
                long id = Form.getLong(req, "idReservedTicket");
                ReservedTicket reservedTicket = new ReservedTicket(
                        id,
                        11111111,
                        1.0,
                        1,
                        1,
                        1
                );
                Dao.getDao().reservedTicket.delete(reservedTicket);
                return Action.LISTRESERVEDTICKET.cmd;
            }
        }
        return null;
    }
}
