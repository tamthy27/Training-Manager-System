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
							<h4 class="page-title"> Manage Topic in Course 
								<span    style="color: #0075b5" data-toggle="tooltip" data-placement="bottom" 
								title='${course.description}'>${course.name}</span>
							</h4>
						</li>
					</ul>

					<button class="btn btn-custom  btn-right waves-effect waves-light" id="buttonDelete">
						<i class="fa fa-times"></i>
						<spring:message code="Button.Delete" />
					</button>
					<button class="btn btn-custom  btn-right  waves-effect waves-light" id="buttonReassign">
						<i class="fa fa-exchange"></i>
						<spring:message code="Button.Reassign" />
					</button>
					<button class="btn btn-info btn-right  waves-effect waves-light"  id="buttonEdit">
						<i class="fa fa-pencil"></i>
						<spring:message code="Button.Edit" />
					</button>
					<button class="btn btn-success btn-right waves-effect waves-light" id="buttonAdd">
						<i class="fa fa-plus"></i>
						<spring:message code="Button.Add" />
					</button>

				</div>
				<!-- end container -->

			</div>
			<!-- end navbar -->
		</div>
		<!-- Top Bar End -->

		<%@ include file="include/slidebar.jsp"%>

		<div class="row">
			<!-- ============================================================== -->
			<!-- Start Table here -->
			<!-- ============================================================== -->
			<div class="col-sm-8">
				<div class="content-page">
					<!-- Start content -->
					<div class="content">
						<div class="container">

							<div class="row">
								<div class="col-sm-12">
									<div class="panel panel-left">
										<div class="panel-body p-t-0">

											<div class="row view-header m-b-25" >		
												<p class="b"><strong>List topic in Course</strong></p>
											</div>
									
											<!-- TABLE -->
											<div class="view-body">
												<table id="datatable-fixed-header" class="table">
													<thead>
															<tr>
																<th class="header-noborder hidden"></th>
																
															</tr>
													</thead>
													<tbody id="table-Staff">
														<c:forEach var="topic" items="${topicNew}">
															<tr class="part" >
																<td >
																	<p class='hidden'>${topic.topicId}</p>
																	<p>
																		<span>
																			<strong class=''>${topic.name}</strong>
																		</span>
																		
																		<span class='m-l-10 lbl-right dateStart' >
																			${topic.getTimeString()}
																		</span>
																		<span class='lbl-right '>
																			<i class='fa fa-circle fa-lg2 lbl-success lbl-status'></i>
																		</span>
																	</p>
																	<p class='' >${topic.description}</p>
																</td>
															</tr>
														</c:forEach>
														<c:forEach var="topic" items="${topicCompleted}">
															<tr class="part" >
																<td >
																	<p class='hidden'>${topic.topicId}</p>
																	<p>
																		<span>
																			<strong class=''>${topic.name}</strong>
																		</span>
																		
																		<span class='m-l-10 lbl-right dateStart' >
																			${topic.getTimeString()}
																		</span>
																		<span class='lbl-right '>
																			<i  class='fa fa-circle fa-lg2 lbl-error lbl-status'></i>
																		</span>
																	</p>
																	<p class='' >${topic.description}</p>
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
						<!-- container -->

					</div>
					<!-- content -->

				</div>
			</div>

			<!-- ============================================================== -->
			<!-- Start Information here -->
			<!-- ============================================================== -->
			<div class="col-sm-4">
				<!-- Start content -->
				<div class="content hidden" id="rightContent">
					<div class="container">
						<div class="row" id="profileContent">
							<div class="col-sm-12">
								<div class="panel panel-right">
									<div class="panel-body p-t-0">
										
										<div class="row view-header" >		
												<p class="b"><strong>List topic in Course</strong></p>
										</div>
										<div class="view-body">
											<div class="row hidden">
												<label class="col-md-8 lbl-info-detail" id="profile-ID"></label>
											</div>
											<div class="row">
												<label class="col-md-3 lbl-info-title">Name</label> <label
													class="col-md-1 lbl-info-title">:</label> <label
													class="col-md-8 lbl-info-detail" id="profile-Name"></label>
											</div>
											<div class="row">
												<label class="col-md-3 lbl-info-title">Date Start</label> <label
													class="col-md-1 lbl-info-title">:</label> <label
													class="col-md-8 lbl-info-detail" id="profile-Start"></label>
											</div>
											
											<div class="row">
												<label class="col-md-3 lbl-info-title">Description</label> <label
													class="col-md-1 lbl-info-title">:</label> <label
													class="col-md-8 lbl-info-detail" id="profile-Description"></label>
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

						<!--  -->
						<!-- TRAINER IN TOPIC -->
						<!--  -->

						<div class="row ">
							<div class="col-sm-12">
								<div class="panel panel-right">
									<div class="panel-body p-t-0">
										
										<div class="row view-header" >		
												<p class="b"><strong>Trainer information</strong></p>
										</div>
										<div class="view-body" id="body-trainer">
										
											<div class="row ">
												<div class="col-md-4"></div>
												<div class="col-md-4 " style="margin-left: 6%">
													<img src="<c:url value = '/static/images/users/avartar.jpg ' />"
														class="img-responsive img-circle" style="width: 100px"
														id="profile-Avatar">
												</div>
												<div class="col-md-4"></div>
											</div>
											<br>
											
											<div class="row  ">
												<label class="col-md-3 lbl-info-title">First Name</label> <label
													class="col-md-1 lbl-info-title">:</label>
													 <label class="col-md-8 lbl-info-detail" id="trainer-FirstName"></label>
													 <label class="col-md-8 lbl-info-detail hidden" id="trainer-Username"></label>
													
											</div>
											<div class="row  ">
												<label class="col-md-3 lbl-info-title">Last Name</label> <label
													class="col-md-1 lbl-info-title">:</label> <label
													class="col-md-8 lbl-info-detail" id="trainer-LastName">
													</label>
											</div>
											<div class="row  ">
												<label class="col-md-3 lbl-info-title">Email</label> <label
													class="col-md-1 lbl-info-title">:</label> <label
													class="col-md-8 lbl-info-detail" id="trainer-Email"></label>
											</div>
											<div class="row  ">
												<label class="col-md-3 lbl-info-title">Birthday</label> <label
													class="col-md-1 lbl-info-title">:</label> <label
													class="col-md-8 lbl-info-detail" id="trainer-Birthday"></label>
											</div>
											<div class="row  ">
												<label class="col-md-3 lbl-info-title">Phone Number</label> <label
													class="col-md-1 lbl-info-title">:</label> <label
													class="col-md-8 lbl-info-detail" id="trainer-PhoneNumber"></label>
											</div>
											<div class="row ">
												<label class="col-md-3 lbl-info-title">Type</label> <label
													class="col-md-1 lbl-info-title">:</label> <label
													class="col-md-8 lbl-info-detail" id="trainer-Type"></label>
											</div>
											<div class="row ">
												<label class="col-md-3 lbl-info-title">Education</label> <label
													class="col-md-1 lbl-info-title">:</label> <label
													class="col-md-8 lbl-info-detail" id="trainer-Education"></label>
											</div>
											<div class="row ">
												<label class="col-md-3 lbl-info-title">Working Place</label>
												<label class="col-md-1 lbl-info-title">:</label> <label
													class="col-md-8 lbl-info-detail" id="trainer-WorkingPlace"></label>
											</div>
										</div>
										
										<div class="view-body hidden" id="body-trainer-1">
											<p>No Trainer is assigned</p>
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
						<h2 class="panel-title modalDS-h2-header"></h2>
					</div>
					<div class="modal-body modalDS-body">
						<form class="form-horizontal group-border-dashed" action="#">
							<h3 style="text-align: center" id="profile-UserName"
								class="edit-trainer"></h3>
							<hr>
							<div class="form-group hidden">
								<input type="text" id="inputProfile-ID" />
							</div>
							<div class="form-group edit-topic ">
								<label class="col-sm-3 control-label lbl-left">Name *</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" required
										placeholder="Enter Name..." id="inputProfile-Name" />
								</div>
							</div>

							<div class="form-group edit-topic ">
								<label class="col-sm-3 control-label lbl-left">Description
									*</label>
								<div class="col-sm-8">
									<textarea class="form-control" data-parsley-id="50" 
										required rows="5" placeholder="Enter Description..."
										id="inputProfile-Description"></textarea>
								</div>
							</div>
							<div class="form-group edit-topic ">
								<label class="col-sm-3 control-label lbl-left">Category</label>
								<div class="col-sm-8">
									<select class="form-control" disabled id="input-category">
											<option value="${course.category.categoryId}">${course.category.name}</option>
									</select>
								</div>
							</div>
							<div class="form-group edit-topic">
								<label class="col-sm-3 control-label lbl-left">Course</label>
								<div class="col-sm-8">
									<select class="form-control" disabled  id="input-course">
											<option value="${course.courseId}">${course.name}</option>
										
									</select>
								</div>
							</div>
							
							<div class="form-group  edit-topic">
								<label class="col-sm-3 control-label lbl-left">Time *</label>
								<div class="col-sm-8">
									<div class="input-daterange  date-range">
										<input type="text" class="form-control" id="inputProfile-Date"required/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-8 col-sm-4 m-t-15">
									<button type="button" id="saveModal" class="btn btn-primary waves-effect waves-light">
										<spring:message code="Button.Save" />
									</button>
									<button type="button" class="btn btn-default cancel-EditProfile" >
										<spring:message code="Button.Cancel" />
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
		<!-- end Modal Profile-->

		<!-- MODAL TRAINER -->
		<div class="modal fade modalDS-bg " id="dialogTrainer"  role="dialog"
			data-keyboard="false" data-backdrop="static">
			<div class="modal-dialog" style="min-width: 1000px;">
				<div class="modal-content modalDS-content">
					<div class="modal-header modalDS-header">
						<button type="button" class="close cancelDialog"
							data-dismiss="modal" aria-hidden="true" style="color: #fff;">×</button>
						<h3 class="modal-title modalDS-h2-header"
							id="full-width-modalLabel" style="color: white;">List Trainers</h3>
					</div>
					<div class="modal-body modalDS-body">
						<div class="row">
							<div class="col-sm-12">
								<div class="panel">
									<div class="panel-body">
										<!-- Form infor trainer -->
										<form class="form-horizontal group-border-dashed" action="#">
											
											<div class="form-group edit-topic ">
												<div class="col-sm-6">
													<label class="col-sm-2 control-label lbl-left">First Name</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" style="background-color: #f1f1f1;" readonly 
																value="" required id="trainer-firstname" />
													</div>
												</div>
												<div class="col-sm-6">
													<label class="col-sm-2 control-label lbl-left">UserName</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" style="background-color: #f1f1f1;" readonly 
														value="" required id="trainer-username" />
													</div>
												</div>
											</div>
											<div class="form-group edit-topic ">
												<div class="col-sm-6">
													<label class="col-sm-2 control-label lbl-left">Last Name</label>
													<div class="col-sm-8">
														<input type="text" class="form-control"style="background-color: #f1f1f1;" readonly 
														value="" required id="trainer-lastname" />
													</div>
												</div>
												<div class="col-sm-6">
													<label class="col-sm-2 control-label lbl-left">Email</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" style="background-color: #f1f1f1;" readonly 
														value="" required id="trainer-email" />
													</div>
												</div>
											</div>
										</form>
										<!-- End Form infor trainer -->
										<div class="row view-header m-t-20" >		
											<p class="b"><strong>List Trainer</strong></p>
										</div>
										<div class="view-body">
										<!-- TABLE -->
											<table id="datatable-fixed-header-addTrainer" class="table table-bordered">
												<thead>
													<tr>
														<th>UserName</th>
														<th>First Name</th>
														<th>Last Name</th>
														<th>Email</th>
														<th data-orderable="false"></th>
													</tr>
												</thead>
											<tbody >
													
											</tbody>
										</table>
									<!-- end TABLE -->
									</div>
								</div>
								<!-- end: panel body -->
							</div>
							<!-- end panel -->
						</div>
						<!-- end col-->
					</div>

					<div class="modal-footer modalDS-footer">
						<div  class="col-sm-8 m-t-15 text-left">
							<div class=" p-t-2 p-b-2 checkbox checkbox-primary " >
								<input id="checkbox-mail" checked type="checkbox" >
								<label for="checkbox-mail"><spring:message code="Message.send_mail"/></label>
							</div>
						</div>
						<div class="col-sm-4 m-t-15 text-right">
							<button type="button"
								class="btn btn-primary waves-effect waves-light"  id="saveAssignTrainer"><spring:message code="Button.Save" /></button>
							<button type="button"
								class="btn btn-default waves-effect cancelDialog"><spring:message code="Button.Cancel" /></button>
						</div>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		
		</div>
		<!-- /.modal -->
		
	</div>
	<!-- END wrapper -->

	<script>
		var resizefunc = [];
	</script>

	<!-- jQuery  -->
	<%@ include file="include/js.jsp" %>
	<!-- init -->
	<script src="<c:url value = '/static/pages/staff_topic.js'/>"></script>	
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
		<script src="<c:url value = '/static/plugins/datatables/dataTables.scroller.min.js' />"></script>
		 <!-- Datatable init js -->
        <script src="<c:url value = '/static/pages/datatables.init.js' />"></script>
	
</body>
</html>