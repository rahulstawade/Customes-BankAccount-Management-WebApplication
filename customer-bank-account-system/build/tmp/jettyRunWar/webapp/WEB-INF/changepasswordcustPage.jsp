<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath }/style.css"
	rel="stylesheet" type="text/css">
<title>Change Password</title>
<sb:head />
<sj:head jqueryui="true" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body background="stripes-2.jpg">
	<jsp:include page="masterpage/customerNavBar.jsp"></jsp:include>


	<h2
		style="font-family: Lucida Handwriting; font-size: xx-large; color: red;"
		align="center">Change Password</h2>
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
	<br>

	<div class="container">

		<s:form action="changeCustomerPasswordAction" method="post"
			theme="bootstrap" cssClass="well form-horizontal" id="changePassForm">

			<s:password placeholder="Enter Current Password"
				name="userForm.userPassword" id="currentPasswordID"
				label="Current Password" tooltip="Enter your Current Password"
				inputPrependIcon="glyphicon glyphicon-star-empty">

			</s:password>

			<s:password placeholder="Enter New Password"
				name="userForm.usernewPassword" id="newPasswordID"
				label="New Password" tooltip="Enter New Password to be Change"
				inputPrependIcon="glyphicon glyphicon-star-empty" onkeyup="check()">

			</s:password>
			<script type="text/javascript">
				function check() {
					var newPassword = document.getElementById("newPasswordID").value;
					if (newPassword == "") {
						document.getElementById("confirmPasswordID").disabled = true;
						document.getElementById("submit").disabled = true;

					} else {
						document.getElementById("confirmPasswordID").disabled = false;
					}
				}
			</script>

			<s:password placeholder="Confirm New Password"
				name="userForm.userconfirmPassword" id="confirmPasswordID"
				label="Confirm Password" tooltip="Confirm new Password"
				inputPrependIcon="glyphicon glyphicon-star-empty"
				onkeyup="isMatching()" disabled="true">

			</s:password>

			<p id="displayMessage" style="color: red;" align="center"></p>
			<script type="text/javascript">
				function isMatching() {
					var newPassword = document.getElementById("newPasswordID").value;
					var currentPassword = document
							.getElementById("confirmPasswordID").value;

					if (currentPassword != newPassword) {
						document.getElementById("displayMessage").innerHTML = "Password Not Matching..!!";
						document.getElementById("submit").disabled = true;
					} else {
						document.getElementById("displayMessage").innerHTML = "";
						document.getElementById("submit").disabled = false;
					}
				}
			</script>


			<br>
			<br>
			<center>
				<s:submit value="Update Password" id="submit"
					cssClass="btn btn-large btn-danger" disabled="true"></s:submit>
			</center>

		</s:form>
	</div>
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.8/jquery.validate.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#changePassForm').validate({
				rules : {
					"userForm.userPassword" : {
						required : true

					},
					"userForm.usernewPassword" : {
						required : true
					},
					"userForm.userconfirmPassword" : {
						required : true
					}
				}
			});
		});
	</script>
	<jsp:include page="masterpage/footer.jsp"></jsp:include>