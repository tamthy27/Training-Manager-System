<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
	
<body class="fixed-left">
	<!-- Begin page -->
	<div id="wrapper">
		<!-- Top Bar Start -->
		<div class="topbar">

			<!-- LOGO -->
			<div class="topbar-left">
				<a href="${home}home" class="logo"><span><spring:message code="Logo" /> </span><i
					class="zmdi zmdi-layers"></i></a>
			</div>

			<!-- Button mobile view to collapse sidebar menu -->
			<div class="navbar navbar-default" role="navigation">
				<div class="container">
					<!-- Page title -->
					<ul class="nav navbar-nav navbar-left">
						<li>
							<button class="button-menu-mobile open-left">
								<i class="zmdi zmdi-menu"></i>
							</button>
						</li>
						<li>
							<h4 class="page-title"> Welcome to Training Management System!
								<span    style="color: #0075b5" data-toggle="tooltip" data-placement="bottom" 
								title='${category.description}'>${category.name}</span>
							</h4>
						</li>
					</ul>
					
				</div>
				<!-- end container -->
				
			</div>
			<!-- end navbar -->
		</div>
		<!-- Top Bar End -->

		<!-- ========== Left Sidebar Start ========== -->
		<%-- <c:set var="user" value="${pageContext.request.userPrincipal.user.username}" /> --%>
			<%@ include file="include/slidebar.jsp"%>
		<!-- Left Sidebar End -->

		<div class="row">
			<!-- ============================================================== -->
			<!-- Start Table here -->
			<!-- ============================================================== -->
			<div class="col-sm-8">
				<div class="content-page">
					<!-- Start content -->
					<div class="content">
						<div class="container">

							<div class="row" id="listCourse">
								<div class="col-sm-12">
									<div class="panel panel-left">
										

									</div>
									<!-- end panel -->
								</div>
								<!-- end col-->
							</div>
							<!-- end row -->
							
						</div>
						<!-- container -->

					</div>
					<!-- content -->

				</div>
			</div>
		</div>
		<!-- END RIGHT CONTENT -->
		<footer class="footer"> 2017 © FSOFT GST. </footer>

		
	</div>
	<!-- END wrapper -->

	<script>
		var resizefunc = [];
	</script>

	<!-- jQuery -->
	<%@ include file="include/js.jsp" %>

	
		
</body>
</html>