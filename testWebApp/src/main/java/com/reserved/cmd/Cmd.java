package com.reserved.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Cmd {

    public abstract Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception;

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        String cmd = name.replace("Cmd", "");
        return cmd;
    }
}
