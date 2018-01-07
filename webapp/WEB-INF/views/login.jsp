<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "include/header.jsp" %>
<body>

	<div class="clearfix"></div>
	<div class="wrapper-page">
		<div class="text-center">
			<a href="#" class="logo"><span><spring:message code="Logo" /></span></a>
			<p class="text-muted m-t-0 "><spring:message code="Login.Welcome-text" /></p>
		</div>
		
		<div class=" c">
			<div class="panel-body">
						<c:if test="${param.error == 'true'}">
							<div class="form-group m-b-30 " >
								<div class="text-center box-error p-20 p-b-10"  >
									
									<p><i class="zmdi zmdi-close-circle"></i>
										<spring:message code="Login.failed" />
									</p>
								</div>
							</div>
						</c:if>
				<!-- Form login -->
				<form class="form-horizontal m-t-10" action="${home}/j_spring_security_check"  method="POST" >
			
						<div class="form-group ">
							<div class="col-xs-12">
								<input class="form-control input-lg" type="text" name="username" required placeholder="Username"
									value="${sessionScope.LAST_USERNAME}" >
							</div>
						</div>
		
						<div class="form-group">
							<div class="col-xs-12">
								<input class="form-control input-lg" type="password" name="password" required placeholder="Password">
							</div>
						</div>
	
						<div class="form-group text-center m-t-30">
							<div class="col-xs-12">
								<button
									class="btn btn-custom  btn-bordred btn-lg btn-block waves-effect waves-light" 
									  type="submit"> <spring:message code="Login.button-login" />
								</button>
							</div>
						</div>
					
					
					<div class="form-group m-t-10 m-b-0">
						<div class="col-sm-12">
							<a href="page-recoverpw.html" class="text-muted"><i
								class="fa fa-lock m-r-5"></i><spring:message code="Login.Forgot-your-password" /></a>
						</div>
					</div>
				</form>
				<!-- End Form login -->

			</div>
		</div>
		<!-- end card-box-->
		
		
		
		
	</div>
	
	<footer class="footer-login navbar-fixed-bottom"> 2017 © FSOFT GST. </footer>
	
	
	<script>
		var resizefunc = [];
	</script>

	<%@include file = "include/js.jsp" %>
	
</body>
</html>