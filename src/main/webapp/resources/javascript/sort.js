$(document).ready(function() {
	$("input:radio[name=numShots]").click(function() {
		var numShotsVal = $(this).val();
		if(numShotsVal == "single") {
			$('#numIntsDiv span').text('Number of integers to sort: ');
		} else if(numShotsVal == "range") {
			$('#numIntsDiv span').text('Maximum for range of integers to sort: ');
		}
	});

});

$(document).ready(function() {
	var dataVals = [];	//holds all timeElapsed repsonses from servlet
	var seriesParams = [];	//formatted JSON object to send to highcharts series
	
	//Make a formatted JSON object with all possible algorithms
	var options = $('#algorithm option');
	var values = $.map(options, function(option) {
		seriesParams.push({name: option.value, data: [[0,0]]});
	});

	//AJAX POST to servlet
	$('#submit').click(function(event) {
		event.preventDefault();
		var n = $('#numInts').val();
		var alg = $('#algorithm').val();
		var numShotsToSend = $("input:radio[name=numShots]:checked").val();
		$.post('sort', {algorithm: alg, numInts: n, numShots: numShotsToSend}, function(data, textStatus, jqXHR) {
			for(var j=0; j<seriesParams.length; j++) {
				if(seriesParams[j]["name"] == alg) {
					for(var key in data) {
						seriesParams[j]["data"].push([parseFloat(key), parseFloat(data[key])]);
					}
				}
			}
			plotWithData(seriesParams);
		}, 'json');
	});
});

function plotWithData(seriesParams) {
    $('#chartContainer').highcharts({
    	chart: {
    		type: 'scatter',
    		zoomType: 'xy'
    	},
    	legend: {
    		layout: 'vertical',
    		align: 'right',
    		verticalAlign: 'top',
    		itemStyle: {
    			fontSize: '20px'
    		}
    	},
        series: seriesParams,
        xAxis: {
        	title: {
        		text: '# of Sorts',
        		style: {
        			fontSize: '30px'
        		}
        	},
        	labels: {
        		style: {
        			fontSize: '20px'
        		}
        	},
        	min: 0
        },
        yAxis: {
        	title: {
        		text: 'Time Elapsed (s)',
        		style: {
        			fontSize: '30px'
        		}
        	},
        	labels: {
        		style: {
        			fontSize: '20px'
        		}
        	},
        	min: 0
        }
    });
};