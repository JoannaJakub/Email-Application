<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Generate new password</title>
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
                    <h1>Generate new password for the user</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Form -->
                        <h3>Form</h3>

                        <form:form method="post"   modelAttribute="generateNewPassword">
                            <div class="row gtr-uniform">
                                <div class="col-6 col-12-xsmall">
                                    <form:hidden path="firstName"/>
                                    <form:hidden path="lastName"/>
                                    <form:hidden path="generatedEmail"/>
                                    <form:hidden path="mailboxCapacity"/>
                                    <c:out value="${generateNewPassword}"/>
                                </div>
                                <div class="col-6 col-12-xsmall">
                                    <c:out value="${firstName}"/>
                                </div>
                                <div class="col-6 col-12-xsmall">
                                    <form:input type="text" name="password" id="password" value="" placeholder="password" path="password"/>
                                </div>
                                <!-- Break -->
                                <div class="col-12">
                                    <ul class="actions">
                                        <li><input type="submit" value="Confirm new password" class="button primary large"/></li>
                                        <a href="<c:url value="/allEmails"/>"
                                           class="button large" type="submit" >Back</a>
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
    <%@ include file="../sidebar.jsp" %>

</div>

<!-- Scripts -->
<%@ include file="../scripts.jsp" %>

</body>
</html>