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
                <header class="main">
                    <h1>User has been changed!</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Form -->
                        <h3>Form</h3>

                        <form:form method="post" items="${emailConfirmEditing}" var="emailConfirmEdit">
                            <div class="row gtr-uniform">
                                <tr>
                                <div class="col-6 col-12-xsmall">
                                    <td>ID</td>
                                    <c:out value="${id}" />
                                </div>
                                </tr>
                                <tr>
                                <div class="col-12">
                                    <td>Name</td>
                                    <c:out value="${emailConfirmEdit.firstName}"/>
                                </div>
                                </tr>
                                <tr>
                                <div class="col-12">
                                    <td>Surname</td>
                                    <c:out value="${emailConfirmEdit.lastName}"/>
                                </div>
                                </tr>
                                <tr>
                                    <div class="col-12">
                                        <td>Email</td>
                                        <c:out value="${emailConfirmEdit.generatedEmail}"/>
                                    </div>
                                </tr>
                                <tr>
                                    <div class="col-12">
                                        <td>Password</td>
                                        <c:out value="${emailConfirmEdit.password}"/>
                                    </div>
                                </tr>
                                <tr>
                                    <div class="col-12">
                                        <td>Mailbox capcity</td>
                                        <c:out value="${emailConfirmEdit.mailboxCapacity}"/>
                                    </div>
                                </tr>

                                <!-- Break -->
                                <div class="col-12">
                                    <ul class="actions">

                                    </ul>
                                </div>
                            </div>
                        </form:form>


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