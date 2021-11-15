<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Message has been send successfully</title>
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
                    <h1> You have successfully sent message!</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Table -->
                        <h3></h3>

                        <h4></h4>
                        <div class="table-wrapper">
                            <form:form items="${sendMessage}" var="sendMessage">
                            <table>
                                <thead>
                                <tr>
                                    <th>Message</th>
                                    <th><c:out value="${sendMessage}"/></th>
                                </tr>
                                </thead>
                            </table>
                                <div class="col-12">
                                    <ul class="actions">
                                        <li><a href="<c:url value="/allMessage"/>" class="button large">All
                                            message</a></li>

                                    </ul>
                                </div>
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