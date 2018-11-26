<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" action="do?command=Login" method="post">
        <fieldset>

            <p>${noUser}<br></p>

            <!-- Form Name -->
            <legend>Form Login</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="user" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="puser" type="password" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signinsubmit"></label>
                <div class="col-md-4">
                    <button id="signinsubmit" name="signinsubmit" class="btn btn-success">Sign in</button>
                </div>
            </div>

        </fieldset>
    </form>


</body>
</html>

