<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Cloud Waste Tracker</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/pages/favicon.ico" type="image/x-icon"/>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/home">
        <img src="${pageContext.request.contextPath}/pages/brand.png" width="30" height="24" class="d-inline-block align-top" style="margin-top: 3px"
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
            
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="mt-5">Recommendation Data for Resource ${resourceId}</h1>
    <table id = "collection" class="table table-striped table-hover table-sm table-responsive" style="max-width: 100%">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">ID</th>
            <th scope="col">Date</th>
            <th scope="col">Total Spend($)</th>
            <th scope="col">Hours Running</th>
            <th scope="col">Idle(%)</th>
            <th scope="col" style="background-color:deepskyblue">Recommended Action</th>
            <th scope="col" style="background-color:deepskyblue">Recommended Savings($)</th>
            <th scope="col" style="background-color:deepskyblue">Recommended Savings(%)</th>
            <th scope="col">Node Type</th>
            <th scope="col" style="background-color:deepskyblue">Recommended Node Type</th>
            <th scope="col">Unit Price($)</th>
            <th scope="col" style="background-color:deepskyblue">Recommended Unit Price($)</th>
            <th scope="col">CPU Capacity</th>
            <th scope="col" style="background-color:deepskyblue">Recommended CPU Capacity</th>
            <th scope="col">Memory Capacity</th>
            <th scope="col" style="background-color:deepskyblue">Recommended Memory Capacity</th>
            <th scope="col">Network Capacity</th>
            <th scope="col" style="background-color:deepskyblue">Recommended Network Capacity</th>
            <th scope="col">Risk of Recommendation</th>
            <th scope="col">Power On At</th>
            <th scope="col">Shut Down At</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="data" items="${resourcesData}" varStatus="loop">
            <tr>
                <td scope="row">${loop.index + 1}</td>
                <td>${data.id}</td>
                <td>${fn:substring(data.createdAt, 5, 7)}/${fn:substring(data.createdAt, 8, 10)}/${fn:substring(data.createdAt, 2, 4)}</td>
                <td>${Math.floor(data.totalSpend*10)/100}</td>
                <td>${data.hoursRunning}</td>
                <td>${data.idle}</td>
                <td style="border:4px solid #92a8d1">${data.recommendationAction}</td>
                <td style="border:4px solid #92a8d1">${Math.floor(data.recommendationSavings*10)/100}</td>
                <td style="border:4px solid #92a8d1">${data.recommendationSavingsPct}</td>
                <td>${data.nodeType}</td>
                <td style="border:4px solid #92a8d1">${data.recommendationNodeType}</td>
                <td>${data.unitPrice}</td>
                <td style="border:4px solid #92a8d1">${data.recommendationUnitPrice}</td>
                <td>${data.cpuCapacity}</td>
                <td style="border:4px solid #92a8d1">${data.recommendationCpuCapacity}</td>
                <td>${data.memoryCapacity}</td>
                <td style="border:4px solid #92a8d1">${data.recommendationMemoryCapacity}</td>
                <td>${data.networkCapacity}</td>
                <td style="border:4px solid #92a8d1">${data.recommendationNetworkCapacity}</td>
                <td>${data.recommendationRisk}</td>
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
