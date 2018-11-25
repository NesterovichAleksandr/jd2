package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.User;
import com.reserved.utils.Form;
import com.reserved.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdUserCabinet extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req, resp);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req) && req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            return Action.INDEX.cmd;
        }
        return null;
    }
}
