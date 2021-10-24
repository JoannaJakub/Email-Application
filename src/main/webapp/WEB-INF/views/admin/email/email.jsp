<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Creating email</title>
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
                    <h1>Email creator</h1>
                </header>

                <!-- Elements -->

                <div class="row gtr-200">

                    <div class="col-6 col-12-medium">

                        <!-- Form -->
                        <h3>Form</h3>

                        <form:form method="post" action="emailSuccess"  modelAttribute="user">
                            <div class="row gtr-uniform">
                                <div class="col-6 col-12-xsmall">
                                    <form:input type="text" name="name" id="name" value="" placeholder="Name" path="firstName"/>
                                </div>
                                <div class="col-6 col-12-xsmall">
                                    <form:input type="text" name="surname" id="surname" value="" placeholder="Surname" path="lastName"/>
                                </div>
                                <!-- Break -->
                                <div class="col-12">
                                    <form:select items="${department}" path="department" itemLabel="name" itemValue="id"/>
                                </div>
                                <!-- Break -->
                                <div class="col-4 col-12-small">
                                    <input type="radio" id="demo-priority-low" name="demo-priority" checked>
                                    <label for="demo-priority-low">Low</label>
                                </div>
                                <div class="col-4 col-12-small">
                                    <input type="radio" id="demo-priority-normal" name="demo-priority">
                                    <label for="demo-priority-normal">Normal</label>
                                </div>
                                <div class="col-4 col-12-small">
                                    <input type="radio" id="demo-priority-high" name="demo-priority">
                                    <label for="demo-priority-high">High</label>
                                </div>
                                <!-- Break -->
                                <div class="col-6 col-12-small">
                                    <input type="checkbox" id="demo-copy" name="demo-copy">
                                    <label for="demo-copy">Email me a copy</label>
                                </div>
                                <div class="col-6 col-12-small">
                                    <input type="checkbox" id="demo-human" name="demo-human" checked>
                                    <label for="demo-human">I am a human</label>
                                </div>
                                <!-- Break -->
                                <div class="col-12">
                                    <ul class="actions">
                                        <li><input type="submit" value="Send Message" class="primary"/></li>
                                        <li><input type="reset" value="Reset"/></li>
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