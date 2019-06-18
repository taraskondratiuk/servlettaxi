
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../WEB-INF/parts/imports.jsp" %>

<jsp:include page="../WEB-INF/parts/header.jsp"/>
<section class="page-wrapper container">
    <div class="container">
        <div>
            <p><fmt:message key="message.cars"/> </p>

        </div>
        <div>

            <table class="table">
                <thead>
                <tr>
                    <td class="col-lg-2"><b><fmt:message key="message.id"/> </b></td>
                    <td class="col-lg-2"><b><fmt:message key="message.make"/> </b></td>
                    <td class="col-lg-2"><b><fmt:message key="message.cartype"/> </b></td>
                    <td class="col-lg-2"><b><fmt:message key="message.numrides"/> </b></td>
                    <td class="col-lg-2"><b><fmt:message key="message.totalearned"/> </b></td>
                    <td class="col-lg-2"><b><fmt:message key="message.totaltime"/> </b></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="d" items="${cars}">
                    <tr>
                        <td>
                                ${d.id}
                        </td>
                        <td>
                                ${d.carMake}
                        </td>
                        <td>
                                ${d.carType}
                        </td>
                        <td>
                                ${d.numRides}
                        </td>
                        <td>
                            <c:if test="${not empty d.totalEarned}">
                                ${d.totalEarned}
                            </c:if>
                            <c:if test="${empty d.totalEarned}">
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

                    </tr>

                </c:forEach>



                </tbody>
            </table>



        </div>

        <div>
            <a href="/admin/home">${rca.getMessage("message.home")}</a>
        </div>
    </div>


</section>
<jsp:include page="../WEB-INF/parts/footer.jsp"/>
