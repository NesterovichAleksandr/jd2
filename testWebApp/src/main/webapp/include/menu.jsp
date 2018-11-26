<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href=".">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item ">
                <a class="nav-link" href="do?command=Reset">Reset</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="do?command=ListFilm">List film</a>
            </li>
            <c:if test="${user!=null}">
                <li class="nav-item ">
                    <a class="nav-link" href="do?command=UserCabinet">User cabinet</a>
                </li>
            </c:if>
            <c:if test="${user==null}">
                <li class="nav-item ">
                    <a class="nav-link" href="do?command=SignUp">SignUp</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="do?command=Login">Login</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>