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
				<a href="${home}" class="logo"><span><spring:message code="Logo" /> </span><i
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
							<h4 class="page-title">View List Trainee in Course
								<span    style="color: #0075b5" data-toggle="tooltip" data-placement="bottom" 
								title='${course.description}'>${course.name}</span>
							</h4>
							
						</li>
					</ul>
					<button class="btn btn-custom  btn-right disabled waves-effect waves-light" disabled id="buttonDelete">
						<i class="fa fa-times"  ></i><spring:message code="Button.Delete" /></button>
					<button class="btn btn-custom btn-right disabled waves-effect waves-light" disabled id="buttonEdit">
						<i class="fa fa-pencil"  ></i> <spring:message code="Button.Edit" /> </button>
					<button class="btn btn-custom btn-right waves-effect waves-light"  disabled id="buttonAdd"> 
						<i class="fa fa-plus"  ></i> <spring:message code="Button.Add" /> </button>
							
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
			<!-- Start Information here -->
			<!-- ============================================================== -->
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2">
				<div class="content-page">
				<!-- Start content -->
				<div class="content" >
					<div class="container">
						
						<div class="row" >
							<div class="col-sm-12">
								<div class="panel panel-right panel-left ">
									<div class="panel-body p-t-0"  >
										<div class="row view-header" data-toggle="tooltip" data-placement="bottom" 
													title='Show and hide information' >		
											<p class="b"><strong>Course information</strong></p>
										</div>
										<div class="view-body">
											<div class="row">
													<label class="col-md-3 lbl-info-title">Name:</label> 
													<%-- <label class="col-md-1 lbl-info-title">:</label>--%>
													<label class="col-md-8 lbl-in	fo-detail" id="profile-Name"> ${course.name}</label> 
													<h4 class="hidden" id="courseId">${course.courseId}</h4>
											</div>
											<div class="row">
												<label class="col-md-3 lbl-info-title">Date Start: </label> 
												<%-- <label class="col-md-1 lbl-info-title">:</label>--%>
												<label class="col-md-8 lbl-info-detail" id="profile-Start">${course.getStartDateString()}</label> 
											</div>
											<div class="row">
												<label class="col-md-3 lbl-info-title">Date End:</label>
												<%-- <label class="col-md-1 lbl-info-title">:</label>  --%>
												<label class="col-md-8 lbl-info-detail" id="profile-End">${course.getEndDateString()}</label>
											</div>
											<div class="row">
												<label class="col-md-3 lbl-info-title">Description:</label>
												<label class="col-md-8 lbl-info-detail" id="profile-Description">${course.description}</label>
											</div>
										</div>
									</div>
									<!-- end: panel body -->

								</div>
								<!-- end panel -->
							</div>
							<!-- end col-->
						</div>
						<!-- end row -->
						
						
					</div>
					<!-- container -->
				</div>
				</div>
				<!-- END content -->
			</div>
		</div>
		
		
		
		
		
		<div class="row">
			<!-- ============================================================== -->
			<!-- Start Table here -->
			<!-- ============================================================== -->
			
			<div class="col-sm-12">
				<div class="content-page">
					<!-- Start content -->
					<div class="content m-t-10">
						<div class="container">
						
						
							<div class="row" id="listTraineeInCourse">
						
							<!-- MANAGE TRAINEE -->
							<div class="col-sm-12" id="manageTrainee">
								<!-- ===========
								VIEW TRAINEE
								====== -->
								<div class="row viewTrainee panel-right panel-left">
									<div class="col-sm-12">
										<div class="panel ">
											<div class="panel-body p-t-0">
												
											<div class="row view-header" data-toggle="tooltip" data-placement="bottom" 
													title='Show and hide information' >		
												<p class="b"><strong>List Trainees in course</strong></p>
											</div>
											<!-- VIEW BODY -->
											<div class="view-body">
												<!-- SHOW ENTRY -->
												<div class="row m-t-10">
													<div class="col-sm-1 text-center">
														<a href="${home}course/list-course/${course.category.categoryId}" id="backToCourse"
															data-toggle="tooltip" data-placement="bottom" title='back to course'>
																<i class="fa fa-long-arrow-left fa-lg2 "></i></a>
													
													</div>
													<div class="col-sm-9">
															<button id="addTrainee" class="btn btn-primary waves-effect waves-light"
																style="margin-right: 10px;">
																<spring:message code="Button.Add" />  <i class="fa fa-plus"></i>
															</button>
															<button id="remove-alltrainee" class="btn btn-danger waves-effect waves-light"
																style="margin-right: 10px;">
																Remove All <i class="fa fa-times"></i>
															</button>
													</div>
													

												</div>
												<!-- end SHOW ENTRY -->

												<!-- TABLE -->
												<div class="m-t-20" >
													<table id="datatable-fixed-header" class="table table-bordered" >
														<thead>
															<tr>	
																<th class="hidden"></th>
																<th>Account</th>
																<th>First Name</th>
																<th>Last Name</th>
																<th>Birthday</th>
																<th>Phone</th>
																<th>Email</th>
																<th data-orderable="false"></th>
															</tr>
														</thead>
														<tbody id="table-delTrainee">
															<c:forEach var="trainee"  items="${listTrainee}">
																<tr class="part">
																	<td class="userId hidden">${trainee.users.id}</td>
																	<td class="userName">${trainee.users.username}</td>
																	
																	<c:set var="firstName" value="" />
																	<c:forEach var="profileUser" items="${trainee.users.profileUsers}" >								
																		<c:if test = "${profileUser.profile.name == 'FirstName'}">
																				<c:set var="firstName" value="${profileUser.value}" />
																		</c:if>
																	</c:forEach>
																	<td class="firstName">${firstName}</td>
																	
																	<c:set var="lastName" value="" />
																	<c:forEach var="profileUser" items="${trainee.users.profileUsers}" >								
																		<c:if test = "${profileUser.profile.name == 'LastName'}">
																				<c:set var="lastName" value="${profileUser.value}" />
																		</c:if>
																	</c:forEach>
																	<td class="lastName">${lastName}</td>
																	
																	<c:set var="birthDay" value="" />
																	<c:forEach var="profileUser" items="${trainee.users.profileUsers}" >								
																		<c:if test = "${profileUser.profile.name == 'Birthday'}">
																				<c:set var="birthDay" value="${profileUser.value}" />
																		</c:if>
																	</c:forEach>
																	<td class="Birthday">${birthDay}</td>
																	
																	<c:set var="phone" value="" />
																	<c:forEach var="profileUser" items="${trainee.users.profileUsers}" >								
																		<c:if test = "${profileUser.profile.name == 'Phone'}">
																				<c:set var="phone" value="${profileUser.value}" />
																		</c:if>
																	</c:forEach>
																	<td class="Birthday">${phone}</td>
																	
																	<c:set var="email" value="" />
																	<c:forEach var="profileUser" items="${trainee.users.profileUsers}" >								
																		<c:if test = "${profileUser.profile.name == 'Email'}">
																				<c:set var="email" value="${profileUser.value}" />
																		</c:if>
																	</c:forEach>
																	<td class="Email">${email}</td>
																	
																	<td class="actions text-center font-14" >
																		<a class="del-Traineerow link link-trash" >
																			<i class="fa fa-trash-o"></i>
																		</a>
																	</td>
																</tr>	
															</c:forEach>
													
														</tbody>
													</table>
												</div>
												<!-- end TABLE -->
											</div>
											<!-- end VIEW-BODY -->	
										</div>
										<!-- end: panel body -->

										</div>
										<!-- end panel -->
									</div>
									<!-- end col-->
								</div>
								<!-- end row -->

								<!-- ===========
								ADD TRAINEE
								====== -->
								<div class="row m-t-10 hidden" id="add-Trainee">
									<div class="col-sm-12">
										<div class="panel panel-right panel-left">
											<div class="panel-body p-t-0">
												
												<div class="row view-header" data-toggle="tooltip" data-placement="bottom" 
													title='Show and hide information' >		
													<p class="b"><strong>Choose Trainee to add into course </strong></p>
												</div>
												
												
												<!-- TABLE -->
												<div class="p-t-10 view-body">
													<table id="datatable-fixed-header-addTrainee" class="table table-bordered">
														<thead>
															<tr>	
																<th class="hidden"></th>
																<th>Account</th>
																<th>First Name</th>
																<th>Last Name</th>
																<th>Birthday</th>
																<th>Phone</th>
																<th>Email</th>
																<th data-orderable="false"></th>
															</tr>
														</thead>
														<tbody id="table-AddTrainee" >
															<c:forEach var="trainee"  items="${listTraineeAdd}">
																<tr class="part">
																	<td class="userId hidden">${trainee.id}</td>
																	<td class="userName">${trainee.username}</td>
																	
																	<c:set var="firstName" value="" />
																	<c:forEach var="profileUser" items="${trainee.profileUsers}" >								
																		<c:if test = "${profileUser.profile.name == 'FirstName'}">
																				<c:set var="firstName" value="${profileUser.value}" />
																		</c:if>
																	</c:forEach>
																	<td class="firstName">${firstName}</td>
																	
																	<c:set var="lastName" value="" />
																	<c:forEach var="profileUser" items="${trainee.profileUsers}" >								
																		<c:if test = "${profileUser.profile.name == 'LastName'}">
																				<c:set var="lastName" value="${profileUser.value}" />
																		</c:if>
																	</c:forEach>
																	<td class="lastName">${lastName}</td>
																	
																	<c:set var="birthDay" value="" />
																	<c:forEach var="profileUser" items="${trainee.profileUsers}" >								
																		<c:if test = "${profileUser.profile.name == 'Birthday'}">
																				<c:set var="birthDay" value="${profileUser.value}" />
																		</c:if>
																	</c:forEach>
																	<td class="Birthday">${birthDay}</td>
																	
																	<c:set var="phone" value="" />
																	<c:forEach var="profileUser" items="${trainee.profileUsers}" >								
																		<c:if test = "${profileUser.profile.name == 'Phone'}">
																				<c:set var="phone" value="${profileUser.value}" />
																		</c:if>
																	</c:forEach>
																	<td class="Birthday">${phone}</td>
																	
																	<c:set var="email" value="" />
																	<c:forEach var="profileUser" items="${trainee.profileUsers}" >								
																		<c:if test = "${profileUser.profile.name == 'Email'}">
																				<c:set var="email" value="${profileUser.value}" />
																		</c:if>
																	</c:forEach>
																	<td class="Email">${email}</td>
																	
																	<td class="actions text-center font-14" >
																		<a class="add-Traineerow link link-edit"
																			data-toggle="tooltip" data-placement="bottom" title='Add to course'>
																			<i class="fa fa-plus"></i>
																		</a>
																	</td>
																</tr>	
															</c:forEach>
														</tbody>
													</table>
												</div>
												<!-- end TABLE -->
											</div>
											<!-- end: panel body -->

										</div>
										<!-- end panel -->
									</div>
									<!-- end col-->
								</div>
								<!-- end row -->
							</div>
						</div>
							
							
						</div>
						<!-- container -->

					</div>
					<!-- content -->

				</div>
			</div>

			
			
		</div>
		<!-- END RIGHT CONTENT -->
		<footer class="footer navbar-fixed-bottom"> 2017 © FSOFT GST. </footer>

	</div>
	<!-- END wrapper -->

	<script>
		var resizefunc = [];
	</script>

	<!-- jQuery -->
	<%@ include file="include/js.jsp" %>

	<!-- init -->
		<script src="<c:url value = '/static/pages/course-view-trainee.js' />"></script>
		
		<script src="<c:url value = '/static/plugins/datatables/jquery.dataTables.min.js' />"></script>
        <script src="<c:url value = '/static/plugins/datatables/dataTables.bootstrap.js' />"></script>
        <script src="<c:url value = '/static/plugins/datatables/dataTables.buttons.min.js' />"></script>
        <script src="<c:url value = '/static/plugins/datatables/buttons.bootstrap.min.js' />"></script>
        <script src="<c:url value = '/static/plugins/datatables/jszip.min.js' />"></script>
        <script src="<c:url value = '/static/plugins/datatables/pdfmake.min.js' />"></script>
        <script src="<c:url value = '/static/plugins/datatables/vfs_fonts.js' />"></script>
        <script src="<c:url value = '/static/plugins/datatables/buttons.html5.min.js' />"></script>
        <script src="<c:url value = '/static/plugins/datatables/buttons.print.min.js' />"></script>
		
		<script src="<c:url value = '/static/plugins/datatables/dataTables.fixedHeader.min.js' />"></script>
		
		 <!-- Datatable init js -->
        <script src="<c:url value = '/static/pages/datatables.init.js' />"></script>
		
</body>
</html>