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
							<h4 class="page-title">Manage Staff Account</h4>
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

		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<!-- ============================================================== -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="container">

					<div class="row">
						<div class="col-lg-12">

									<div class="card-box1">
										<div id="calendar"></div>
									</div>

						</div>
						<!-- end col-12 -->
					</div>
					<!-- end row -->

				</div>
				<!-- container -->

			</div>
			<!-- content -->

			<footer class="footer"> 2017 © FSOFT GST. </footer>

		</div>


		<!-- ============================================================== -->
		<!-- End Right content here -->
		<!-- ============================================================== -->
	</div>
	<!-- END wrapper -->

		<script>
			var resizefunc = [];
		</script>
	<!-- jQuery -->
		<%@ include file="include/js.jsp" %>

	<!-- BEGIN PAGE SCRIPTS -->
	<script src="<c:url value = '/static/plugins/fullcalendar/dist/fullcalendar.min.js' />"></script>
	<script src="<c:url value = '/static/plugins/moment/moment.js' />"></script>
	
	<!-- Modal-Effect -->
	<script src="<c:url value = '/static/plugins/custombox/dist/custombox.min.js' />"></script>
	<script src="<c:url value = '/static/plugins/custombox/dist/legacy.min.js' />"></script>
	
	<!-- init -->
	<script src="<c:url value = '/static/pages/trainer_calendar.js' />"></script>

</body>
</html>