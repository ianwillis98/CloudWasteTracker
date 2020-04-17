<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Cloud Waste Tracker</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/pages/favicon.ico" type="image/x-icon"/>
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
            <a class="nav-item nav-link active" href="#">Resources <span class="sr-only">(current)</span></a>
           
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="mt-5">Resources</h1>
    <table class="table table-striped table-hover table-sm table-responsive" style="max-width: 100%">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Resource Id</th>
            <th scope="col">EC2 Wasted Spend($)</th>
            <th scope="col">EC2 Wasted Spend(%)</th>
            <th scope="col">Application Id</th>
            <th scope="col">Application Name</th>
<%--            <th scope="col">applicationOwner</th>--%>
            <th scope="col">Account Id</th>
            <th scope="col">Account Name</th>
            <th scope="col">Department</th>
            <th scope="col">Resource Name</th>
            <th scope="col">Resource Owner</th>
            <th scope="col">Item Description</th>
            <th scope="col">Disbursement Code</th>
            <th scope="col">Environment</th>
        </tr>
        </thead>
        <tbody>
                <c:forEach var="resource" items="${wasteByPercent}" varStatus="loop">
            <tr>
                <td scope="row">${loop.index + 1}</td>
                <td><a href="/graph_of_resource/${resource.resource.resourceId}">${resource.resource.resourceId}</a></td>
                <td>${Math.floor(wasteByPercent[loop.index].getRecommendationSavings()*10)/100}</td>
                <td>${wasteByPercent[loop.index].getRecommendationSavingsPct()}</td>
                <td>${resource.resource.applicationId}</td>
                <td><a href="/graph_of_app/${resource.resource.applicationName}">${resource.resource.applicationName}</a></td>
<%--                <td>${resource.applicationOwner}</td>--%>
                <td>${resource.resource.accountId}</td>
                <td>${resource.resource.accountName}</td>
                <td><a href="/graph_of_dept/${resource.resource.department}">${resource.resource.department}</a></td>
                <td>${resource.resource.resourceName}</td>
                <td><a href="/graph_of_owner/${resource.resource.resourceOwner}">${resource.resource.resourceOwner}</a></td>
                <td>${resource.resource.itemDescription}</td>
                <td>${resource.resource.disbursementCode}</td>
                <td>${resource.resource.environment}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
