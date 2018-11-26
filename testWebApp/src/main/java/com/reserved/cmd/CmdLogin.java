package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.User;
import com.reserved.dao.Dao;
import com.reserved.utils.Form;
import com.reserved.utils.Patterns;
import com.reserved.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req, resp);
        if (user != null) {
            return Action.USERCABINET.cmd;
        }
        if (Form.isPost(req)) {
            String login = Form.getString(req.getParameter("login"), Patterns.LOGIN);
            String password = Form.getString(req.getParameter("password"), Patterns.PASSWORD);
            Dao dao = Dao.getDao();
            String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'", login, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(30);
                session.setAttribute("user", users.get(0));
                session.setAttribute("userId", users.get(0).getId());
                session.setAttribute("userLogin", login);

                Utils.setCookieUser(resp, login, password);

                return Action.USERCABINET.cmd;
            } else {
                req.setAttribute("noUser", "no user: " + login + " or incorrect password");
            }
        }
        return null;
    }
}
