	
	<!-- jQuery  -->
	<script src="<c:url value = '/static/js/jquery.min.js'/>"></script>
	<script src="<c:url value = '/static/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value = '/static/js/detect.js'/>"></script>
	<script src="<c:url value = '/static/js/fastclick.js'/>"></script>
	<script src="<c:url value = '/static/js/jquery.slimscroll.js'/>"></script>
	<script src="<c:url value = '/static/js/jquery.blockUI.js'/>"></script>
	<script src="<c:url value = '/static/js/waves.js'/>"></script>
	<script src="<c:url value = '/static/js/jquery.nicescroll.js'/>"></script>
	<script src="<c:url value = '/static/js/jquery.slimscroll.js'/>"></script>
	<script src="<c:url value = '/static/js/jquery.scrollTo.min.js'/>"></script>
	<script src="<c:url value='/static/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js' />"></script>
	
	<!-- FullCalendar -->
	<script src="<c:url value = '/static/plugins/moment/moment.js/' />"></script>
	<script src="<c:url value = '/static/plugins/fullcalendar/dist/fullcalendar.min.js' />"></script>
	<%--  <script src="<c:url value = '/static/pages/jquery.fullcalendar.js' />"></script>  --%>

	<!-- Modal-Effect -->
	<script src="<c:url value = '/static/plugins/custombox/dist/custombox.min.js' />"></script>
	<script src="<c:url value = '/static/plugins/custombox/dist/legacy.min.js' />"></script>
	
	<!-- Toastr js -->
	<script src="<c:url value='/static/plugins/toastr/toastr.min.js' />"> </script>
	
	<!-- Validation js (Parsleyjs) -->
	<script type="text/javascript" src="<c:url value='/static/plugins/parsleyjs/dist/parsley.min.js' /> "> </script>
	
	<!-- Date Mask js -->
	<script src="<c:url value='/static/plugins/bootstrap-inputmask/bootstrap-inputmask.min.js' />" type="text/javascript"></script>

	<!-- file uploads js -->
	<script src="<c:url value='/static/plugins/fileuploads/js/dropify.min.js' />"></script>
	
	<!-- file main js -->
	<script src="<c:url value = '/static/pages/main.js' />"></script>
	
	<!-- Menu -->
	<script src="<c:url value = '/static/pages/menu.js' />"></script>
	
	
	<!-- App js -->
	<script src="<c:url value = '/static/js/jquery.core.js'/>"></script>
	<script src="<c:url value = '/static/js/jquery.app.js'/>"></script>
	
	<script src="<c:url value = '/static/js/modernizr.min.js'/>"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('form').parsley();
			
		});
	</script>
	
	<script type="text/javascript">
		$('.dropify').dropify({
			messages : {
				'default' : 'Drag and drop a file here or click',
				'replace' : 'Drag and drop or click to replace',
				'remove' : 'Remove',
				'error' : 'Ooops, something wrong appended.'
			},
			error : {
				'fileSize' : 'The file size is too big (1M max).'
			}
		});
	</script>
	<script>
            jQuery('#date-range').datepicker({
                toggleActive: true,
            	autoclose: true,
            	format: "dd/mm/yyyy",
           		todayHighlight: true
            });           
    </script> 
    <script>
            jQuery('.date-range').datepicker({
                toggleActive: true,
            	autoclose: true,
            	format: "dd/mm/yyyy",
           		todayHighlight: true
            });           
    </script>
    
    
	
