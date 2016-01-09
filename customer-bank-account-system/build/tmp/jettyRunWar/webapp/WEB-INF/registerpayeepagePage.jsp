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
<title>Register Payee</title>
<sb:head />
</head>
<body background="stripes-2.jpg">
	<jsp:include page="masterpage/customerNavBar.jsp"></jsp:include>

	<br>
	<h2
		style="font-family: Lucida Handwriting; font-size: xx-large; color: red;"
		align="center">Register Payee</h2>
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
		<s:form action="registerPayeeAction" method="post" theme="bootstrap"
			cssClass="well form-horizontal" id="registerForm">

			<p id="displayMessageAccountNo"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield placeholder="Payee Account Number"
				label="Account Number " name="userForm.payee.payeeAccountNumber"
				id="" tooltip="Enter Account Number to Register as Payee"
				inputPrependIcon="glyphicon glyphicon-user"></s:textfield>


			<p id="displayMessagePassword"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:password placeholder="Enter Your Password" label="Password "
				name="userForm.userPassword" id="" tooltip="Enter Your Password"
				inputPrependIcon="glyphicon glyphicon-star-empty"></s:password>


			<br>
			<br>
			<center>
				<s:submit value="Register" id="submit"
					cssClass="btn btn-large btn-info"></s:submit>
			</center>

		</s:form>
	</div>

	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.8/jquery.validate.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#registerForm').validate({
				rules : {
					"userForm.payee.payeeAccountNumber" : {
						required : true,
						number : true
					},
					"userForm.userPassword" : {
						required : true
					}
				}
			});
		});
	</script>

	<jsp:include page="masterpage/footer.jsp"></jsp:include>