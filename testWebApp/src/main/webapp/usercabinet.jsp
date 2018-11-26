<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" action="do?command=UserCabinet" method="post">
        <fieldset>
            <legend>User cabinet: ${userLogin}</legend>

            <div><a href="do?command=ListReservedTicket">Reserved ticket</a></div>
            <div><a href="do?command=ListFilm">List film</a></div>
            <div><a href="do?command=EditUserInfo">Edit info user</a></div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>

</body>
</html>
