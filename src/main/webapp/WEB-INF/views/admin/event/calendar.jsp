<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Using JavaScript/HTML5 Event Calendar in Spring Boot (Java) </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <link rel="stylesheet" href="<c:url value="../resources/distribution/assets/css/main.css"/>"/>

    <link href="<c:url value="../resources/static/css/main.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="../resources/static/icons/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body class="is-preload">

<div id="wrapper">
    <!-- Main -->
    <div id="main">
        <div class="inner">
            <!-- Header -->
            <%@ include file="../header.jsp" %>

            <div class="main" style="display: flex;">
                <div style="margin-right: 10px;">
                    <div id="nav"></div>
                </div>
                <div style="flex-grow: 1">
                    <div id="dp"></div>
                </div>
            </div>

        </div>
    </div>
    <!-- Sidebar -->
    <%@ include file="../sidebar.jsp" %>

</div>

<!-- DayPilot library -->
<script src="../resources/static/js/daypilot/daypilot-all.min.js"></script>
<!-- Scripts -->
<%@ include file="../scripts.jsp" %>
<script>

    const nav = new DayPilot.Navigator("nav");
    nav.showMonths = 3;
    nav.skipMonths = 3;
    nav.selectMode = "week";
    nav.onTimeRangeSelected = (args) => {
        dp.startDate = args.day;
        dp.update();
        dp.events.load("/api/events");
    };
    nav.init();


    const dp = new DayPilot.Calendar("dp");
    dp.viewType = "Week";
    dp.onTimeRangeSelected = function (args) {
        DayPilot.Modal.prompt("Create a new event:", "Event").then(function (modal) {
            var dp = args.control;
            dp.clearSelection();
            if (!modal.result) {
                return;
            }
            var params = {
                start: args.start.toString(),
                end: args.end.toString(),
                text: modal.result
            };
            DayPilot.Http.ajax({
                url: '/api/events/create',
                data: params,
                success: function (ajax) {
                    var data = ajax.data;
                    dp.events.add(new DayPilot.Event(data));
                    dp.message("Event created");
                }
            });
        });
    };


    dp.init();

    dp.events.load("/api/events");


</script>

</body>
</html>