<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>

<body class="fixed-left">
	<!-- Begin page -->
	<div id="wrapper1" class="m-t-10">
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
							<h4 class="page-title">Welcome to Training Management System</h4>
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
			<div class="col-sm-5">
				<div class="content-page">
					<!-- Start content -->
					<div class="content">
						<div class="container">

							<div class="row" >
								<div class="col-sm-12">
									<div class="panel panel-left">
										<div class="panel-body p-t-0"  >	
											<div class="row view-header m-b-25" >		
												<p class="b"><strong>List topic in Course</strong></p>
											</div>
											<div id="basicTree">
		                                        <ul>
		                                        	<c:set var="count" value="${1}" />
		                                            <c:forEach var="category" items="${listCategory}" >
		                                            	 <li data-jstree='{"icon":"zmdi zmdi-view-dashboard"}' id = '${category.categoryId}'>
		                                            	 		${category.name}
			                                                <ul>
			                                                	<c:forEach var="course" items="${category.courses}">
			                                                		<c:choose>
			                                                			<c:when test="${count == 1 }">
			                                                				<li data-jstree='{"icon":"zmdi zmdi-dns"}' id = "${course.courseId}"> --%>
				                                                    		 <a href="#" class="jstree-clicked">${course.name}</a></li>
				                                                    		 <c:set var="count" value="${2}" />
			                                                			</c:when>
			                                                			<c:otherwise>
			                                                				<li data-jstree='{"icon":"zmdi zmdi-dns"}' id = "${course.courseId}" >${course.name}</li>
			                                                			</c:otherwise>
			                                                		</c:choose>
			                                                	</c:forEach>
			                                                </ul>
			                                            </li>
		                                            </c:forEach>
		                                            
		                                            
		                                        </ul>
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
					<!-- content -->

				</div>
			</div>

			<!-- ============================================================== -->
			<!-- Start Information here -->
			<!-- ============================================================== -->
			<div class="col-sm-7">
				<!-- Start content -->
				<div class="content " id="rightContent">
					<div class="container">
						<div class="row" id="profileContent">
							<div class="col-sm-12">
								<div class="panel panel-right">
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
															<tr  >
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
				<!-- END content -->
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
		
		<!-- init -->
		<script src="<c:url value = '/static/pages/trainer_topic.js' />"></script>
		
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
        
        <!-- Tree view js -->
         <script src="<c:url value = '/static/plugins/jstree/jstree.min.js' />"></script>
         <script src="<c:url value = '/static/pages/jquery.tree.js' />"></script>
            });
            TableManageButtons.init();

        </script>
        
	
	 <!-- Tree view js -->
       <script src="<c:url value = '/static/plugins/jstree/jstree.min.js' />"></script>
       <script src="<c:url value = '/static/pages/jquery.tree.js' />"></script>
	
</body>
</html>