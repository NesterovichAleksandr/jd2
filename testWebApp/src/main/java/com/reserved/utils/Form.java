package com.reserved.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {

    public static String getString(String value, String regexPattern) throws ParseException {
        if (value.trim().matches(regexPattern)) {
            return value;
        } else {
            throw new ParseException("Input error: " + value, 1);
        }
    }

    public static Long getLong(HttpServletRequest request, String name) throws ParseException {
        String value = request.getParameter(name);
        if (value != null && value.matches("[-0-9]+")) {
            return Long.valueOf(value);
        }
        throw new ParseException("Input error: " + value, 1);
    }

    public static Integer getInt(HttpServletRequest request, String name) throws ParseException {
        String value = request.getParameter(name);
        if (value != null && value.matches("[-0-9]+")) {
            return Integer.valueOf(value);
        }
        throw new ParseException("Input error: " + value, 1);
    }

    public static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("post");
    }

    public static boolean isGet(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("get");
    }
}
