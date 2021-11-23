<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>All emails</title>
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

                        <h3>Messages</h3>

                        <!-- Filter -->
                        <form:form action="allMessages">
                            Filter: <input type="text" name="keyword" id="keyword" size="50" value="${keyword}" required />
                            <input type="submit" value="Search" />
                            <input type="button" value="Clear" id="btnClear" onclick="clearSearch()" />
                        </form:form>
                        <script type="text/javascript">
                            function clearSearch() {
                                window.location = "/allMessages";
                            }
                        </script>

                        <!-- Table -->
                        <div class="table-responsive">
                            <table>
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Message</th>
                                    <th>Delete</th>
                                    <th>Edit</th>

                                </tr>
                                </thead>
                                <c:forEach items="${message}" var="message">
                                <thead>

                                    <td><c:out value="${message.id}"/></td>
                                    <td><c:out value="${message.message}"/></td>
                                    <td><a href="<c:url value="/messageConfirmDelete/?id=${message.id}"/>">Delete</a></td>
                                    <td><a href="<c:url value="/messageEdit/${message.id}"/>">Edit</a></td>

                                </thead>
                                </c:forEach>
                            </table>

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