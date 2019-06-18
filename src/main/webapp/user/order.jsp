<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/parts/imports.jsp" %>
<jsp:include page="/WEB-INF/parts/header.jsp"/>
<section class="container page-wrapper">
<c:choose>
    <c:when test="${empty cars && empty car}">
        <div><h3><ftm:message key="message.discount"/> : ${discount}%</h3></div>
        <div ng-app="selectboxApp" ng-controller="selectboxCtrl">
            <form action="${pageContext.request.contextPath}/user/order" method="post">
                <div>
                    <label> <ftm:message key="message.initial"/> <select name="initPlace" required ng-model="placeStart">
                        <option value="">choose 1 street</option>
                        <c:forEach var="s" items="${streets}">
                            <option value="${s}">
                                    ${s}
                            </option>
                        </c:forEach>

                        </select></label></div>

                    <div>
                        <label> <ftm:message key="message.dest"/> <select name="destPlace" required ng-model="placeEnd">
                            <option value="">choose 2 street</option>
                            <c:forEach items="${streets}" var="s">
                                <option value="${s}">
                                        ${s}
                                </option>
                            </c:forEach>

                            </select></label></div>
                    <div>
                        <label> <ftm:message key="message.type"/> <select name="carType" required ng-model="typeCar">
                            <option value="">type</option>
                            <c:forEach items="${types}" var="t">
                                <option value="${t}">
                                        ${t}
                                </option>
                            </c:forEach>
                            </select></label></div>

                    <div>
                        <input type="submit" id="mysubmit" value="<ftm:message key="message.confirm"/>"/>


                    </div>
            </form>

    </c:when>
    <c:when test="${not empty cars && empty car}">

        <form action="${pageContext.request.contextPath}/user/order" method="post">
            <div>
                <label> <ftm:message key="message.car"/> </label>
                <table class="table">
                    <thead>
                    <tr>
                        <td><b><ftm:message key="message.make"/></b></td>
                        <td><b><ftm:message key="message.place"/></b></td>
                        <td><b><ftm:message key="message.type"/></b></td>
                        <td hidden></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cars}" var="car">
                        <tr>
                            <td>
                                    ${car.make}
                            </td>
                            <td>
                                    ${car.place}
                            </td>
                            <td>
                                    ${car.type}
                            </td>

                            <td>
                                <input type="radio" name="carId" value="${car.idcars}"/>


                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>

            <input type="hidden" name="initPlace" value="${initPlace}"/>
            <input type="hidden" name="destPlace" value="${destPlace}"/>

            <input type="submit" value="<ftm:message key="message.choose"/>"/>
        </form>
    </c:when>
    <c:otherwise>

        <br>

        chosen car: ${car.type} ${car.make}
        order time: ${rideTime}
        price: ${price}
        w8 time: ${waitTime}

        <form action="${pageContext.request.contextPath}/user/history" method="post">
            <input type="hidden" name="carId" value="${car.idcars}"/>
            <input type="hidden" name="timeId" value="${timeId}"/>
            <input type="hidden" name="price" value="${price}"/>
            <input type="hidden" name="waitTime" value="${waitTime}"/>
            <input type="submit" value="<ftm:message key="message.confirm"/>"/>
        </form>
    </c:otherwise>

</c:choose>




<form action="${pageContext.request.contextPath}/user/home" method="get">

    <div>
        <input type="hidden" name="cancel" value="cancel"/>
        <input type="submit" value="<ftm:message key="message.cancel"/>"/>

    </div>
</form>
</section>
<jsp:include page="/WEB-INF/parts/footer.jsp"/>