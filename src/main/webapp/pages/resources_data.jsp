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
    <h1 class="mt-5">Resources Data</h1>
    <table id = "collection" class="table table-striped table-hover table-sm table-responsive" style="max-width: 100%">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">id</th>
            <th scope="col">createdAt</th>
            <th scope="col">resourceId</th>
            <th scope="col">nodeType</th>
            <th scope="col">unitPrice</th>
            <th scope="col">totalSpend</th>
            <th scope="col">cpuCapacity</th>
            <th scope="col">memoryCapacity</th>
            <th scope="col">networkCapacity</th>
            <th scope="col">hoursRunning</th>
            <th scope="col">idle</th>
            <th scope="col">recommendationAction</th>
            <th scope="col">recommendationNodeType</th>
            <th scope="col">recommendationCpuCapacity</th>
            <th scope="col">recommendationMemoryCapacity</th>
            <th scope="col">recommendationNetworkCapacity</th>
            <th scope="col">recommendationUnitPrice</th>
            <th scope="col">recommendationRisk</th>
            <th scope="col">recommendationSavings</th>
            <th scope="col">recommendationSavingsPct</th>
            <th scope="col">powerOnAt</th>
            <th scope="col">shutdownAt</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="data" items="${resourcesData}" varStatus="loop">
            <tr>
                <td scope="row">${loop.index + 1}</td>
                <td>${data.id}</td>
                <td>${data.createdAt}</td>
                <td>${data.resource.resourceId}</td>
                <td>${data.nodeType}</td>
                <td>${data.unitPrice}</td>
                <td>${data.totalSpend}</td>
                <td>${data.cpuCapacity}</td>
                <td>${data.memoryCapacity}</td>
                <td>${data.networkCapacity}</td>
                <td>${data.hoursRunning}</td>
                <td>${data.idle}</td>
                <td>${data.recommendationAction}</td>
                <td>${data.recommendationNodeType}</td>
                <td>${data.recommendationCpuCapacity}</td>
                <td>${data.recommendationMemoryCapacity}</td>
                <td>${data.recommendationNetworkCapacity}</td>
                <td>${data.recommendationUnitPrice}</td>
                <td>${data.recommendationRisk}</td>
                <td>${data.recommendationSavings}</td>
                <td>${data.recommendationSavingsPct}</td>
                <td>${data.powerOnAt}</td>
                <td>${data.shutdownAt}</td>
            </tr>
            
            
        </c:forEach>
        </tbody>
    </table>
</div>

</script>

<div>
<p>
<center>
<button style="font-size:100%;color:white;text-align:center;background-color:black;" onclick="document.location = '/graph_of_resource/${resourceId}'">Return to graph for Resource ${resourceId}</button>
</center>
</p>
</div>
</body>
</html>
