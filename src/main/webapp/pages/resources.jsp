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
            <a class="nav-item nav-link active" href="#">Resources <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/resources-data">Resources Data</a>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="mt-5">Resources</h1>
    <table class="table table-striped table-hover table-sm table-responsive" style="max-width: 100%">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Id</th>
            <th scope="col">applicationId</th>
            <th scope="col">applicationName</th>
<%--            <th scope="col">applicationOwner</th>--%>
            <th scope="col">accountId</th>
            <th scope="col">accountName</th>
            <th scope="col">department</th>
            <th scope="col">resourceName</th>
            <th scope="col">resourceOwner</th>
            <th scope="col">itemDescription</th>
            <th scope="col">powerOnAt</th>
            <th scope="col">shutdownAt</th>
            <th scope="col">disbursementCode</th>
            <th scope="col">environment</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="resource" items="${resources}" varStatus="loop">
            <tr>
                <td scope="row">${loop.index + 1}</td>
                <td><a href="/resources/${resource.resourceId}">${resource.resourceId}</a></td>
                <td>${resource.applicationId}</td>
                <td>${resource.applicationName}</td>
<%--                <td>${resource.applicationOwner}</td>--%>
                <td>${resource.accountId}</td>
                <td>${resource.accountName}</td>
                <td>${resource.department}</td>
                <td>${resource.resourceName}</td>
                <td>${resource.resourceOwner}</td>
                <td>${resource.itemDescription}</td>
                <td>${resource.powerOnAt}</td>
                <td>${resource.shutdownAt}</td>
                <td>${resource.disbursementCode}</td>
                <td>${resource.environment}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
