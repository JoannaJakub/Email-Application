<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Deleting email</title>
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
                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Table -->
                        <h3></h3>
                        <h1>Are you sure of removing user?</h1>
                        <div class="form-group row">
                            <div class="col-sm-9 ml-auto">
                                <a href="<c:url value="/emailDelete/${param.id}"/>"
                                   class="button primary large" >YES, delete email</a>
                                <a href="<c:url value="/allEmails"/>"
                                   class="button large" type="submit" >NO</a>

                            </div>
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