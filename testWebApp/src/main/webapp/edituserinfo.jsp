<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" action="do?command=EditUserInfo" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Edit info user</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value=${user.login} type="text" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value=${user.password} type="password" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="email" name="email" value=${user.email} type="text" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="firstName">First name</label>
                <div class="col-md-4">
                    <input id="firstName" name="firstName" value=${user.firstName} type="text" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="lastName">Last name</label>
                <div class="col-md-4">
                    <input id="lastName" name="lastName" value=${user.lastName} type="text" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phoneNumber">Phone number</label>
                <div class="col-md-4">
                    <input id="phoneNumber" name="phoneNumber" value=${user.phoneNumber} type="text" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="savesubmit"></label>
                <div class="col-md-4">
                    <button id="savesubmit" name="savesubmit" class="btn btn-success">Save</button>
                </div>
            </div>

        </fieldset>
    </form>

</body>
</html>
