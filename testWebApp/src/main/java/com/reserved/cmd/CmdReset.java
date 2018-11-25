package com.reserved.cmd;

import com.reserved.Action;
import com.reserved.utils.DataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdReset extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        DataBase.resetAndCreateDBWithTables();
        DataBase.InitTables();
        return Action.INDEX.cmd;
    }
}
