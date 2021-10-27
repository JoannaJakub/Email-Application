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
                            <h2>Reset Your Password</h2>
                        </div>

                        <form th:action="@{/reset_password}" method="post" style="max-width: 350px; margin: 0 auto;">
                            <input type="hidden" name="token" th:value="${token}" />
                            <div class="border border-secondary rounded p-3">
                                <div>
                                    <p>
                                        <input type="password" name="password" id="password" class="form-control"
                                               placeholder="Enter your new password" required autofocus />
                                    </p>
                                    <p>
                                        <input type="password" class="form-control" placeholder="Confirm your new password"
                                               required oninput="checkPasswordMatch(this);" />
                                    </p>
                                    <p class="text-center">
                                        <input type="submit" value="Change Password" class="btn btn-primary" />
                                    </p>
                                </div>
                            </div>
                        </form>

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