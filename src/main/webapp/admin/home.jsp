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


                            <!-- Split button -->

                        </div>
                    </div>
                </div>

                <br/>

                <a href="${pageContext.request.contextPath}/admin/cars"><fmt:message key="message.cars"/> </a>
                <a href="${pageContext.request.contextPath}/admin/clients"><fmt:message key="message.clients"/></a>
                <a href="${pageContext.request.contextPath}/admin/changepw"><fmt:message key="message.changepw"/></a>
            </div>

        </div>
    </div>


</section>
<jsp:include page="../WEB-INF/parts/footer.jsp"/>