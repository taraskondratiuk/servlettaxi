<%@ include file="../WEB-INF/parts/imports.jsp" %>

<jsp:include page="../WEB-INF/parts/header.jsp"/>
<section class="page-wrapper container">
    <div class="container">
        <div class="row">
            <div class="col-lg-offset-2 col-lg-8 ">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-lg-5 ">

                            <div class="img-rounded img-responsive profile-img">

                            </div>

                        </div>
                        <div class="col-lg-offset-1 col-lg-6">
                            <br />
                            <h4>
                                ${client.login}</h4>
                            <br />
                            <p>
                                <fmt:message key="message.role"/> : ${client.role}
                                <br />
                                <fmt:message key="message.totalspent"/> : ${client.totalSpentValue}
                                <br />
                                <fmt:message key="message.personaldiscount"/> : ${client.personalDiscount}%
                                <br />
                                <fmt:message key="message.specialdiscount"/> : ${specialDiscount}%
                                <br />
                                <fmt:message key="message.socialstatus"/> : ${client.socialStatus}
                                <br />
                                <fmt:message key="message.orders"/> : ${numOrders}</p>

                            <!-- Split button -->

                        </div>
                    </div>
                </div>
                <c:if test="${not empty cancel}">
                    cancel
                </c:if>
                <c:if test="${not empty success}">
                    success
                </c:if>
                <br/>

                <a href="${pageContext.request.contextPath}/user/order"><fmt:message key="message.order"/> </a>
                <a href="${pageContext.request.contextPath}/user/history"><fmt:message key="message.history"/></a>
                <a href="${pageContext.request.contextPath}/user/changepw"><fmt:message key="message.changepw"/></a>
            </div>

        </div>
    </div>


</section>
<jsp:include page="../WEB-INF/parts/footer.jsp"/>