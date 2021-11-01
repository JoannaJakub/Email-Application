<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Forgot password</title>
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
            <%@ include file="../admin/header.jsp" %>

            <!-- Content -->
            <section>
                <header class="main">
                    <h1>Reset password</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                            <div class="border border-secondary rounded p-3">
                                <div th:if="${message != null}">
                                    <h2 class="text-warning">${message}</h2>
                                </div>
                            </div>

                    </div>
                </div>

            </section>

        </div>
    </div>

</div>

<!-- Scripts -->
<%@ include file="../admin/scripts.jsp" %>

</body>
</html>