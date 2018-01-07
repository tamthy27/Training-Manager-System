
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
								<i class="zmdi zmdi-menu' />"></i>
							</button>
						</li>
						<li>
							<h4 class="page-title">Manage Trainer Account</h4>
						</li>
					</ul>
				</div>
				<!-- end container -->
			</div>
			<!-- end navbar -->
		</div>
		<!-- Top Bar End -->

		<%@ include file="include/slidebar.jsp"%>

		<!-- RIGHT CONTENT -->
		<div class="row">
			<!-- ============================================================== -->
			<!-- Start Table here -->
			<!-- ============================================================== -->
			<div class="col-sm-7">
				<div class="content-page">
					<!-- Start content -->
					<div class="content">
						<div class="container">

							<div class="row">
								<div class="col-sm-12">
									<div class="panel panel-left">
										<div class="panel-body">

											<!-- SHOW ENTRY -->
											<div class="row">
												<div class="col-sm-6">
													<div class="m-b-30">
														<button id="add-AdminRow"
															class="btn btn-primary waves-effect waves-light">
															Add <i class="fa fa-plus"></i>
														</button>
													</div>
												</div>
												<div class="col-sm-6">
												</div>
											</div>
											<!-- end SHOW ENTRY -->

											<!-- TABLE -->
											<div>
												
												<table id="datatable-fixed-header" class="table">
													<thead>
														<tr>
															
															<th data-orderable="true" class="header-noborder">UserName</th>
															<th data-orderable="false" class="header-noborder">Password</th>
															<th data-orderable="false" class="header-noborder">Actions</th>
														</tr>
													</thead>
													<tbody id="table-Admin">
														<c:forEach var="listUser" items="${listUser}">
															
															<tr class="part ${listUser.id}">
																<td class='username'>
																	<p class='username'>${listUser.username} </p>
																	<p class='hidden id'>${listUser.id}</p>
																
																<c:forEach var="profileUser" items="${listUser.profileUsers}" >								
																	<c:if test = "${profileUser.profile.name == 'FirstName'}">
																		<c:set var="firstName" value="${profileUser.value}" />
																	</c:if>																																										
																</c:forEach>
																<p class="firstname hidden">${firstName}</p>
																
																<c:forEach var="profileUser" items="${listUser.profileUsers}" >	
																	<c:if test = "${profileUser.profile.name == 'LastName'}">
																		<c:set var="lastname" value="${profileUser.value}" />
																	</c:if>
																</c:forEach>		
																<p class="lastname hidden">${lastname}</p>			
																			
																<c:forEach var="profileUser" items="${listUser.profileUsers}" >	
																	<c:if test = "${profileUser.profile.name == 'Email'}">		
																	<c:set var="email" value="${profileUser.value}" />																																							
																	</c:if>
																</c:forEach>	
																<p class="email hidden">${email}</p>
																
																<c:forEach var="profileUser" items="${listUser.profileUsers}" >	
																	<c:if test = "${profileUser.profile.name == 'Birthday'}">																
																		<c:set var="birthday" value="${profileUser.value}" />																
																	</c:if>
																</c:forEach>	
																<p class="birthday hidden">${birthday}</p>		
																
																<c:forEach var="profileUser" items="${listUser.profileUsers}" >	
																	<c:if test = "${profileUser.profile.name == 'Phone'}">															
																		<c:set var="phone" value="${profileUser.value}" />															
																	</c:if>
																</c:forEach>			
																<p class="phone hidden">${phone}</p>
																												
																<c:forEach var="profileUser" items="${listUser.profileUsers}" >	
																	<c:if test = "${profileUser.profile.name == 'Avatar'}">		
																	<c:set var="avatar" value="${profileUser.value}" />														
																															
																	</c:if>
																</c:forEach>
																<p class="avatar hidden">${avatar}</p>	
																<c:forEach var="profileUser"
																		items="${listUser.profileUsers}">
																		<c:if
																			test="${profileUser.profile.name == 'Education'}">
																			<c:set var="education" value="${profileUser.value}" />	
																			
																		</c:if>
																	</c:forEach> 
																	<p class="education hidden">${education}</p>
																	<c:forEach var="profileUser"
																		items="${listUser.profileUsers}">
																		<c:if test="${profileUser.profile.name == 'WorkingPlace'}">		
																			<c:set var="workingplace" value="${profileUser.value}" />													
																		</c:if>
																	</c:forEach> 
																	<p class="workingplace hidden">${workingplace}</p>
																</td>
															
																<td class='password'>
																	<p class='col-default'>**********</p> 
																	<input placeholder='Enter Password...' type='password'
																		class='col-edit form-control input-block hidden'
																		value='' />
																</td>
																<td class='actions'><a href='#'
																	class='link link-save save-row save-AdminRow link-editing hidden'
																	data-toggle='tooltip' data-placement='top'
																	title='Save Changed Trainer Account'> <i
																		class='fa fa-save fa-lg'></i></a> <a href='#'
																	class='link link-trash cancel-AdminRow link-editing hidden'
																	data-toggle='tooltip' data-placement='top'
																	title='Cancel Changed Trainer Account'> <i
																		class='fa fa-times fa-lg'></i></a> <a href='#'
																	class='link link-edit edit-AdminRow link-default'
																	data-toggle='tooltip' data-placement='top'
																	title='Edit Trainer Account'> <i
																		class='fa fa-pencil fa-lg'></i></a> <a href='#'
																	class='link link-trash del-AdminRow link-default'
																	data-toggle='tooltip' data-placement='top'
																	title='Delete Trainer Account'> <i
																		class='fa fa-trash-o fa-lg'></i></a>
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
			
			<div class="col-sm-5">
				<!-- Start content -->
				<div class="content">
					<div class="container">

						<div class="row">
							<div class="col-sm-12">
								<div class="panel panel-right">
									<div class="panel-body hidden" id="profileContent">
										<div class="row ">
											
											<div class="col-md-4"></div>
											<div class="col-md-4 " style="margin-left: 6%">
												<img
													src="<c:url value = '/static/images/users/avartar.jpg' /> "
													class="img-responsive img-circle" style="width: 100px">
											</div>
											
											<div class="col-md-4"></div>
										</div>
										<br>
										<div class="row hidden">
											<label class=" " id="profile-ID" /></label>
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
											<label class="col-md-3 lbl-info-title">E-Mail</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-Email"></label>
										</div>
										<div class="row">
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
										<div class="row  ">
											<label class="col-md-3 lbl-info-title">Education</label> <label
												class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-Education"></label>
										</div>
										<div class="row  ">
											<label class="col-md-3 lbl-info-title">Working Place</label>
											<label class="col-md-1 lbl-info-title">:</label> <label
												class="col-md-8 lbl-info-detail" id="profile-WorkingPlace"></label>
										</div>
										<div class="col-sm-offset-9 col-sm-3 m-t-15">
											<button id="admin-EditProfile" type="button"
												class="btn btn-primary waves-effect waves-light">
												
												</button>
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
		</div>
		<!-- END RIGHT CONTENT -->
		<footer class="footer"> 2017 © FSOFT GST. </footer>

		<!-- MODAL EDIT -->
		<div class="modal fade modalDS-bg " id="dialogAdminEditInfo"
			role="dialog" data-keyboard="false" data-backdrop="static">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content modalDS-content">
					<div class="modal-header modalDS-header">
						<button type="button" class="close cancelDialog"
							data-dismiss="modal">&times;</button>
						<h2 class="panel-title modalDS-h2-header">Edit Profile</h2>
					</div>
					<div class="modal-body modalDS-body">
						<form class="form-horizontal group-border-dashed" action="#">
							<h3 style="text-align: center" id="profile-UserName' />"></h3>
							<hr>

							<div class="form-group">
								<div class="col-md-4"></div>
									<div class="col-md-4 " style="margin-left: 6%">
										<img src="<c:url value = '/static/images/users/avartar.jpg' />"
												class="img-responsive img-circle" style="width: 100px"
													id="profile-Avatar">
									</div>
									<div class="col-md-4"></div>
							</div>
							<div class="form-group hidden ">
								<input type="text" class="form-control" value=""
									id="inputProfile-ID" />
							</div>
							<div class="form-group ">
								<label class="col-sm-3 control-label lbl-left">First Name *</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" required
										placeholder="Enter First Name..." id="inputProfile-FirstName" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label lbl-left">Last Name *</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" required
										placeholder="Enter Last Name..." id="inputProfile-LastName" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label lbl-left">Email *</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" parsley-type="email"
										value="" required placeholder="Enter a valid e-mail..."
										id="inputProfile-Email" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label lbl-left">Birthday</label>
								<div class="col-sm-8">
									<input type="text" placeholder="dd/mm/yyyy" 
										data-mask="99/99/9999" class="form-control"
										id="inputProfile-Birthday">
								</div>

							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label lbl-left">Phone Number </label>
								<div class="col-sm-8">
									
									<input data-parsley-type="digits" type="text" 
										data-parsley-minlength="10" data-parsley-maxlength="11" class="form-control" value=""
										placeholder="Enter only digits..."
										id="inputProfile-PhoneNumber" />
								</div>
							</div>

							<div class="form-group ">
								<label class="col-sm-3 control-label lbl-left">Type</label>
								<div class="col-sm-8">
									<select class="form-control">
										<option></option>
										<option>Internal</option>
										<option>External</option>
									</select>
								</div>
							</div>

							<div class="form-group ">
								<label class="col-sm-3 control-label lbl-left">Education</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value=""
										placeholder="Enter Name..." id="inputProfile-Education" />
								</div>
							</div>

							<div class="form-group ">
								<label class="col-sm-3 control-label lbl-left">Working
									Place</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value=""
										placeholder="Enter Place..." id="inputProfile-WorkingPlace" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-8 col-sm-4 m-t-15">
									<button type="" id="saveProfile"
										class="btn btn-primary waves-effect waves-light">
										Save</button>
									<button type="button" class="btn btn-default cancelDialog">Cancel</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
		<!-- end Modal Edit-->
	</div>
	<!-- END wrapper -->

	<script>
		var resizefunc = [];
	</script>

	<!-- jQuery  -->

	<%@ include file="include/js.jsp" %>

	
	<!-- init -->
	
	<script src="<c:url value = '/static/pages/admin_trainer.js'/>"></script>	
	    	<!-- init table -->
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