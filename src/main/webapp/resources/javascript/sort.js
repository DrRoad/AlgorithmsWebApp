$(document).ready(function() {
	var dataVals = [];
	$('#submit').click(function(event) {
		event.preventDefault();
		var n = $('#numInts').val();
		var alg = $('#algorithm').val();
		$.post('sort', {algorithm: alg, numInts: n}, function(responseText) {
			$('#response span').text(responseText);
			dataVals.push([parseFloat(n), parseFloat(responseText)]);
			plotWithData(dataVals);
		});
	});
});

function plotWithData(dataVals) { 
    $('#chartContainer').highcharts({
    	chart: {
    		type: 'scatter',
    		zoomType: 'xy'
    	},
        series: [{
            name: 'TimeElapsed',
            data: dataVals
        }]
    });
};