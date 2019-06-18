<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../WEB-INF/parts/imports.jsp" %>

<jsp:include page="../WEB-INF/parts/header.jsp"/>
<section class="page-wrapper container">
    <div class="container">
        <div>
            <p><fmt:message key="message.clients"/></p>

        </div>
        <div>

            <table class="table">
                <thead>
                <tr>
                    <td class="col-lg-2"><b><fmt:message key="message.login"/></b></td>
                    <td class="col-lg-2"><b><fmt:message key="message.socialstatus"/></b></td>
                    <td class="col-lg-2"><b><fmt:message key="message.numrides"/></b></td>
                    <td class="col-lg-2"><b><fmt:message key="message.totalspent"/></b></td>
                    <td class="col-lg-2"><b><fmt:message key="message.time"/></b></td>
                    <td class="col-lg-2"><b><fmt:message key="message.mostcommon"/></b></td>
                </tr>
                </thead>
                <tbody>
<c:forEach items="${clients}" var="d">
    <tr>
        <td>
                ${d.login}
        </td>
        <td>
                ${d.socialStatus}
        </td>
        <td>
                ${d.numRides}
        </td>
        <td>
            <c:if test="${not empty d.totalSpentValue}">
                ${d.totalSpentValue}
            </c:if>
            <c:if test="${empty d.totalSpentValue}">
                0
            </c:if>




        </td>
        <td>
            <c:if test="${not empty d.totalTime}">
                ${d.totalTime}
            </c:if>
            <c:if test="${empty d.totalTime}">
                0
            </c:if>
        </td>
        <td>
            <c:if test="${not empty d.mostCommonCarType}">
                ${d.mostCommonCarType}
            </c:if>
            <c:if test="${empty d.mostCommonCarType}">
                -
            </c:if>
        </td>

    </tr>


</c:forEach>





                </tbody>
            </table>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/admin/home"><fmt:message key="message.home"/> </a>
    </div>

</section>
<jsp:include page="../WEB-INF/parts/footer.jsp"/>