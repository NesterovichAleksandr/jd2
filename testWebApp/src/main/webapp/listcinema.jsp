<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <legend>List cinema</legend>

    <table>
        <div class="row">
            <div class=col-md-1><b>Name</b></div>
            <div class=col-md-4><b>Address</b></div>
        </div>
        <c:forEach items="${listCinemaForFilm}" var="cinemaT">
            <form class="form-horizontal" action="do?command=CreateReservedTicket" method="post">
                <fieldset>
                    <c:forEach items="${cinemas}" var="cinema">
                        <c:if test="${cinema.id==cinemaT.cinemas_id}">
                            <div class="row">
                                <input type="hidden" name="cinemaId" value="${cinema.id}"/>
                                <div class=col-md-1>${cinema.name}</div>
                                <div class=col-md-4>${cinema.address}</div>
                                <button id="reservButton" value="reservButton" name="reservButton"
                                        class="btn btn-primary">
                                    Reserv
                                </button>
                            </div>
                        </c:if>
                    </c:forEach>
                </fieldset>
            </form>
        </c:forEach>
    </table>
</body>
</html>
