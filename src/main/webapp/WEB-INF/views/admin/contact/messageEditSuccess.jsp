<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Message Edit Success</title>
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
                    <h1>Message has been changed!</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Form -->
                        <h3>Form</h3>

                        <form:form method="post" items="${messageEditSuccess}" var="messageEditSuccess">
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
                                    <c:out value="${messageEditSuccess}"/>
                                </div>
                                </tr>

                                <!-- Break -->
                                <div class="col-12">
                                    <ul class="actions">
                                        <li><a href="<c:url value="/messageEdit/${id}"/>"
                                               class="button primary large">Edit this Message</a></li>
                                        <li><a href="<c:url value="/allMessages"/>" class="button large">Back to all
                                            messages</a></li>

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