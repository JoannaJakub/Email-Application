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
            <%@ include file="../header.jsp" %>

            <!-- Content -->
            <section>
                <header class="main">
                    <h1> You have successfully created email!</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Table -->
                        <h3>Table</h3>

                        <h4>Default</h4>
                        <div class="table-wrapper">
                            <form:form items="${userDetails}" var="userDetails">
                            <table>
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th><c:out value="${userDetails.firstName}"/></th>
                                    <th>Price</th>
                                </tr>
                                </thead>
                                <thead>
                                <tr>
                                    <th>Surname</th>
                                    <th><c:out value="${userDetails.lastName}"/></th>
                                    <th>Price</th>
                                </tr>
                                </thead>
                                <thead>
                                <tr>
                                    <th>Mailbox capacity</th>
                                    <th><c:out value="${userDetails.mailboxCapacity}"/></th>
                                    <th>Price</th>
                                </tr>
                                </thead>
                                <thead>
                                <tr>
                                    <th>Email</th>
                                    <th><c:out value="${userDetails.generatedEmail}"/></th>
                                    <th>Price</th>
                                </tr>
                                </thead>
                                <thead>
                                <tr>
                                    <th>Password</th>
                                    <th><c:out value="${userDetails.password}"/></th>
                                    <th>Price</th>
                                </tr>
                                </thead>
                            </table>
                            </form:form>
                        </div>
                    </div>
                </div>

            </section>

        </div>
    </div>

    <!-- Sidebar -->
    <%@ include file="../sidebar.jsp" %>

</div>

<!-- Scripts -->
<%@ include file="../scripts.jsp" %>

</body>
</html>