<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Cloud Waste Tracker</title>
    <link rel="shortcut icon" href="pages/favicon.ico" type="image/x-icon"/>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
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
<canvas id ="chart" width="100" height="50"></canvas>
<c:forEach var="data" items="${waste}" varStatus="loop">


</c:forEach>

    <script>
        var x =[];
        var ySpend =[];
        var yWaste = [];
        var t = null;
        <c:forEach var="data" items="${waste}" varStatus="loop">

        	yWaste[${loop.index}] = ${data.recommendationSavings};

            ySpend[${loop.index}] =  ${data.totalSpend};
         
            x[${loop.index}] =  "${data.createdAt}";
         </c:forEach>
        
        const ctx = document.getElementById('chart').getContext('2d');
        const xlabels = x;
        const myChart = new Chart(ctx, {
        	  type: 'line',
        	  data: {
        	    labels: xlabels,
        	    datasets: [{
        	      label: 'Total Spent',
        	      data: ySpend,
                  borderColor: 
                      'rgba(0, 0, 0, 1)'
                  ,
                  borderWidth: 1
        	    }, {
        	      label: 'Amount Wasted',
        	      data: yWaste,
        	      backgroundColor: 
                      'rgba(255, 0, 0, 0.3)'
                  ,
                  borderColor: 
                      'rgba(255, 0, 0, 1)'
                  ,
                  borderWidth: 1
        	    }]
        	  },
        	  options: {
  				responsive: true,
  				title: {
  					display: true,
  					text: 'Time vs Waste for Resource ID'
  				},
  				
  				hover: {
  					mode: 'nearest',
  					intersect: true
  				} ,
  	            scales: {
  	              xAxes: [{
  	                display: true,
  	                scaleLabel: {
  	                  display: true,
  	                  labelString: 'Date (YYYY/MM/DD)'
  	                }
  	              }],
  	              yAxes: [{
  	                display: true,
  	                scaleLabel: {
  	                  display: true,
  	                  labelString: 'Amount ($)'
  	                }
  	              }],
  	            }
        	  }
        	});        
    </script>

</div>

</body>
</html>
