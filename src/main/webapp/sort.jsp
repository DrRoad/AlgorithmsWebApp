<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:mainTemplate>
	<jsp:body>

	<div id="sortInputDiv">
		<form action="${pageContext.request.contextPath}/sort" method="POST">		
			<select name="algorithm" id="algorithm">
				<option value="inPlaceInsertionSort">In Place Insertion Sort</option>
				<option value="insertionSort">Insertion Sort</option>
				<option value="mergeSort">Merge Sort</option>
			</select>
			<input type="number" name="numInts" id="numInts" min="1" max="100000">
			<input class="btn-rect" id="submit" type="button" value="Sort">
		</form>
	</div>
	<div id="chartContainer"></div>
	
	<div id="response" style="width: 100%; float: left; height:100px;">
		<span> Value: </span>
	</div>

	</jsp:body>
</t:mainTemplate>

