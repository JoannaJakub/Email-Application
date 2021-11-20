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
                    <h1>Forgot password</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Form -->

                        <form:form method="post" action="forgotPassword" style="form-validate mb-4">
                            <div class="border border-secondary rounded p-3">
                                <div>
                                    <p>We will be sending a reset password link to your email.</p>
                                </div>
                                <div>
                                    <p>
                                        <input type="email" name="email" placeholder="Enter your e-mail" path="email"/>
                                    </p>
                                    <p class="text-center">
                                        <input type="submit" value="Send" class="btn btn-primary" />
                                    </p>
                                </div>
                            </div>
                        </form:form>
                        <div th:if="${error != null}">
                            <h2 class="text-danger">${error}</h2>
                        </div>
                        <div th:if="${message != null}">
                            <h2 class="text-warning">${message}</h2>
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