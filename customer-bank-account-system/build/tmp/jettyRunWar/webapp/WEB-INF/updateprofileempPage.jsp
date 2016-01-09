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
<title>Update Profile</title>
<sb:head />
<sj:head jqueryui="true" />
</head>
<body background="woody.jpg">
	<jsp:include page="masterpage/employeeNavBar.jsp"></jsp:include>

	<h2
		style="font-family: Lucida Handwriting; font-size: xx-large; color: red;"
		align="center">Update Profile</h2>
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
	<div class="container">

		<s:form action="updateEmployeeAction" method="post" theme="bootstrap"
			cssClass="well form-horizontal">

			<s:textfield name="userForm.userId" id="" label="Employee ID"
				tooltip="Your User-Id" inputPrependIcon="glyphicon glyphicon-user"
				disabled="true">
			</s:textfield>


			<s:textfield label="Name" name="userForm.userName" id=""
				tooltip="Name" inputPrependIcon="glyphicon glyphicon-hand-right"
				disabled="true"></s:textfield>

			<s:textfield name="userForm.userGender" id="" label="Gender"
				tooltip="Gender" inputPrependIcon="glyphicon glyphicon-eye-open"
				disabled="true">
			</s:textfield>

			<s:textfield name="userForm.userMaritialStatus" id=""
				label="Maritial Status" tooltip="Maritial Status"
				inputPrependIcon="glyphicon glyphicon-heart-empty" disabled="true">
			</s:textfield>


			<s:textfield placeholder="Enter Email-ID" label="Email ID"
				name="userForm.userContact.userEmailId" id=""
				tooltip="Enter Customer's Email-ID" inputPrepend="@"></s:textfield>


			<s:textfield placeholder="Enter Mobile Number" label="Mobile"
				name="userForm.userContact.userMobileNumber" id=""
				tooltip="Enter Mobile Number"
				inputPrependIcon="glyphicon glyphicon-phone"></s:textfield>

			<p id="displayMessageCity"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield placeholder="Enter City Name" label="City"
				name="userForm.userContact.userCity" id="" tooltip="Enter City Name"
				inputPrependIcon="glyphicon glyphicon-globe"></s:textfield>

			<p id="displayMessagePin"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield placeholder="Enter PinCode" label="PinCode"
				name="userForm.userContact.userPin" id="" tooltip="Enter PIN Code"
				inputPrependIcon="glyphicon glyphicon-pushpin"></s:textfield>

			<p id="displayMessageAddress"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield placeholder="Enter Address" label="Address"
				name="userForm.userContact.userAddress" id=""
				tooltip="Enter Address" inputPrependIcon="glyphicon glyphicon-home"></s:textfield>


			<br>
			<br>
			<center>
				<s:submit value="Update" id="submit"
					cssClass="btn btn-large btn-danger"></s:submit>
			</center>



		</s:form>
	</div>
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.8/jquery.validate.min.js"></script>

	<jsp:include page="masterpage/footer.jsp"></jsp:include>