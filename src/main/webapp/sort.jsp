<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:mainTemplate>
	<jsp:body>

	<div id="sortInputDiv">
		<form action="${pageContext.request.contextPath}/sort" method="POST">
			<div class="form" id="sortAlg">
				<select name="algorithm" id="algorithm">
					<option value="inPlaceInsertionSort">In Place Insertion Sort</option>
					<option value="insertionSort">Insertion Sort</option>
					<option value="modifiedQuickSort">Quick Sort (Java Library)</option>
					<option value="mergeSort">Merge Sort</option>
				</select>
			</div>
			<div class="form" id="sortNum">
				<input type="radio" class="radio" name="numShots" value="single">Single Shot<br />
				<input type="radio" class="radio" name="numShots" value="range" checked>Range<br />
				<div id="numIntsDiv">
					<span>Maximum for range of integers to sort: </span><br />
					<input type="number" name="numInts" id="numInts" min="1" max="100000" value="10">
				</div>
			</div>
			<div class="form" id="sortSubmit">
				<input class="btn-rect" id="submit" type="button" value="Sort">
			</div>
		</form>
	</div>
	<div id="chartContainer"></div>

	</jsp:body>
</t:mainTemplate>

