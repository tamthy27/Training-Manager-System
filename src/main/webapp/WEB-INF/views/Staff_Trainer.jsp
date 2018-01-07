<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>>
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
							<h4 class="page-title"></h4>
						</li>
					</ul>
					<button
						class="btn btn-custom btn-right disabled waves-effect waves-light"
						id="buttonLeave">
						<i class="fa fa-sign-out"></i> Leave
					</button>
					<button
						class="btn btn-custom btn-right disabled waves-effect waves-light"
						id="buttonEdit">
						<i class="fa fa-pencil"></i> Edit
					</button>
					<button
						class="btn btn-custom btn-right disabled waves-effect waves-light"
						id="buttonAdd">
						<i class="fa fa-plus"></i> Add
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
										<div class="panel-body">



											<!-- TABLE -->
											<div>
												<table id="datatable-fixed-header" class="table ">
													<thead>
														<tr>
															<th>UserName</th>
															<th>FirstName</th>
															<th>Last Name</th>
															<th class='hidden'></th>



														</tr>
													</thead>
													<tbody id="table-Staff" class="empty">

														<c:forEach var="listUser" items="${listUser}">
															<tr class="part">
																<td>
																	<p class='hidden id'>${listUser.id}</p>
																	<p class="username">${listUser.username}</p>
																</td>
																<c:forEach var="profileUser"
																	items="${listUser.profileUsers}">
																	<c:if test="${profileUser.profile.name == 'FirstName'}">
																		<c:set var="firstname" value="${profileUser.value}" />
																	</c:if>

																</c:forEach>
																<td>
																	<p class="firstname">${firstname}</p>
																</td>
																<c:forEach var="profileUser"
																	items="${listUser.profileUsers}">
																	<c:if test="${profileUser.profile.name == 'LastName'}">
																		<c:set var="lastname" value="${profileUser.value}" />
																	</c:if>S

																</c:forEach>
																<td>
																	<p class="lastname">${lastname}</p>
																</td>
																<td class="hidden"><c:forEach var="profileUser"
																		items="${listUser.profileUsers}">
																		<c:if test="${profileUser.profile.name == 'Email'}">

																			<p class="email">${profileUser.value}</p>

																		</c:if>
																	</c:forEach> <c:forEach var="profileUser"
																		items="${listUser.profileUsers}">
																		<c:if test="${profileUser.profile.name == 'Birthday'}">

																			<p class="birthday">${profileUser.value}</p>

																		</c:if>
																	</c:forEach> <c:forEach var="profileUser"
																		items="${listUser.profileUsers}">
																		<c:if test="${profileUser.profile.name == 'Phone'}">

																			<p class="phone">${profileUser.value}</p>

																		</c:if>
																	</c:forEach> <c:forEach var="profileUser"
																		items="${listUser.profileUsers}">
																		<c:if test="${profileUser.profile.name == 'Type'}">

																			<p class="type">${profileUser.value}</p>

																		</c:if>
																	</c:forEach> <c:forEach var="profileUser"
																		items="${listUser.profileUsers}">
																		<c:if
																			test="${profileUser.profile.name == 'Education'}">

																			<p class="education">${profileUser.value}</p>

																		</c:if>
																	</c:forEach> <c:forEach var="profileUser"
																		items="${listUser.profileUsers}">
																		<c:if
																			test="${profileUser.profile.name == 'WorkingPlace'}">

																			<p class="workingplace">${profileUser.value}</p>

																		</c:if>
																	</c:forEach> <c:forEach var="profileUser"
																		items="${listUser.profileUsers}">
																		<c:if test="${profileUser.profile.name == 'Avatar'}">

																			<p class="avatar">${profileUser.value}</p>

																		</c:if>
																	</c:forEach></td>
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
									<div class="panel-body ">

										<div class="row ">
											<div class="col-md-4"></div>
											<div class="col-md-4 " style="margin-left: 6%">
												<img
													src="<c:url value = '/static/images/users/avartar.jpg' />"
													class="img-responsive img-circle" style="width: 100px"
													id="profile-Avatar">
											</div>
											<div class="col-md-4"></div>
										</div>
										<br>
										<div class="row hidden">
											<label class="" id="profile-ID"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">First Name</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-FirstName"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Last Name</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-LastName"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Email</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
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
											<label class="col-md-3 lbl-info-title">Type</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-Type"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Education</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-Education"></label>
										</div>
										<div class="row ">
											<label class="col-md-3 lbl-info-title">Working Place</label>
											<label class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-WorkingPlace"></label>
										</div>

									</div>
									<!-- end: panel body -->

								</div>
								<!-- end panel -->
							</div>
							<!-- end col-->
						</div>
						<!-- end row -->

						<div class="row list-topic">
							<div class="col-sm-1">
								<a href='#' class='link link-plus ' data-toggle='tooltip'
									data-placement='top' id="add-topic" title='Add'><i
									class='fa fa-plus fa-lg2'></i></a>
							</div>
							<div class="col-sm-9">
								<h4>List Topics are Assigned</h4>
							</div>
						</div>

						<!--  -->
						<!-- NEW  -->
						<!-- -->
					<div class="row listTopic">
							<div class="col-sm-12">
								<div class="panel panel-color panel-success panel-topic-course">
									<div class="panel-heading"  id="topic-new">
										<div class=" pull-right ">
											<a href="#" class=" card-drop"
												data-toggle="dropdown" aria-expanded="false"> 
												<i  class="zmdi zmdi-chevron-down iconDS-default"></i>
											</a>
										</div>
										<h4 class="panel-title">New</h4>
									</div>
									<div class="panel-body paragraphDS hidden" id="topic-new-box">
									
									</div>
									<!-- end content -->
								</div>						
							
							</div>
						</div>
						<!--  -->
						
						
						<!--  -->
						<!-- COMPLETED -->
						<!-- -->
						
						<div class="row listTopic">
							<div class="col-sm-12">
								<div class="panel panel-color panel-pink panel-topic-course">
									<div class="panel-heading" id="topic-completed">
										<div class=" pull-right ">
											<a href="#"  data-toggle="dropdown" aria-expanded="false"
												class=" card-drop" > 
												<i class="zmdi zmdi-chevron-down iconDS-default"></i>
											</a>
										</div> 
										<h4 class="panel-title">Completed</h4>
									</div>
									<div class="panel-body paragraphDS hidden" id="topic-completed-box">
																					
									</div>
									<!-- end content -->
								</div>						
							
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

							<hr>
							<div class="form-group edit-trainer">
								<div class="col-md-2"></div>
								<div class="col-md-8">
									<div class="card-box">
										<h4 class="header-title m-t-0 m-b-30">Avatar</h4>
										<input type="file" class="dropify" data-show-remove="false"
											data-height="200" data-width="200" />
									</div>
								</div>
								<div class="col-md-2"></div>
							</div>
							<div class="form-group hidden ">
								<input type="text" class="form-control" value=""
									id="inputProfile-ID" />
							</div>
							<div class="form-group edit-trainer ">
								<label class="col-sm-3 control-label lbl-left">First
									Name *</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" required
										placeholder="Enter First Name..." id="inputProfile-FirstName" />
								</div>
							</div>
							<div class="form-group edit-trainer ">
								<label class="col-sm-3 control-label lbl-left">Last Name
									*</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" required
										placeholder="Enter Last Name..." id="inputProfile-LastName" />
								</div>
							</div>
							<div class="form-group edit-trainer ">
								<label class="col-sm-3 control-label lbl-left">Email *</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" parsley-type="email"
										value="" required placeholder="Enter a e-mail..."
										id="inputProfile-Email" />
								</div>
							</div>
							<div class="form-group edit-trainer ">
								<label class="col-sm-3 control-label lbl-left">Birthday
									*</label>
								<div class="col-sm-8">
									<input type="text" placeholder="dd/mm/yyyy" required
										data-mask="99/99/9999" class="form-control"
										id="inputProfile-Birthday">
								</div>

							</div>
							<div class="form-group edit-trainer ">
								<label class="col-sm-3 control-label lbl-left">Phone
									Number *</label>
								<div class="col-sm-8">
									<input data-parsley-type="digits" type="text" required
										data-parsley-minlength="10" class="form-control" value=""
										placeholder="Enter only digits..."
										id="inputProfile-PhoneNumber" />
								</div>
							</div>

							<div class="form-group edit-trainer">
								<label class="col-sm-3 control-label lbl-left">Type</label>
								<div class="col-sm-8">
									<select class="form-control">
										<option>Internal</option>
										<option>External</option>
									</select>
								</div>
							</div>

							<div class="form-group edit-trainer ">
								<label class="col-sm-3 control-label lbl-left">Education</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value=""
										placeholder="Enter Education..." id="inputProfile-Education" />
								</div>
							</div>

							<div class="form-group edit-trainer">
								<label class="col-sm-3 control-label lbl-left">Working
									Place</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value=""
										placeholder="Enter Place..." id="inputProfile-WorkingPlace" />
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

		<div class="modal fade modalDS-bg " id="dialogAddTopic" role="dialog"
			data-keyboard="false" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content modalDS-content">
					<div class="modal-header modalDS-header">
						<button type="button" class="close cancelDialog"
							data-dismiss="modal" aria-hidden="true">×</button>
						<h3 class="modal-title modalDS-h2-header"
							id="full-width-modalLabel">List Topics</h3>
					</div>
					<div class="modal-body modalDS-body">
						<div class="row">
							<div class="col-sm-12">
								<div class="panel">
									<div class="panel-body">



										<!-- TABLE -->
										<div>
											<table class="table">
												<thead>
													<tr>
														<th></th>
														<th></th>
													</tr>
												</thead>
												<tbody id="table-Topic-Course" class="empty">

													<c:forEach var="topic" items="${listTopic}">

														<tr class="part1">
															<td class="topicCourseRow">
																<p>
																	<span title="Category"> </span> <span title="Course">Category</span>
																</p>
																<p>
																	<strong title="Name">course</strong>
																</p>
																<p>
																	<span><i
																		class='fa fa-circle fa-lg2 lbl-success lbl-status'></i></span>
																	<span title="Date Start">${topic.getTimeString()}</span>
																</p>
																<p title="Description">${topic.description}</p>
															</td>
															<td class="actions"><a href="#"
																class="remove-TopicCourseRow link link-view hidden"><i
																	class="fa fa-check fa-lg2"></i></a> <a href="#"
																class="add-TopicCourseRow link link-trash"><i
																	class="fa fa-close fa-lg2"></i></a></td>
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

					</div>
					<div class="modal-footer modalDS-footer">
						<div class="col-sm-offset-8 col-sm-4 m-t-15 "
							id="save-addTopicCourse">
							<button type="button"
								class="btn btn-primary waves-effect waves-light" id="modalSave">Save</button>
							<button type="button"
								class="btn btn-default waves-effect cancelDialog">Cancel</button>
						</div>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

	</div>
	<!-- END wrapper -->

	<script>
		var resizefunc = [];
	</script>

	<!-- jQuery -->
	<%@ include file="include/js.jsp"%>


	<!-- init -->
	<script src="<c:url value = '/static/pages/staff_trainer.js' />"></script>
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