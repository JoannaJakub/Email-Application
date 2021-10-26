<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Generate new password - confirm</title>
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
                    <h1>New password</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Form -->
                        <h3></h3>

                        <form:form items="${newPassword}" var="newPassword">
                            <div class="row gtr-uniform">
                                <div class="col-6 col-12-xsmall">
                                    <c:out value="${newPassword.firstName}"/>
                                </div>
                                <div class="col-6 col-12-xsmall">
                                    <c:out value="${newPassword.lastName}"/>
                                </div>
                                <tr>
                                    <div class="col-12">
                                        <td>New Password<br></td>
                                        <br>
                                        <c:out value="${newPassword.password}"/>
                                    </div>
                                </tr>

                                <!-- Break -->
                                <div class="col-12">
                                    <ul class="actions">
                                        <li><a href="<c:url value="/userGenerateNewPassword/${newPassword.id}"/>"
                                               class="button primary large">Generate password again</a></li>
                                        <li><a href="<c:url value="/allUsers"/>" class="button large">Back to all
                                            users</a></li>

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