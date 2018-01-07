<%@page import="com.fsoft.gst.ptithcm.tms.model.CustomUserDetails"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="com.fsoft.gst.ptithcm.tms.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<div class="left side-menu">

	
	<input class="hidden" id="homePath" value="${pageContext.request.contextPath}/">
	
	<div class="sidebar-inner slimscrollleft">
		<!-- User -->
		<div class="user-box">
			<div class="user-img">
				<img src="<c:url value = '/static/images/users/avatar-default.png '/> " alt="user-img"
					title="Mat Helme" class="img-circle img-thumbnail img-responsive">
				<div class="user-status online">
					<i class="zmdi zmdi-dot-circle"></i>
				</div>
			</div>
			<h5 class="p-t-10 p-b-10">
				<a href="" id="user-id">${pageContext.request.userPrincipal.name}</a>
			</h5>
			<ul class="list-inline">
				<li><a href="${home}admin/profile"> <i class="zmdi zmdi-settings"></i>
				</a></li>

				<li><a href="${home}/logout" class="text-custom"> <i
						class="zmdi zmdi-power"></i>
				</a></li>
			</ul>
		</div>
		<!-- End User -->

		<!--- Sidemenu -->
		<div id="sidebar-menu">
			<ul>
					<%
						CustomUserDetails myUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
						Users user = myUserDetails.getUser();
						request.setAttribute("role", user.getRole().getRoleId());
					%>
				
				<c:choose>
					<c:when test="${role == 'AD'}">
						<li>
							<a href="${home}admin/list-trainer" id="Admin_Trainer" class="waves-effect">
								<i class="zmdi zmdi-accounts"></i> 
								<span>Admin Trainer </span>
								<span class="label label-default pull-right"></span> 
							</a>
						</li>
							<li>
							<a href="${home}admin/list-staff" id="Admin_Staff" class="waves-effect">
								<i class="zmdi zmdi-accounts"></i> 
								<span>Admin Staff </span>
								<span class="label label-default pull-right"></span> 
							</a>
						</li>
					</c:when>	
					<c:when test="${role == 'STAFF'}">
						
						 <li>
							<a href="${home}trainer" id="Menu_Trainer" class="waves-effect">
								<i class="zmdi zmdi-accounts"></i> 
								<span> Trainer Account </span>
								<span class="label label-default pull-right"></span> 
							</a>
						</li>
						<li>
							<a href="${home}trainee" id="Menu_Trainee" class="waves-effect">
								<i class="zmdi zmdi-face"></i> 
								<span> Trainee Account </span> 
								<span class="label label-default pull-right"></span>
							</a>
						</li>
						<li>
							<a href="${home}category" id="Menu_Category" class="waves-effect">
								<i class="zmdi zmdi-view-dashboard"></i> 
								<span><spring:message code="Menu.Category" /></span>
								<span class="label label-default pull-right menu-category-count"></span>
							</a>
						</li>
						<li>
							<a  id="Menu_Course" class="waves-effect"> 
								<i class="zmdi zmdi-dns"></i> 
								<span><spring:message code="Menu.Course" /></span> 
								<i class="zmdi zmdi-chevron-down zmdi-hc-lg2 view-more"></i> 
							</a>
		
							<ul>
								<li id="list-catagory-course-menu">
								
									
								</li>
							</ul>
						</li> 
					</c:when>
					<c:when test="${role == 'TRAINER'}">
						<li>
							
							<a id="Menu_Calendar" href="${home}trainer-view/calendar" class="waves-effect">
								<i class="zmdi zmdi-view-dashboard"></i> 
								<span> Calendar </span> 
							</a>
						</li>
						<li>
							
							<a id="Menu_Mail" href="${home}trainer-view/list-topic" class="waves-effect">
								<i class="zmdi zmdi-view-dashboard"></i> 
								<span> Topic </span> 
							</a>
						</li>
					</c:when>
				</c:choose>
				
			</ul>
			<div class="clearfix"></div>
		</div>
		<!-- Sidebar -->
		<div class="clearfix"></div>
	</div>
</div>


