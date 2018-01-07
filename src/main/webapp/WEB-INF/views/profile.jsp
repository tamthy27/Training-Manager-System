<%@page import="com.fsoft.gst.ptithcm.tms.model.ProfileUser"%>
<%@page import="com.fsoft.gst.ptithcm.tms.model.CustomUserDetails"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="com.fsoft.gst.ptithcm.tms.model.Users"%>
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
				<a href="${home}home" class="logo"><span><spring:message
							code="Logo" /> </span><i class="zmdi zmdi-layers"></i></a>
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
							<h4 class="page-title">Profile</h4>
						</li>
					</ul>
				</div>
				<!-- end container -->

			</div>
			<!-- end navbar -->
		</div>
		<!-- Top Bar End -->

		<%@ include file="include/slidebar.jsp"%>
		<div class="row">
			<!-- ============================================================== -->
			<!-- Start Information here -->
			<!-- ============================================================== -->
			<div class="col-sm-12">
				<!-- Start content -->
				<div class="content hidden" id="rightContent">
					<div class="container">
						<div class="row" id="profileContent">
							<div class="col-sm-4"></div>
							<div class="col-sm-3">
								<div class="panel-body "
									style="height: 100%; width: 100%; padding-top: 100px">
									<div class="row ">
										<div style="padding-right: 140px">
											<img
												src="<c:url value = '/static/images/users/avartar.jpg' />"
												class="img-responsive img-circle" style="width: 250px"
												id="profile-Avatar">
											<div
												style="width: 150px; padding-top: 40px; padding-left: 1%">
												<label class="lbl-info-title">User Name :</label> <label
													class=" lbl-info-detail" id="profile-UserName">${pageContext.request.userPrincipal.name}</label>
											</div>
										</div>
										<div class="col-md-4"></div>
									</div>
									<br>
									<div class="row hidden">
										<label class="" id="profile-ID"></label>
									</div>

								</div>
								<!-- end: panel body -->
							<c:set var="profile" value="${user.getProfileUsers()}" />
								<!-- end panel -->
							</div>
							<div class="col-sm-5">
								<div class="panel panel-right" style="height: 550px">
									<div class="panel-body " style="height: 100%">
										<div class="row hidden">
											<label class="" id="profile-ID">${user.id}</label>
										</div>
										<c:forEach var="profileUser" items="${profile}">
											<div class="row ">
												<c:if test="${profileUser.profile.name == 'FirstName'}">
													<label class="col-md-3 lbl-info-title">First Name</label>
													<label class="col-md-1 lbl-info-title">:</label>
													<label class="col-md-8 lbl-info-detail"
														id="profile-FirstName"> ${profileUser.value} </label>
												</c:if>
											</div>
										</c:forEach>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Last Name</label> <label
												class="col-md-1 lbl-info-title">:</label>đâsa <label
												class="col-md-8 lbl-info-detail" id="profile-LastName"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Email</label> <label
												class="col-md-1 lbl-info-title">:</label>ádasdasd <label
												class="col-md-8 lbl-info-detail" id="profile-Email"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Birthday</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-Birthday"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Phone Number</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-PhoneNumber"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Education</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-Education"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Programming
												Language</label> <label class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-Programming"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">TOIEC Score</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-TOIEC"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Experience
												Detail</label> <label class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-Experience"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Department
												Location</label> <label class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-Department"></label>
										</div>
										<button
											class="btn btn-info btn-right  waves-effect waves-light"
											id="buttonEdit">
											<i class="fa fa-pencil"></i>
											<spring:message code="Button.Edit" />
										</button>
									</div>
									<!-- end: panel body -->

								</div>
								<!-- end panel -->
							</div>
						</div>
					</div>
					<!-- container -->
				</div>
				<!-- END content -->
			</div>

		</div>
		<!-- END RIGHT CONTENT -->
		<footer class="footer"> 2017 © FSOFT GST. </footer>

		<!-- MODAL PROFILE -->
		<div class="modal fade modalDS-bg " id="dialogProfile" role="dialog"
			data-keyboard="false" data-backdrop="static">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content modalDS-content">
					<div class="modal-header modalDS-header">
						<button type="button" class="close cancel-EditProfile"
							data-dismiss="modal">&times;</button>
						<h2 class="panel-title modalDS-h2-header">Edit</h2>
					</div>
					<div class="modal-body modalDS-body">
						<form class="form-horizontal group-border-dashed" action="#">
							<h3 style="text-align: center" id="profile-UserName"
								class="edit-trainer"></h3>
							<div class="form-group edit-trainee">
								<label class="col-sm-3 control-label lbl-left">User Name
									*</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" required
										placeholder="EnterUser Name..." id="inputProfile-UserName" />
								</div>
							</div>
							<hr>
							<div class="form-group hidden ">
								<input type="text" class="form-control" value=""
									id="inputProfile-ID" />
							</div>
							<div class="form-group edit-trainee ">
								<label class="col-sm-3 control-label lbl-left">First
									Name *</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" required
										placeholder="Enter First Name..." id="inputProfile-FirstName" />
								</div>
							</div>
							<div class="form-group edit-trainee ">
								<label class="col-sm-3 control-label lbl-left">Last Name
									*</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" required
										placeholder="Enter Last Name..." id="inputProfile-LastName" />
								</div>
							</div>
							<div class="form-group edit-trainee ">
								<label class="col-sm-3 control-label lbl-left">Email *</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" parsley-type="email"
										value="" required placeholder="Enter a e-mail..."
										id="inputProfile-Email" />
								</div>
							</div>
							<div class="form-group edit-trainee ">
								<label class="col-sm-3 control-label lbl-left">Birthday
									*</label>
								<div class="col-sm-8">
									<input type="text" placeholder="dd/mm/yyyy" required
										data-mask="99/99/9999" class="form-control"
										id="inputProfile-Birthday">
								</div>

							</div>
							<div class="form-group edit-trainee ">
								<label class="col-sm-3 control-label lbl-left">Phone
									Number *</label>
								<div class="col-sm-8">
									<input data-parsley-type="digits" type="text" required
										data-parsley-minlength="10" class="form-control" value=""
										placeholder="Enter only digits..."
										id="inputProfile-PhoneNumber" />
								</div>
							</div>

							<div class="form-group edit-trainee ">
								<label class="col-sm-3 control-label lbl-left">Education</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value=""
										placeholder="Enter Education..." id="inputProfile-Education" />
								</div>
							</div>
							<div class="form-group edit-trainee">
								<label class="col-sm-3 control-label lbl-left">Programming
									Language</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value=""
										placeholder="Enter Programming Language..."
										id="inputProfile-Programming" />
								</div>
							</div>

							<div class="form-group edit-trainee">
								<label class="col-sm-3 control-label lbl-left">TOIEC
									Score</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value=""
										data-parsley-max="990" placeholder="Enter TOIEC Score..."
										id="inputProfile-TOIEC" />
								</div>
							</div>
							<div class="form-group edit-trainee">
								<label class="col-sm-3 control-label lbl-left">Experience
									Detail</label>
								<div class="col-sm-8">
									<textarea class="form-control" data-parsley-id="50" value=""
										placeholder="Enter Experience Detail..."
										id="inputProfile-Experience"></textarea>
								</div>
							</div>

							<div class="form-group edit-trainee">
								<label class="col-sm-3 control-label lbl-left">Department
									Location</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value=""
										placeholder="Enter Department Location..."
										id="inputProfile-Department" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-8 col-sm-4 m-t-15">
									<button type="submit"
										class="btn btn-primary waves-effect waves-light"
										id="modalSave">Save</button>
									<button type="button"
										class="btn btn-default cancel-EditProfile">Cancel</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
		<!-- end Modal Profile-->

		<!-- MODAL ADD TOPIC -->
		<script>
			var resizefunc = [];
		</script>
		<!-- jQuery -->
		<%@ include file="include/js.jsp"%>

		<!-- init -->
		<script src="<c:url value = '/static/pages/staff_trainee.js' />"></script>
		<script
			src="<c:url value = '/static/plugins/datatables/jquery.dataTables.min.js' />"></script>
		<script
			src="<c:url value = '/static/plugins/datatables/dataTables.bootstrap.js' />"></script>
		<script
			src="<c:url value = '/static/plugins/datatables/dataTables.buttons.min.js' />"></script>
		<script
			src="<c:url value = '/static/plugins/datatables/buttons.bootstrap.min.js' />"></script>
		<script
			src="<c:url value = '/static/plugins/datatables/jszip.min.js' />"></script>
		<script
			src="<c:url value = '/static/plugins/datatables/pdfmake.min.js' />"></script>
		<script
			src="<c:url value = '/static/plugins/datatables/vfs_fonts.js' />"></script>
		<script
			src="<c:url value = '/static/plugins/datatables/buttons.html5.min.js' />"></script>
		<script
			src="<c:url value = '/static/plugins/datatables/buttons.print.min.js' />"></script>

		<script
			src="<c:url value = '/static/plugins/datatables/dataTables.fixedHeader.min.js' />"></script>
		<script
			src="<c:url value = '/static/plugins/datatables/dataTables.scroller.min.js' />"></script>
		<!-- Datatable init js -->
		<script src="<c:url value = '/static/pages/datatables.init.js' />"></script>
</body>
</html>