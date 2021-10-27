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
                    <h1>Login</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Form -->


                        <div>
                            <h2>Forgot Password</h2>
                        </div>
<%--
                        <div th:if="${error != null}">
                            <p class="text-danger">[[${error}]]</p>
                        </div>
                        <div th:if="${message != null}">
                            <p class="text-warning">[[${message}]]</p>
                        </div>--%>

                        <form:form method="post" action="forgot_password" style="max-width: 420px; margin: 0 auto;">
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

                    </div>
                </div>

            </section>

        </div>
    </div>

    <!-- Sidebar -->


</div>

<!-- Scripts -->
<%@ include file="../admin/scripts.jsp" %>

</body>
</html>