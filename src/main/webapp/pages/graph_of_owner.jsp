<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>

	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Cloud Waste Tracker</title>
    <link rel="shortcut icon" href="pages/favicon.ico" type="image/x-icon"/>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
    
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/home">
        <img src="pages/brand.png" width="30" height="24" class="d-inline-block align-top" style="margin-top: 3px"
             alt="">
        Cloud Waste Tracker
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="/home">Home</a>
            <a class="nav-item nav-link" href="/vendors">Vendors</a>
            <a class="nav-item nav-link" href="/resources">Resources</a>
            <a class="nav-item nav-link active" href="#">Resources Data <span class="sr-only">(current)</span></a>
        </div>
    </div>
</nav>
<div class="container">
		<div class="row">
			<h2>Select Date Range</h2>
		</div>
		<div class="row">
	        <div class='col-sm-6'>
	        	<form>
		            <div class="form-group">
		                <div class='input-group date' id='datepicker'>
		                    <input type='text' class="form-control" />
		                    <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                    </span>
		                </div>
		            </div>
		        </form>
	        </div>
	        <div class='col-sm-6'>
	        	<form>
		            <div class="form-group">
		                <div class='input-group date' id='datepicker2'>
		                    <input type='text' class="form-control" />
		                    <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                    </span>
		                </div>
		            </div>
		        </form>
	        </div>
	        <input style="font-size:160%;color:white;text-align:center;background-color:black;" type ="submit" name="submitbutton" onclick = "myFunction()" value="Apply Selected Date Range"/>
	    </div>
	</div>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
	<script >
	var sdateString =' ';
	var edateString =' ';
	    $(function () {
	        $('#datepicker').datepicker({
	            format: "mm/dd/yy",
	            autoclose: true,
	            todayHighlight: true,
		        showOtherMonths: true,
		        selectOtherMonths: true,
		        autoclose: true,
		        changeMonth: true,
		        changeYear: true,
		        orientation: "button"
	        });
	    });
	    $(function () {
	        $('#datepicker2').datepicker({
	            format: "mm/dd/yy",
	            autoclose: true,
	            todayHighlight: true,
		        showOtherMonths: true,
		        selectOtherMonths: true,
		        autoclose: true,
		        changeMonth: true,
		        changeYear: true,
		        orientation: "button"
	        });
	    });

	    function myFunction(){
			var sdate = $("#datepicker").datepicker("getDate");
		
			var edate = $("#datepicker2").datepicker("getDate");
		
			

			let sd = Math.floor(sdate.getTime()/1000.0-4*3600).toString();
			let ed = (Math.floor(edate.getTime()/1000.0)+20*3600).toString();
			let site = "/graph_of_owner/?owner=" +"${owner}&startDate="+sd+"&endDate="+ed;
			location.replace(site);
			
			
		    }
	</script>
	
<div class="container">
<canvas id ="chart" width="100" height="50"></canvas>
<c:forEach var="data" items="${waste}" varStatus="loop">


</c:forEach>

    <script>
		var x =[];
        var yAmount =[];
        var yPercent = [];
        var yTotal = [];
        var t = null;
        <c:forEach var="data" items="${waste}" varStatus="loop">
    	yPercent[${loop.index}] = ${data.getWastePercent()};
        yAmount[${loop.index}] =  ${Math.floor(data.getTotalWaste()*100)/100};
        yTotal[${loop.index}] = ${Math.floor(data.getTotalSpent()*100)/100};
     
        x[${loop.index}] =  "${fn:substring(data.getDate(), 5, 7)}" + "/" + "${fn:substring(data.getDate(), 8, 10)}" + "/" + "${fn:substring(data.getDate(), 2, 4)}";
     </c:forEach>
        
        const ctx = document.getElementById('chart').getContext('2d');
        const xlabels = x;
        const myChart = new Chart(ctx, {
        	  type: 'line',
        	  data: {
        	    labels: xlabels,
        	    datasets: [{
        	      label: 'Wasted Spend ($)',
        	      yAxisID: 'yAmount',
        	      order: 2,
        	      data: yAmount,
        	      backgroundColor: 
                      'rgba(255, 99, 132, 0.2)'
                  ,
                  borderColor: 
                      'rgba(255, 99, 132, 1)'
                  ,
                  borderWidth: 1
        	    }, {
        	      label: 'Wasted Spend (%)',
        	      yAxisID: 'yPercent',
        	      order: 3,
        	      data: yPercent,
        	      backgroundColor: 
                      'rgba(255, 255, 255, 0.0)'
                  ,
                  borderColor: 
                      'rgba(0, 0, 0, 1)'
                  ,
                  borderWidth: 1
        	    }, 
        	    {
          	      label: 'Total Spend ($)',
          	      yAxisID: 'yTotal',
          	      order: 1,
          	      data: yTotal,
          	      backgroundColor: 
                        'rgba(128, 128, 128, 0.2)'
                    ,
                    borderColor: 
                        'rgba(128, 128, 128, 1)'
                    ,
                    borderWidth: 1
          	    }]
        	  },
        	  options: {
  				responsive: true,
  				title: {
  					display: true,
  					text: 'Waste over Time for Owner: ' + ' ${owner}',
  					fontSize: 30
  				},
  				
  				hover: {
  					mode: 'nearest',
  					intersect: true
  				},
        	    scales: {
        	    	xAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Date (MM/DD/YY)'
						}
					}],
        	      yAxes: [{
        	        id: 'yAmount',
        	        type: 'linear',
        	        position: 'left',
        	        ticks: {
        	          min: 0,
          	          max: Math.round(Math.max.apply(this, yTotal)*1.15/10)*10
          	        },
        	        display: true,
  	                scaleLabel: {
  	                  display: true,
  	                  labelString: 'Amount ($)'
  	                }
        	      }, {
        	        id: 'yPercent',
        	        type: 'linear',
        	        position: 'right',
        	        ticks: {
        	          max: 100,
        	          min: 0
        	        },
        	        display: true,
  	                scaleLabel: {
  	                  display: true,
  	                  labelString: 'Amount (%)'
  	                }
        	      }, 
        	      {
          	        id: 'yTotal',
          	        type: 'linear',
          	        position: 'left',
          	        ticks: {
            	          min: 0,
            	          max: Math.round(Math.max.apply(this, yTotal)*1.15/10)*10
            	        },
          	        display: false
          	      }]
        	    }
        	  }
        	});        
    </script>

</div>
<div>
<p>
<center>
<button style="font-size:160%;color:white;text-align:center;background-color:black;" onclick="document.location = '/resources'">Return to List of Resources ${resourceId}</button>
</center>
</p>
</div>

</body>
</html>