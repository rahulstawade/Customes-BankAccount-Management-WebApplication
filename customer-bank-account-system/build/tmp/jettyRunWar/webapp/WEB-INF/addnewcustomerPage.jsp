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
<title>Add New Account</title>
<sb:head />
<sj:head jqueryui="true" />
</head>
<body background="woody.jpg">
	<jsp:include page="masterpage/employeeNavBar.jsp"></jsp:include>


	<h2
		style="font-family: Lucida Handwriting; font-size: xx-large; color: red;"
		align="center">Add Customer</h2>
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

		<s:form action="addnewCustomerAction" method="post" theme="bootstrap"
			cssClass="well form-horizontal" id="newCustForm">

			<p id="displayMessageName"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield placeholder="Enter Name" label="Name"
				name="userForm.userName" id="" tooltip="Customer's Name"
				inputPrependIcon="glyphicon glyphicon-user"></s:textfield>

			<sj:datepicker id="" parentTheme="bootstrap" label="Date of Birth"
				tooltip="Tooltip for Datepicker" cssClass="form-control"
				elementCssClass="col-sm-5" showOn="focus"
				inputPrependIcon="calendar" name="userForm.userDOB"></sj:datepicker>

			<s:select list="{'MALE','FEMALE'}" label="Gender "
				name="userForm.userGender" id="" headerKey=""
				headerValue="Select Gender" tooltip="Select Gender">
			</s:select>

			<s:select list="{'UNMARRIED','MARRIED','WIDOW','DIVORCE'}"
				label="Maritial Status " name="userForm.userMaritialStatus" id=""
				headerKey="" headerValue="Select" tooltip="Select Maritial Status">
			</s:select>

			<s:select list="{'SAVING','CURRENT','FD','RECCURING'}"
				label="Account Type " name="userForm.account.accountType" id=""
				headerKey="" headerValue="Select Account Type"
				tooltip="Select Type of Account">
			</s:select>

			<p id="displayMessageOccupation"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield placeholder="Enter Occupation" label="Occupation"
				name="userForm.occupation" id=""
				tooltip="Enter Customer's Occupation"
				inputPrependIcon="glyphicon glyphicon-briefcase"></s:textfield>

			<p id="displayMessageEmail"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield placeholder="Enter Email-ID" label="Email-ID"
				name="userForm.userContact.userEmailId" id=""
				tooltip="Enter Customer's Email-ID" inputPrepend="@"></s:textfield>

			<p id="displayMessageMobile"
				style="color: red; font-family: Eras Light ITC;"></p>
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
				<s:submit value="ADD" id="submit"
					cssClass="btn btn-large btn-danger"></s:submit>
			</center>

		</s:form>
	</div>
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.8/jquery.validate.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#newCustForm').validate({
				rules : {
					"userForm.userName" : {
						required : true

					},
					"userForm.userDOB" : {
						required : true
					},
					"userForm.userMaritialStatus" : {
						required : true
					},
					"userForm.account.accountType" : {
						required : true
					},
					"userForm.occupation" : {
						required : true
					},
					"userForm.userContact.userEmailId" : {
						required : true
					},
					"userForm.userContact.userMobileNumber" : {
						required : true,
						number : true

					},
					"userForm.userGender" : {
						required : true
					},
					"userForm.userContact.userCity" : {
						required : true
					},
					"userForm.userContact.userAddress" : {
						required : true
					},
					"userForm.userContact.userPin" : {
						required : true,
						number : true
					}
				}
			});
		});
	</script>
	<br>
	<br>
	<center>

		<div
			style="background-color: black; clear: both; position: relative; z-index: 10; height: 3em; margin-top: -3em;">
			<p
				style="color: white; font-size: large; font-family: Copperplate Gothic Light;">
				Copyright &copy; Techlabs
				<script>
					document.write(new Date().getFullYear())
				</script>

			</p>

		</div>
	</center>

</body>
</html>