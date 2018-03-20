<%@page import="com.projectbru.demo.model.MemberBean"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.projectbru.demo.model.*"%>
<%@ page import="java.util.List"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>สมัครสามาชิก</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<%
	MemberBean bean = null;
	String result = "";
%>
<%
	bean = (MemberBean) request.getSession().getAttribute("LoginUser");
	result = (String) request.getAttribute("messes");
%>
<style type="text/css">
body {
	background-color: #b3b3b3;
}
</style>
</head>
<body style="margin-top: 5%">
	<form name="welcome" action="register" method="post" onSubmit="return fncSubmit();">
		<div class="container">
		<h2 align="center">WELCOME PROJECT</h2>
		<br>
			<div class="alert alert-success" align="right">
				<strong>Welcome new user </strong>
	
			</div>
			<%
				if (result.equals("S")) {
			%>
			<div class="alert alert-success">
				<strong>Success!</strong> Insert Success....</div>
			
			<%
				} else if (result.equals("F")) {
			%>
			<div class="alert alert-danger">
				<strong>Danger!</strong> Insert Fail !....
			</div>
				<%
				} else if (result.equals("B")) {
			%>
			<div class="alert alert-danger">
				<strong>User Repetitive !</strong> User Repetitive !....
			</div>
			
			<%
				}
			%>
			<div class="form-group">
				<label for="exampleInputEmail1">Username</label> <input type="text"
					class="form-control" name="username">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Password</label> <input type="text"
					class="form-control" name="password">

			<div class="form-group">
				<label for="exampleInputEmail1">Confirm Password</label> <input type="text"
					class="form-control" name="conpassword">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Name</label> <input type="text"
					class="form-control" name="name">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Address</label> <input type="text"
					class="form-control" name="address">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Phone</label> <input type="text"
					class="form-control" name="Phone">
			</div>
			<div>
     		 <input type="hidden" value="<% Date dNow = new Date( );
            		 SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");  out.print(ft.format(dNow)); %>" name="c1">
             <input type="hidden" value="<% Date bos = new Date( );
            		 SimpleDateFormat f2 = new SimpleDateFormat ("dd-MM-yyyy");  out.print(f2.format(bos)); %>" name="c2">
			</div>
			<div align="right">
			<button type="submit" class="btn btn-outline-success">Register</button>
			<input type="button" class="btn btn-outline-danger" value="Back" onclick="javascript: document.backForm.submit()">
			&nbsp;
			</div>
		</div>
		</div>
	</form>
	<form name="backForm" action="/" method="post"
		th:hidden="true"></form>
	<form name="logoutForm" action="logout" method="post" th:hidden="true"></form>
	<script type="text/javascript"src="assets/js/RegFrom.js"></script>
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>