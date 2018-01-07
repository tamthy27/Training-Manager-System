<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
<meta name="author" content="Coderthemes">
<!-- Custom box css -->
<link href="assets/plugins/custombox/dist/custombox.min.css"
	rel="stylesheet">

<!-- App Favicon -->
<link rel="shortcut icon" href="assets/images/favicon.ico">

<!--calendar css-->
<link href="assets/plugins/fullcalendar/dist/fullcalendar.css"
	rel="stylesheet" />

<!-- App CSS -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets/css/core.css" rel="stylesheet" type="text/css" />
<link href="assets/css/components.css" rel="stylesheet" type="text/css" />
<link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
<link href="assets/css/pages.css" rel="stylesheet" type="text/css" />
<link href="assets/css/menu.css" rel="stylesheet" type="text/css" />
<link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />

<!-- form Uploads -->
<link href="assets/plugins/fileuploads/css/dropify.min.css"
	rel="stylesheet" type="text/css" />


<!-- Treeview css -->
<link href="assets/plugins/jstree/style.css" rel="stylesheet"
	type="text/css" />

<!-- Editatable  Css-->
<link rel="stylesheet"
	href="assets/plugins/jquery-datatables-editable/datatables.css" />

<!-- Design Modal -->
<link rel="stylesheet" href="assets/css/designModal.css" />

<script src="assets/js/modernizr.min.js"></script>

</head>
<body class="fixed-left">

	<!-- Begin page -->
	<div id="wrapper">


		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<!-- ============================================================== -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="container">

					<!-- ========
					INFORMATION
					======== -->
					<div class="panel">
						<div class="panel-body">
							<!-- ========
								VIEW
								======== -->
							<div class="row" id="form-View">
								<div class="col-sm-4">
									<div class="form-group">
										<div class="col-md-4"></div>
										<div class="col-md-4 " style="margin-left: 6%">
											<!-- <img src="assets/images/users/avatar-3.jpg"
											class="img-responsive img-circle" style="width: 100px"> -->
											<div class="profile-info-name">
												<img src="assets/images/profile.jpg" class="img-thumbnail"
													alt="profile-image">
											</div>
										</div>
										<div class="col-md-4"></div>
									</div>
									<h3 style="text-align: center">nguyenvothuytrang</h3>
								</div>
								<div class="col-sm-6">
									<div class="">
										<label class="col-sm-6 control-label">FullName</label> <label
											class="col-sm-6 control-label labelDS-info labelDS-left ">nguyenvothuytrang</label>
									</div>
									<div class="">
										<label class="col-sm-6 control-label">E-Mail</label> <label
											class="col-sm-6 control-label labelDS-info labelDS-left">nguyenvothuytrang</label>
									</div>
									<div class="">
										<label class="col-sm-6 control-label">Phone Number</label> <label
											class="col-sm-6 control-label labelDS-info labelDS-left">nguyenvothuytrang</label>
									</div>

									<div class="">
										<label class="col-sm-6 control-label">Type</label> <label
											class="col-sm-6 control-label labelDS-info labelDS-left">nguyenvothuytrang</label>
									</div>

									<div class="">
										<label class="col-sm-6 control-label">Education</label> <label
											class="col-sm-6 control-label labelDS-info labelDS-left">nguyenvothuytrang</label>
									</div>

									<div class="">
										<label class="col-sm-6 control-label">Working Place</label> <label
											class="col-sm-6 control-label labelDS-info labelDS-left">nguyenvothuytrang</label>
									</div>

									<div class="">
										<div class="col-sm-offset-8 col-sm-4 m-t-15">
											<button id="edit-Profile" type="button"
												class="btn btn-primary waves-effect waves-light">
												Edit</button>
											<button type="button" class="btn btn-default cancel-dialog">Close</button>
										</div>
									</div>
								</div>
							</div>
							<!--  ========
								 EDIT
								 ======== -->

							<form id="form-Edit"
								class=" hidden form-horizontal group-border-dashed" action="#">
								<h3 style="text-align: center">nguyenvothuytrang</h3>
								<div class="form-group">
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

								<div class="form-group">
									<label class="col-sm-3 control-label">FullName</label>
									<div class="col-sm-8">
										<input required type="text" class="form-control"
											placeholder="Enter Name..." />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">E-Mail</label>
									<div class="col-sm-8">
										<input required type="email" class="form-control"
											parsley-type="email" placeholder="Enter a valid e-mail" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">Phone Number</label>
									<div class="col-sm-8">
										<input required data-parsley-type="digits" type="text"
											data-parsley-minlength="11" class="form-control"
											placeholder="Enter only digits" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">Type</label>
									<div class="col-sm-8">
										<select class="form-control">
											<option>Internal</option>
											<option>External</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">Education</label>
									<div class="col-sm-8">
										<input type="text" class="form-control"
											placeholder="Enter Name..." />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">Working Place</label>
									<div class="col-sm-8">
										<input type="text" class="form-control"
											placeholder="Enter Name..." />
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-8 col-sm-4 m-t-15">
										<button type="submit"
											class="btn btn-primary waves-effect waves-light">
											Save</button>
										<button id="cancel-Profile" type="button"
											class="btn btn-default">Cancel</button>
									</div>
								</div>
							</form>
						</div>
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



		<!-- jQuery  -->
		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/detect.js"></script>
		<script src="assets/js/fastclick.js"></script>
		<script src="assets/js/jquery.slimscroll.js"></script>
		<script src="assets/js/jquery.blockUI.js"></script>
		<script src="assets/js/waves.js"></script>
		<script src="assets/js/jquery.nicescroll.js"></script>
		<script src="assets/js/jquery.scrollTo.min.js"></script>
		<script src="assets/pages/jquery.inbox.js"></script>

		<!-- Jquery-Ui -->
		<script src="assets/plugins/jquery-ui/jquery-ui.min.js"></script>

		<!-- BEGIN PAGE SCRIPTS -->
		<script src="assets/plugins/moment/moment.js"></script>
		<script src='assets/plugins/fullcalendar/dist/fullcalendar.min.js'></script>
		<script src="assets/pages/jquery.fullcalendar.js"></script>

		<!-- Modal-Effect -->
		<script src="assets/plugins/custombox/dist/custombox.min.js"></script>
		<script src="assets/plugins/custombox/dist/legacy.min.js"></script>

		<!-- App js -->
		<script src="assets/js/jquery.core.js"></script>
		<script src="assets/js/jquery.app.js"></script>

		<script>
			jQuery(document).ready(function() {

				$('.summernote').summernote({
					height : 320, // set editor height
					minHeight : null, // set minimum height of editor
					maxHeight : null, // set maximum height of editor
					focus : false
				// set focus to editable area after initializing summernote
				});

			});
		</script>
</body>
</html>