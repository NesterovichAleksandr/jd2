<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" action="do?command=SignUp" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Form SignUp</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="TestLogin" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="testpassword" type="password" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="email" name="email" value="TestEmail@mail.ru" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="firstName">First name</label>
                <div class="col-md-4">
                    <input id="firstName" name="firstName" value="TestFirstName" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="lastName">Last name</label>
                <div class="col-md-4">
                    <input id="lastName" name="lastName" value="TestLastName" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phoneNumber">Phone number</label>
                <div class="col-md-4">
                    <input id="phoneNumber" name="phoneNumber" value="12345678" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signupsubmit"></label>
                <div class="col-md-4">
                    <button id="signupsubmit" name="signupsubmit" class="btn btn-success">SignUp</button>
                </div>
            </div>

        </fieldset>
    </form>


</div>
</body>
</html>




