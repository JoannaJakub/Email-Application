<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Header -->
<header id="header">
    <a href="<c:url value="/adminLandingPage"/>" class="logo"><strong>Email</strong> creator</a>

    <ul class="icons">
<%--       <li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
        <li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
        <li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>

        <li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
        <li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>--%>
        <sec:authorize access="isAuthenticated()">
            <li>Hi <span class="label"><sec:authentication property="name"/></span>!</li>
            <li>Your role: <span class="label"><sec:authentication property="authorities"/></span></li>
        </sec:authorize>
        <li>
            <sec:authorize access="isAuthenticated()">
            <form action="<c:url value="/logout"/>" method="post">
                <input type="submit" value="Wyloguj">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </sec:authorize>
        </li>


    </ul>


</header>
