<%@ include file="imports.jsp" %>
<style>
    <%@ include file="/static/css/bootstrap.css" %>
    <%@ include file="/static/css/style.css" %>

</style>
<html>
<head>
    <title>Taxi</title>



    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

</head>
<body>

<section class="section-1 head_wrapper">
    <header class="header container">
        <div class="headline row ">
            <div class="logo col-lg-2">
               <%-- <img class="logo-img" src="../static/sources/taxi-logo.png" alt="logo">--%>
            </div>
            <div class="head_info col-lg-8">
                <h1><fmt:message key="message.taxi"/></h1>
            </div>
            <div class = "col-lg-2 langs">
                <div class="  lang-images">
<%--                    <input type="image" src="../static/sources/ua-flag.png" alt="UA" onclick="switchUA();" />--%>
<%--                    <input type="image" src="../static/sources/us-flag.png" alt="US" onclick="switchUS();" />--%>
                </div>
                <a href="/logout"><button type="button" class="btn btn-info btn-sm logout-button"><fmt:message key="message.logout"/></button></a>
            </div>
        </div>
    </header>
</section>
