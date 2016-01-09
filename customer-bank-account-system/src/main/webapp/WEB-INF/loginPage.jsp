<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath }/style.css"
	rel="stylesheet" type="text/css">

<sb:head />
<title>LOGIN</title>
</head>

<body background="black-gold.jpg">
	<br>

	<h1 style="font-family: Copperplate Gothic Light; color: red;"
		align="center">Banking Application Login</h1>

	<s:if test="hasActionMessages()">
		<center>
			<div class="alert alert-success alert-dismissible"
				style="font-family: Bradley Hand ITC; font-weight: bolder; color: black; font-stretch: wider; font-size: large;">
				<s:actionmessage />
			</div>
		</center>
	</s:if>
	<s:if test="hasActionErrors()">
		<center>
			<div class="alert alert-danger alert-dismissible"
				style="font-family: Bradley Hand ITC; font-weight: bolder; color: black; font-stretch: wider; font-size: large;">
				<s:actionerror />
			</div>
		</center>
	</s:if>

	<br>

	<div class="container">

		<s:form action="loginCheckAction" method="post" theme="bootstrap"
			cssClass="well form-horizontal" id="loginForm">
			<h3
				style="font-family: Copperplate Gothic Light; color: red; padding-left: 18%;">Login
				:-</h3>
			<br>
			<s:textfield placeholder="Enter User ID" name="userForm.userId" id=""
				label="User-ID" tooltip="Enter your User-Id"
				inputPrependIcon="glyphicon glyphicon-user">
			</s:textfield>

			<s:password placeholder="Enter Password" name="userForm.userPassword"
				id="" label="Password" tooltip="Enter your Password"
				inputPrependIcon="glyphicon glyphicon-star-empty">
			</s:password>

			<s:select list="{'CUSTOMER','EMPLOYEE'}" label="User Type"
				name="userForm.userType" id="userTypeId" headerKey=""
				headerValue="Select one User Type" tooltip="Select User Login Type">
			</s:select>

			<center>
				<a href="#"
					style="font-family: Gabriola; font-size: large; color: blue;">Forgot
					Password?</a>
			</center>
			<br>
			<br>
			<center>
				<s:submit value="Login" align="center"
					cssClass="btn btn-large btn-info"></s:submit>
			</center>
		</s:form>
	</div>


	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js">
		
	</script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.8/jquery.validate.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#loginForm').validate({
				rules : {
					"userForm.userId" : {
						required : true,
						number : true
					},
					"userForm.userPassword" : {
						required : true
					},
					"userForm.userType" : {
						required : true
					}
				}
			});
		});
	</script>
	<jsp:include page="masterpage/footer.jsp"></jsp:include>