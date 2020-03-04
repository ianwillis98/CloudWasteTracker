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
            <a class="nav-item nav-link active" href="#">Vendors <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/resources">Resources</a>
            <a class="nav-item nav-link" href="/resources-data">Resources Data</a>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="mt-5">Vendors</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Key</th>
            <th scope="col">Label</th>
            <th scope="col">Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="vendor" items="${vendors}" varStatus="loop">
            <tr>
                <td scope="row">${loop.index + 1}</td>
                <td>${vendor.vendorKey}</td>
                <td>${vendor.vendorLabel}</td>
                <td>${vendor.vendorDescription}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>