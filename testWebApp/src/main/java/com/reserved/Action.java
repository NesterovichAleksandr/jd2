package com.reserved;

import com.reserved.cmd.*;

public enum Action {

    INDEX {{
        cmd = new CmdIndex();
    }},
    LOGIN {{
        cmd = new CmdLogin();
    }},
    RESET {{
        cmd = new CmdReset();
    }},
    SIGNUP {{
        cmd = new CmdSignUp();
    }},
    LISTFILM {{
        cmd = new CmdListFilm();
    }},
    UPDATEFILM {{
        cmd = new CmdUpdateFilm();
    }},
    LISTCINEMA {{
        cmd = new CmdListCinema();
    }},
    USERCABINET {{
        cmd = new CmdUserCabinet();
    }},
    EDITUSERINFO {{
        cmd = new CmdEditUserInfo();
    }},
    LISTRESERVEDTICKET {{
        cmd = new CmdListReservedTicket();
    }},
    CREATERESERVEDTICKET {{
        cmd = new CmdCreateReservedTicket();
    }},
    DELETERESERVEDTICKET {{
        cmd = new CmdDeleteReservedTicket();
    }},
    CREATEFILM {{
        cmd = new CmdCreateFilm();
    }},
    CREATECINEMA {{
        cmd = new CmdCreateCinema();
    }},
    ERROR {{
        cmd = new CmdError();
    }};

    public String getJsp() {
        return "/" + this.cmd.toString().toLowerCase() + ".jsp";
    }

    public Cmd cmd = new CmdError();

}
