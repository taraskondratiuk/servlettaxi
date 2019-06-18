<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
    <%@ include file="/static/css/bootstrap.css" %>
    <%@ include file="/static/css/style.css" %>
</style>
<fmt:setLocale value="${localeLang}"/>
<fmt:setBundle basename="properties/messages"/>

<!DOCTYPE html>
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
                <%-- <img class="logo-img" src="static/sources/taxi-logo.png" alt="logo">--%>
            </div>
            <div class="head_info col-lg-8">
                <h1><fmt:message key="message.taxi"/></h1>
            </div>
            <div class="col-lg-2 langs">
                <div class="  lang-images">
                    <%-- <input type="image" src="static/sources/ua-flag.png" alt="UA" onclick="switchUA();"/>
                     <input type="image" src="static/sources/us-flag.png" alt="US" onclick="switchUS();"/>--%>
                </div>
                <a href="/logout">
                    <button type="button" class="btn btn-info btn-sm logout-button"><fmt:message
                            key="message.logout"/></button>
                </a>
            </div>
        </div>
    </header>
</section>

<section class="page-wrapper container">

    <h3>reg page</h3>



    <c:if test="${not empty error}">
        error
    </c:if>

    <c:if test="${not empty success}">
        success
    </c:if>

    <div ng-app="ngpatternApp" ng-controller="ngpatternCtrl">



        <form action="${pageContext.request.contextPath}/register" method="post" id="loginForm" name="loginForm" ng-submit="loginForm.$valid && eventCtl." novalidate >

            <label> User Name : <input type="text" name="username" ng-model="txtlogin" ng-pattern="/^[A-Za-z0-9]{4,15}$/" required /></label>

            <span style="color:Red" ng-show="loginForm.username.$touched&&loginForm.username.$error.required"> Required! </span>

            <span style="color:Red" ng-show="loginForm.username.$touched&&loginForm.username.$error.pattern">Wrong login</span>

            <br /><br />
            <label> Password : <input type="password" name="password" ng-model="txtpw" ng-pattern="/^[A-Za-z0-9]{6,15}$/" required /></label>

            <span style="color:Red" ng-show="loginForm.password.$touched&&loginForm.password.$error.required"> Required! </span>

            <span style="color:Red" ng-show="loginForm.password.$touched&&loginForm.password.$error.pattern">Wrong pw</span>

            <br /><br />
            <div><label> Social Status : <select name="socialStatus">
                <c:forEach items="${statuses}" var="s">

                <option>
                    ${s}
                </option>
                </c:forEach>
                </select></label></div>
            <br/>

            <button  ng-disabled="loginForm.username.$invalid || loginForm.password.$invalid" >Submit Form</button><br /><br />



        </form>

    </div>

</section>
<footer class="footer">
    <div class="foot container">
        <div class="footer_info col-lg-2 ">
            <ul>
                <li><b><fmt:message key="message.address"/></b></li>
                <li><fmt:message key="message.kyiv"/></li>
                <li><fmt:message key="message.street"/></li>
            </ul>
        </div>
        <div class="footer_info col-lg-push-1 col-lg-2 ">
            <ul>
                <li><b><fmt:message key="message.cont"/></b></li>
                <li><fmt:message key="message.phone1"/></li>
                <li><fmt:message key="message.phone2"/></li>
            </ul>
        </div>
        <div class="footer_info col-lg-push-2 col-lg-2 ">
            <ul>
                <li><b><fmt:message key="message.sponsors"/></b></li>
                <li><fmt:message key="message.sponsor1"/></li>
                <li><fmt:message key="message.sponsor2"/></li>
            </ul>
        </div>
        <div class="footer_info col-lg-push-3 col-lg-3 ">
            <ul>

                <li><b><fmt:message key="message.inc"/></b></li>
                <li><b><fmt:message key="message.allrr"/></b></li>
            </ul>
        </div>
    </div>
</footer>
</body>
</html>