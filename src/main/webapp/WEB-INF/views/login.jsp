<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Email creator</title>
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
                    <h1>Login</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Form -->


                        <form:form method="post" class="form-validate mb-4" authentication-failure-url="/login?error=true">
                            <div class="form-group">
                                <input id="login-username" type="text" name="username" placeholder="Email" required data-msg="Please enter your email" class="input-material">

                                <label for="login-username" class="label-material"></label>
                            </div>
                            <div class="form-group">
                                <input id="login-password" type="password" name="password" placeholder="Password" required data-msg="Please enter your password" class="input-material">
                                <label for="login-password" class="label-material"></label>
                            </div>
                            </br>
                            <div class="form-group terms-conditions text-center">
                                <button type="submit" class="btn btn-primary">Login</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </br> </br>
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
<%@ include file="scripts.jsp" %>

</body>
</html>