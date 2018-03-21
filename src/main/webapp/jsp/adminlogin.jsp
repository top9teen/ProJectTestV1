<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String result = "";
%>
<%
	result = (String) request.getAttribute("messessError");
%>

<html>
<head>
 	<link href="assets/admin/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/admin/css/datepicker3.css" rel="stylesheet">
	<link href="assets/admin/css/styles.css" rel="stylesheet">
 <script src="assets/admin/js/jquery-1.11.1.min.js"></script>
	<script src="assets/admin/js/bootstrap.min.js"></script>
<style type="text/css">
form {

}
</style>
</head>
<body>
	<!--  <div class="container" >
		<form name="login" action="adminlogin" method="post">
			<div class="panel panel-primary" style="margin-top: 15%">
				<div class="panel-heading" align="center"></div>
				<h2 align="center">WELCOME PROJECT ADMIN</h2>
				<br>
				<div class="panel-body">
					<div class="form-group">
						<label for="exampleInputEmail1"></label> <input type="text"
							class="form-control" placeholder="Usermane" name="username">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1"></label> <input
							type="password" class="form-control" placeholder="Password"
							name="password">
					</div>
				
				</div>
				<br>
				<div class="panel-footer" align="right">
					<input type="submit" class="btn btn-outline-primary" value="Login">&nbsp;
				</div>
			</div>

		</form>
	</div> -->
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
			
				<div class="panel-heading">
				 <h3 align="center">WELCOME PROJECT ADMIN</h3>
				</div>
				<br>
				<%
						if (result.equals("F")) {
					%>
					<div class="alert alert-danger">
						<strong>ผิดพลาด ! </strong> กรุณากรอก ให้ถูกต้อง !!
					</div>
					<%
						}else if(result.equals("L")){
					%>
							<div class="alert alert-success">
						<strong>Success </strong> Logout Success
					</div>
					<%} %>
				<div class="panel-body">
					<form role="form" name="login" action="adminlogin" method="post">
						<fieldset>
							<div class="form-group">
								<label for="exampleInputEmail1"></label> <input type="text"
							class="form-control" placeholder="Usermane" name="username">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1"></label> <input
							type="password" class="form-control" placeholder="Password"
							name="password">
							</div>
							<div class="panel-footer" align="right">
							<input type="submit" class="btn btn-primary" value="Login">&nbsp;
							</div>
							</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>


	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>