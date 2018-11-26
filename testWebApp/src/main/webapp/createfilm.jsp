<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p>Cmd CreateFilm: ${message}</p>

    <form class="form-horizontal" action="do?command=CreateFilm" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Create film</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Name</label>
                <div class="col-md-4">
                    <input id="name" name="name" value="TestName" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="country">Country</label>
                <div class="col-md-4">
                    <input id="country" name="country" value="TestCountry" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="genre">Genre</label>
                <div class="col-md-4">
                    <input id="genre" name="genre" value="TestGenre" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="yearOfIssue">Year of issue</label>
                <div class="col-md-4">
                    <input id="yearOfIssue" name="yearOfIssue" value="2000" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="duration">Phone number</label>
                <div class="col-md-4">
                    <input id="duration" name="duration" value="111" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createfilmsubmit"></label>
                <div class="col-md-4">
                    <button id="createfilmsubmit" name="createfilmsubmit" class="btn btn-success">Create film</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>
