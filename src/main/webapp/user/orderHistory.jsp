<%@ include file="/WEB-INF/parts/imports.jsp"%>
<jsp:include page="../WEB-INF/parts/header.jsp"/>
<section class="page-wrapper container">
    <div>
        <p><fmt:message key="message.history"/></p>

    </div>
    <div>
        <c:if test="${not empty success}">
            <fmt:message key="message.success"/>
        </c:if>
        <c:choose>
        <c:when test="${empty details}">
            <p><fmt:message key="message.noorders"/></p>
        </c:when>
        <c:otherwise>

        <table class="table">
            <thead>
            <tr>
                <td class="col-lg-2"><b><fmt:message key="message.initial"/></b></td>
                <td class="col-lg-2"><b><fmt:message key="message.dest"/></b></td>
                <td class="col-lg-2"><b><fmt:message key="message.cartype"/></b></td>
                <td class="col-lg-2"><b><fmt:message key="message.make"/></b></td>
                <td class="col-lg-2"><b><fmt:message key="message.time"/></b></td>
                <td class="col-lg-2"><b><fmt:message key="message.price"/></b></td>


            </tr>
            </thead>
            <tbody>


                    <c:forEach var="d" items="${details}">
                        <tr>
                            <td>
                                    ${d.initPlace}
                            </td>
                            <td>
                                    ${d.destPlace}
                            </td>
                            <td>
                                    ${d.carType}
                            </td>
                            <td>
                                    ${d.carMake}
                            </td>
                            <td>
                                    ${d.time}
                            </td>
                            <td>
                                    ${d.price}
                            </td>

                        </tr>
                    </c:forEach>
            </tbody>
        </table>
                </c:otherwise>
            </c:choose>





    </div>
    <div>
        <a href="${pageContext.request.contextPath}/user/home"><fmt:message key="message.home"/> </a>
    </div>
</section>
<jsp:include page="../WEB-INF/parts/footer.jsp"/>