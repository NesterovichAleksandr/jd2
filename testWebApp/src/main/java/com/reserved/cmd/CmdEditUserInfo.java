package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.beans.User;
import com.reserved.dao.Dao;
import com.reserved.utils.Form;
import com.reserved.utils.Patterns;
import com.reserved.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdEditUserInfo extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isPost(req)) {
            User user = Utils.getUser(req, resp);
            String login = Form.getString(req.getParameter("login"), Patterns.LOGIN);
            String email = Form.getString(req.getParameter("email"), Patterns.EMAIL);
            String password = Form.getString(req.getParameter("password"), Patterns.PASSWORD);
            String firstName = Form.getString(req.getParameter("firstName"), Patterns.FIRSTNAME);
            String lastName = Form.getString(req.getParameter("lastName"), Patterns.LASTNAME);
            int phoneNumber = Integer.parseInt(Form.getString(req.getParameter("phoneNumber"), Patterns.PHONENUMBER));
            user.setLogin(login);
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phoneNumber);
            Dao dao = Dao.getDao();
            dao.user.update(user);
            return Action.USERCABINET.cmd;
        }
        return null;
    }
}
