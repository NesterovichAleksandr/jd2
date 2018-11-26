<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" action="do?command=UpdateFilm" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Update film</legend>

            <input type="hidden" name="filmId" value="${IdFilm}"/>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="filmName">Name</label>
                <div class="col-md-4">
                    <input id="filmName" name="filmName" value=${filmIdName} type="text" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="filmCountry">Country</label>
                <div class="col-md-4">
                    <input id="filmCountry" name="filmCountry" value=${filmIdCountry} type="text" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="filmGenre">Genre</label>
                <div class="col-md-4">
                    <input id="filmGenre" name="filmGenre" value=${filmIdGenre} type="text" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="filmYearOfIssue">Year Of Issue</label>
                <div class="col-md-4">
                    <input id="filmYearOfIssue" name="filmYearOfIssue" value=${filmIdYearOfIssue} type="text"
                           placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="filmDuration">Duration</label>
                <div class="col-md-4">
                    <input id="filmDuration" name="filmDuration" value=${filmIdDuration} type="text" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="savefilmsubmit"></label>
                <div class="col-md-4">
                    <button id="savefilmsubmit" name="savefilmsubmit" class="btn btn-success">Save</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
