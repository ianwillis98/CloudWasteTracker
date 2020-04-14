<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
            <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/vendors">Vendors</a>
            <a class="nav-item nav-link" href="/resources">Resources</a>
            <a class="nav-item nav-link" href="/resources-data">Resources Data</a>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="display-3 text-center" style="color:#0071bf;">
        <strong>Cloud Waste Tracker</strong>
    </h1>
    <img class="mx-auto d-block" alt="Nationwide logo" src="pages/nationwide.png">
    <p>
        <strong>Team Members:</strong> Ian, Tim, Tony, Kacey
    </p>
    <p>
        <strong>Course:</strong> CSE 5915
    </p>
    <p>
        <strong>Sponsor:</strong> Nationwide</p>
    <h1>
        Project description:
    </h1>
    <p>
        Managing an enterprise public cloud account in a financially accountable way can be a challenge as environments
        scale.
        This project would develop a solution that would identify resources that are materially underutilized, track
        them
        over time and create alerts and reports to track the amount of potential wasted spend the resource is
        generating.
        The goal of this would be to promote the visibility of underutilized resources that generate spend and promote
        efficiency opportunities.
    </p>
</div>

</body>
</html>