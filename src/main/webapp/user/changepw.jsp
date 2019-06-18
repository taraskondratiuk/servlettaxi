<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../WEB-INF/parts/imports.jsp" %>

<jsp:include page="../WEB-INF/parts/header.jsp"/>
<section class="page-wrapper container">
    <div class="container">
        <c:if test="${not empty error}" >

        error
        </c:if>
    <c:if test="${not empty pwchanged}">
    changed
    </c:if>
<div ng-app="ngpatternApp" ng-controller="ngpatternCtrl">
    <form action="${pageContext.request.contextPath}/user/changepw" method="post" name="changeForm" novalidate >

        <label>old password : <input type="password" name="oldpassword" ng-model="oldpw" ng-pattern="/^[A-Za-z0-9]{6,15}$/" required /></label>

        <span style="color:Red" ng-show="changeForm.oldpassword.$touched&&changeForm.oldpassword.$error.required"> Required! </span>

        <span style="color:Red" ng-show="changeForm.oldpassword.$touched&&changeForm.oldpassword.$error.pattern">Wrong pw</span>



        <br /><br />
        <label>new password : <input type="password" name="newpassword" ng-model="newpw" compare-to="oldpw" ng-pattern="/^[A-Za-z0-9]{6,15}$/" required /></label>

        <span style="color:Red" ng-show="changeForm.newpassword.$touched&&changeForm.newpassword.$error.required"> Required! </span>

        <span style="color:Red" ng-show="changeForm.newpassword.$touched&&changeForm.newpassword.$error.pattern">Wrong pw</span>



        <br /><br />

        <br/>
        <input ng-disabled="changeForm.oldpassword.$invalid || changeForm.newpassword.$invalid " type="submit" value="<ftm:message key="message.submit"/>"/><br /><br />



    </form>
</div>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/user/home"><fmt:message key="message.home"/> </a>
    </div>

</section>
<jsp:include page="../WEB-INF/parts/footer.jsp"/>