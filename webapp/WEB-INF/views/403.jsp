	<%@ page language="java" contentType="text/html; charset=UTF-8"
			pageEncoding="UTF-8"%>
	<%@include file="include/header.jsp"%>
    <body>

        <div class="account-pages"></div>
       	<div class="clearfix"></div>
	        <div class="wrapper-page">
	            <div class="ex-page-content text-center">
	                <div class="text-error">403</div>
	                <h3 class="text-uppercase font-600">No permission</h3>
	                <p class="text-muted">
	                    It's looking like you may have taken a wrong turn. Don't worry... it happens to
	                    the best of us. You might want to check your internet connection. Here's a little tip that might
	                    help you get back on track.
	                </p>
	                <br>
	                <a class="btn btn-success waves-effect waves-light" href="${home}home"> Return Home</a>
	
	            </div>
	        </div>
        <!-- End wrapper page -->


    	<script>
            var resizefunc = [];
        </script>

        <%@ include file="include/js.jsp" %>
	
	</body>
</html>