<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Elements - Editorial by HTML5 UP</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <link rel="stylesheet" href="<c:url value="../resources/distribution/assets/css/main.css"/>"/>
</head>
<body class="is-preload">

<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <!-- Header -->
            <%@ include file="header.jsp" %>

            <!-- Content -->
            <section>
                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Table -->
                        <h3>Users</h3>

                        <div class="table-responsive">
                            <table>
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>Mailbox capacity</th>
                                    <th>Email</th>
                                    <th>Password</th>
                                    <th>Delete</th>

                                </tr>
                                </thead>
                                <c:forEach items="${users}" var="users">
                                <thead>

                                    <td><c:out value="${users.id}"/></td>
                                    <td><c:out value="${users.firstName}"/></td>
                                    <td><c:out value="${users.lastName}"/></td>
                                    <td><c:out value="${users.mailboxCapacity}"/></td>
                                    <td><c:out value="${users.generatedEmail}"/></td>
                                    <td><c:out value="${users.password}"/></td>
                                    <td><a href="<c:url value="/emailConfirmDelete/?id=${users.id}"/>">Delete</a></td>

                                </thead>
                                </c:forEach>
                            </table>

                        </div>
                    </div>
                </div>

            </section>

        </div>
    </div>

    <!-- Sidebar -->
    <%@ include file="sidebar.jsp" %>

</div>

<!-- Scripts -->
<%@ include file="scripts.jsp" %>

</body>
</html>