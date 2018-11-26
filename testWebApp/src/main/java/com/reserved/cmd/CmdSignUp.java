package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.User;
import com.reserved.dao.Dao;
import com.reserved.utils.Form;
import com.reserved.utils.Patterns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignUp extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        if (Form.isPost(req)) {
            String login = Form.getString(req.getParameter("login"), Patterns.LOGIN);
            String email = Form.getString(req.getParameter("email"), Patterns.EMAIL);
            String password = Form.getString(req.getParameter("password"), Patterns.PASSWORD);
            String firstName = Form.getString(req.getParameter("firstName"), Patterns.FIRSTNAME);
            String lastName = Form.getString(req.getParameter("lastName"), Patterns.LASTNAME);
            int phoneNumber = Integer.parseInt(Form.getString(req.getParameter("phoneNumber"), Patterns.PHONENUMBER));
            User user = new User(0, login, password, email, firstName, lastName, phoneNumber, 2);
            Dao dao = Dao.getDao();
            dao.user.create(user);
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
