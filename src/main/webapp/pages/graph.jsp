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
<canvas id ="chart" width="400" height="400"></canvas>
<div class="container">

<c:forEach var="data" items="${waste}" varStatus="loop">


</c:forEach>

    <script>
        var x =[];
        var y =[];
        var t = null;
        <c:forEach var="data" items="${waste}" varStatus="loop">

            y[${loop.index}] =  ${data.totalSpend};
         
            x[${loop.index}] =  "${data.createdAt}";
         </c:forEach>
        
        const ctx = document.getElementById('chart').getContext('2d');
        const xlabels = x;
        const myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: xlabels,
                datasets: [{
                    label: 'Time versus TotalSpend',
                    data: y,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });
                
    </script>

</div>

</body>
</html>
