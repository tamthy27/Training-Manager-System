
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><spring:message code="Tille.text"/> </title>
<link rel="shortcut icon" href="<c:url value = '/static/images/favicon.ico'/>">

<!-- Editatable  Css-->
<link rel="stylesheet" href="<c:url value ='/static/plugins/jquery-datatables-editable/datatables.css' />" /> 
<link href="<c:url value ='/static/plugins/datatables/fixedHeader.bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value ='/static/plugins/datatables/scroller.bootstrap.min.css'/>" rel="stylesheet" type="text/css" />



<!-- App css -->
<link href="<c:url value ='/static/css/bootstrap.min.css'/>" 	rel="stylesheet" type="text/css" />
<link href="<c:url value ='/static/css/core.css' />" 			rel="stylesheet" type="text/css" />
<link href="<c:url value ='/static/css/components.css' />" 		rel="stylesheet" type="text/css" />
<link href="<c:url value ='/static/css/icons.css' />" 			rel="stylesheet" type="text/css" />
<link href="<c:url value ='/static/css/pages.css' />" 			rel="stylesheet" type="text/css" />
<link href="<c:url value ='/static/css/menu.css' />" 			rel="stylesheet" type="text/css" />
<link href="<c:url value ='/static/css/responsive.css' />" 		rel="stylesheet" type="text/css" />

<!-- form Uploads -->
<link href="<c:url value ='/static/plugins/fileuploads/css/dropify.min.css' />" rel="stylesheet" type="text/css" />

<link href="<c:url value ='/static/plugins/jstree/style.css'/>" rel="stylesheet" type="text/css" />

<!-- Notification css (Toastr) -->
<link href="<c:url value ='/static/plugins/toastr/toastr.min.css' />" rel="stylesheet" type="text/css" />

 <!-- Treeview css -->
<link href="<c:url value ='/static/plugins/jstree/style.css' />" rel="stylesheet" type="text/css" />

<!--calendar css-->
<link  href="<c:url value ='/static/plugins/fullcalendar/dist/fullcalendar.css' />" rel="stylesheet" />
<link  href="<c:url value ='/static/plugins/fullcalendar/dist/fullcalendar.min.css' />" rel="stylesheet" />
	

<script src="<c:url value ='/static/js/modernizr.min.js' />"></script>

<c:set var="home" value="${pageContext.request.contextPath}/" />

</head>