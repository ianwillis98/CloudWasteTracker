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
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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
    <table data-toggle="table" data-search="true" data-pagination="true" class="table table-striped table-hover table-sm table-responsive" style="max-width: 100%">
        <thead>
        <tr>
            <th data-sortable="true" scope="col">Wasted EC2 Spend(%)</th>
            <th data-sortable="true" scope="col">Wasted EC2 Spend($)</th>
            <th data-sortable="true" scope="col">Resource Id</th>
            <th data-sortable="true" scope="col">Application Name</th>
<%--            <th scope="col">applicationOwner</th>--%>
            <th data-sortable="true" scope="col">Department</th>
            <th data-sortable="true" scope="col">Resource Owner</th>
            <th data-sortable="true" scope="col">Resource Name</th>
            <th data-sortable="true" scope="col">Application Id</th>
            <th data-sortable="true" scope="col">Account Id</th>
            <th data-sortable="true" scope="col">Account Name</th>
            <th data-sortable="true" scope="col">Item Description</th>
            <th data-sortable="true" scope="col">Disbursement Code</th>
            <th data-sortable="true" scope="col">Environment</th>
        </tr>
        </thead>
        <tbody>
                <c:forEach var="resource" items="${wasteByPercent}" varStatus="loop">
            <tr>
                <td>${wasteByPercent[loop.index].getRecommendationSavingsPct()}%</td>
                <td>$${Math.floor(wasteByPercent[loop.index].getRecommendationSavings()*10)/100}</td>
                <td><a href="/graph_of_resource/${resource.resource.resourceId}">${resource.resource.resourceId}</a></td>
                <td><a href="/graph_of_app/${resource.resource.applicationName}">${resource.resource.applicationName}</a></td>
                <td><a href="/graph_of_dept/${resource.resource.department}">${resource.resource.department}</a></td>
                <td><a href="/graph_of_owner/${resource.resource.resourceOwner}">${resource.resource.resourceOwner}</a></td>
                <td>${resource.resource.resourceName}</td>  
<%--                <td>${resource.applicationOwner}</td>--%>
                <td>${resource.resource.applicationId}</td>
                <td>${resource.resource.accountId}</td>
                <td>${resource.resource.accountName}</td>                
                <td>${resource.resource.itemDescription}</td>
                <td>${resource.resource.disbursementCode}</td>
                <td>${resource.resource.environment}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
</body>
</html>
