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
							<h4 class="page-title"> Manage Course in Category 
								<span    style="color: #0075b5" data-toggle="tooltip" data-placement="bottom" 
								title='${category.description}'>${category.name}</span>
							</h4>
						</li>
					</ul>
					<button class="btn btn-custom  btn-right  waves-effect waves-light" id="buttonDelete">
						<i class="fa fa-times"  ></i><spring:message code="Button.Delete" /></button>
					<button class="btn btn-custom btn-right disabled waves-effect waves-light" id="buttonEdit">
						<i class="fa fa-pencil"  ></i> <spring:message code="Button.Edit" /> </button>
					<button class="btn btn-success btn-right waves-effect waves-light"  id="buttonAdd"> 
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
										<div class="panel-body p-t-0">

											<div class="row view-header" >		
												<p class="b"><strong>List Course</strong></p>
											</div>

											<!-- TABLE -->
											<div class="m-t-20">
												<table  id="datatable-fixed-header" class="table "  >
													<thead>
															<tr>
																<th class="header-noborder hidden"></th>
																<th class="header-noborder hidden"></th>
																
															</tr>
													</thead>
													<tbody id="table-Staff">
														<c:forEach var="course" items="${listCourseNew}">
															<tr class="part">
																<td >
																	<p class='hidden'>${course.courseId}</p>
																	<p>
																		<span>
																			<strong class='' data-toggle="tooltip" data-placement="top" title='name'>
																				${course.name}
																			</strong>
																		</span>
																		<span class='lbl-right dateEnd' data-toggle="tooltip" data-placement="top" title='date end'>
																			${course.getEndDateString()}
																		</span>
																		<span class='lbl-right '>-</span>
																		<span class='lbl-right dateStart' data-toggle="tooltip" data-placement="top" title='date start'>
																			${course.getStartDateString()}
																		</span>
																		<span class='lbl-right '>
																			<i class='fa fa-circle fa-lg2 lbl-success lbl-status'></i>
																		</span>
																	</p>
																	<p class='' data-toggle="tooltip" data-placement="top" title='description'>
																		${course.description}
																	</p>
																</td>
																<td class='actions text-center col-w-6' >
																	<a href='${home}course/course-view-list-trainee/${course.courseId}' 
																	class='link link-edit viewRow' data-toggle='tooltip' data-placement='top'
								                                        title='View List Trainees'>
																		<i class='zmdi zmdi zmdi-face zmdi-hc-lg2'></i>
																	</a>
																</td>
															</tr>
														</c:forEach>
														
														<c:forEach var="course" items="${listCoursePro}">
															<tr class="part">
																<td >
																	<p class='hidden'>${course.courseId}</p>
																	<p>
																		<span>
																			<strong class='' data-toggle="tooltip" data-placement="top" title='name'>
																				${course.name}
																			</strong>
																		</span>
																		<span class='lbl-right dateEnd' data-toggle="tooltip" data-placement="top" title='date end'>
																			${course.getEndDateString()}
																		</span>
																		<span class='lbl-right '>-</span>
																		<span class='lbl-right dateStart' data-toggle="tooltip" data-placement="top" title='date start'>
																			${course.getStartDateString()}
																		</span>
																		<span class='lbl-right '>
																			<i class='fa fa-circle fa-lg2 lbl-warning lbl-status'></i>
																		</span>
																	</p>
																	<p class='' data-toggle="tooltip" data-placement="top" title='description'>
																		${course.description}
																	</p>
																</td>
																<td class='actions text-center col-w-6'>
																	<a href='${home}course/course-view-list-trainee/${course.courseId}' class='link link-edit viewRow' data-toggle='tooltip' data-placement='top'
								                                        title='View List Trainees'>
																		<i class='zmdi zmdi zmdi-face zmdi-hc-lg2'></i>
																	</a>
																</td>
															</tr>
														</c:forEach>
														
														 <c:forEach var="course" items="${listCourseCom}">
															<tr class="part">
																<td >
																	<p class='hidden'>${course.courseId}</p>
																	<p>
																		<span>
																			<strong class='' data-toggle="tooltip" data-placement="top" title='name'>
																				${course.name}
																			</strong>
																		</span>
																		<span class='lbl-right dateEnd' data-toggle="tooltip" data-placement="top" title='date end'>
																			${course.getEndDateString()}
																		</span>
																		<span class='lbl-right '>-</span>
																		<span class='lbl-right dateStart' data-toggle="tooltip" data-placement="top" title='date start'>
																			${course.getStartDateString()}
																		</span>
																		<span class='lbl-right '>
																			<i class='fa fa-circle fa-lg2 lbl-error lbl-status'></i>
																		</span>
																	</p>
																	<p class='' data-toggle="tooltip" data-placement="top" title='description'>
																		${course.description}
																	</p>
																</td>
																<td class='actions text-center col-w-6'>
																	<a href='${home}course/course-view-list-trainee/${course.courseId}' class='link link-edit viewRow' data-toggle='tooltip' data-placement='top'
								                                        title='View List Trainees'>
																		<i class='zmdi zmdi zmdi-face zmdi-hc-lg2'></i>
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
									<div class="panel-body p-t-0"  >	
										
										<div class="row view-header" >		
											<p class="b"><strong>Category information</strong></p>
										</div>
										<div class="view-body">	
											<div class="row hidden">
												<label class="col-md-8 lbl-info-detail" id="profile-ID"></label>
												
											</div>
											<div class="row">
												<label class="col-md-3 lbl-info-title">Name</label> <label
													class="col-md-1 lbl-info-title">:</label> <label class="col-md-8 lbl-info-detail" id="profile-Name"></label>
											</div>
											<div class="row">
												<label class="col-md-3 lbl-info-title">Date Start</label> <label
													class="col-md-1 lbl-info-title">:</label> <label class="col-md-8 lbl-info-detail" id="profile-Start"></label>
											</div>
											<div class="row">
												<label class="col-md-3 lbl-info-title">Date End</label> <label
													class="col-md-1 lbl-info-title">:</label> <label class="col-md-8 lbl-info-detail" id="profile-End">20/11/2017</label>
											</div>
											<div class="row">
												<label class="col-md-3 lbl-info-title">Description</label> <label
													class="col-md-1 lbl-info-title">:</label>
													
											</div>
											<div class="row">
												<label class="col-md-12 lbl-info-detail" id="profile-Description"></label>
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
						
						<div class="row listTopic">
						
							<div class="col-sm-1" style="margin: 10px 0px;">
								<a class='link link-plus ' data-toggle='tooltip' data-placement='top' 
									id="add-Topic" title="Add new Topic to this Course">
									<i class='fa fa-plus fa-lg2'></i>
								</a>
							</div>
							<div class="col-sm-5">
								<h4>List Topic in Course</h4>
							</div>
							<div class="col-sm-5 text-right ">
								<div class="m-t-10">
									<a href="#" id="view-topic">View all Topic detail</a>
								</div>
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
		<div class="modal fade modalDS-bg " id="dialogProfile" role="dialog" data-keyboard="false" data-backdrop="static">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content modalDS-content">
					<div class="modal-header modalDS-header">
						<button type="button" class="close cancel-EditProfile" data-dismiss="modal">&times;</button>
						<h2 class="panel-title modalDS-h2-header"></h2>
					</div>
					<div class="modal-body modalDS-body">
						<form class="form-horizontal group-border-dashed" action="#">
							<h3 style="text-align: center" id="profile-UserName" class="edit-trainer"></h3>		
							<hr>
							<div class="form-group hidden">
								<input type="text" id="inputProfile-ID"/>
							</div>
							<%-- <div class="form-group hidden">
								<input type="text" id="inputProfile-category" value="${category.categoryId}"/>
							</div> --%>
							<div class="form-group edit-course edit-topic">
								<label class="col-sm-3 control-label lbl-left">Name *</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" required
										placeholder="Enter Name..." id="inputProfile-Name"/>
								</div>
							</div>
						
							<div class="form-group edit-topic edit-course">
								<label class="col-sm-3 control-label lbl-left">Description *</label>
								<div class="col-sm-8">
									<textarea class="form-control" data-parsley-id="50"  required rows="8"
										placeholder="Enter Description..."  id="inputProfile-Description"></textarea>
								</div>
							</div>		
							<div class="form-group edit-topic edit-course">
								<label class="col-sm-3 control-label lbl-left">Category</label>
								<div class="col-sm-8">
									<select class="form-control" id="inputProfile-category" disabled >
										<option value="${category.categoryId}">${category.name}</option>
									</select>
								</div>
							</div>				
							<div class="form-group edit-topic">
								<label class="col-sm-3 control-label lbl-left">Course</label>
								<div class="col-sm-8">
									<select class="form-control" id="profile-courseId" disabled>
										<option value=""></option>
									</select>
								</div>
							</div>
							<div class="form-group edit-course ">
								<label class="col-sm-3 control-label lbl-left">Time *</label>
								<div class="col-sm-8">
									<div class="input-daterange input-group date-range">
										<input type="text" class="form-control" name="start" id="inputProfile-Start"required/>
										<span class="input-group-addon bg-primary b-0 text-white">to</span>
										<input type="text" class="form-control" name="end" id="inputProfile-End"required/>
									</div>
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
		
	</div>
	<!-- END wrapper -->

	<script>
		var resizefunc = [];
	</script>

	<!-- jQuery -->
	<%@ include file="include/js.jsp" %>

	<!-- init -->
		<script src="<c:url value = '/static/pages/staff_course.js' />"></script>
		
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