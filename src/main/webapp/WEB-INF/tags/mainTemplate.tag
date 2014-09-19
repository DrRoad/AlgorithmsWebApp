<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html>
<html lang="en">
	<head>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script src="http://code.highcharts.com/highcharts.js"></script>
		<script src="<%=request.getContextPath()%>/resources/javascript/sort.js"></script>
		<script src="<%=request.getContextPath()%>/resources/javascript/chart.js"></script>
	</head>
	<body>
		<t:header/>
		<t:leftMenu/>
		<div id="body">
			<jsp:doBody/>
		</div>
		<t:footer/>
	</body>

</html>