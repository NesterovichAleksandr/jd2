<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <legend>Reserved ticket</legend>


    <table>
        <div class="row">
            <div class=col-md-1><b>Code</b></div>
            <div class=col-md-1><b>Cost</b></div>
            <div class=col-md-1><b>Users id</b></div>
            <div class=col-md-2><b>Film</b></div>
            <div class=col-md-1><b>Cinema</b></div>
        </div>
        <c:forEach items="${reservedTickets}" var="reservedTicket">
            <form class="form-horizontal" action="do?command=DeleteReservedTicket" method="post">
                <fieldset>
                    <div class="row">
                        <input type="hidden" name="idReservedTicket" value="${reservedTicket.id}"/>
                        <div class=col-md-1>${reservedTicket.code}</div>
                        <div class=col-md-1>${reservedTicket.cost}</div>
                        <div class=col-md-1>${reservedTicket.users_id}</div>
                        <div class=col-md-2>
                            <c:forEach items="${films}" var="film">
                                <c:if test="${film.id==reservedTicket.films_id}">
                                    ${film.name}
                                </c:if>
                            </c:forEach>
                        </div>
                        <div class=col-md-1>
                            <c:forEach items="${cinemas}" var="cinema">
                                <c:if test="${cinema.id==reservedTicket.cinemas_id}">
                                    ${cinema.name}
                                </c:if>
                            </c:forEach>
                        </div>

                        <button id="deleteButton" value="deleteButton" name="deleteButton" class="btn btn-primary">
                            delete
                        </button>

                    </div>
                </fieldset>
            </form>
        </c:forEach>
    </table>


</body>
</html>
