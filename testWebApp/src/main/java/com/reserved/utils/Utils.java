package com.reserved.utils;

import com.reserved.beans.User;
import com.reserved.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class Utils {

    public static User getUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (User) oUser;
            }
        } else {
            Cookie[] myCookies = req.getCookies();
            String login = null;
            String password = null;
            for (Cookie cookie : myCookies) {
                if ("login".equals(cookie.getName())) {
                    login = cookie.getValue();
                }
                if ("password".equals(cookie.getName())) {
                    String valueCookie = cookie.getValue();
                    password = valueCookie.substring(0, valueCookie.length() - 6);
                }
            }
            if (login != null && password != null) {
                Dao dao = Dao.getDao();
                String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'", login, password);
                List<User> users = dao.user.getAll(where);
                if (users.size() == 0) {
                    return null;
                }
                req.getSession().setMaxInactiveInterval(30);
                req.getSession().setAttribute("user", users.get(0));
                req.getSession().setAttribute("userId", users.get(0).getId());
                req.getSession().setAttribute("userLogin", login);

                setCookieUser(resp, login, password);

                return users.get(0);
            }
        }
        return null;
    }

    public static void setCookieUser(HttpServletResponse resp, String login, String password) {
        Cookie cookieLogin = new Cookie("login", login);
        Cookie cookiePassword = new Cookie("password", password + "sekret");
        cookieLogin.setMaxAge(60);
        cookiePassword.setMaxAge(60);
        resp.addCookie(cookieLogin);
        resp.addCookie(cookiePassword);
    }
}
