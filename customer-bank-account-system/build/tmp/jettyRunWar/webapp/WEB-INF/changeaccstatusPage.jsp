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
<title>Change Status</title>
<sb:head />
<sj:head jqueryui="true" />
</head>
<body background="woody.jpg">
	<jsp:include page="masterpage/employeeNavBar.jsp"></jsp:include>

	<h2
		style="font-family: Lucida Handwriting; font-size: xx-large; color: red;"
		align="center">Change Customer Status</h2>
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
		<s:form action="fetchValues" method="post" theme="bootstrap"
			cssClass="well form-horizontal" id="changeStatus1Form">


			<p id="displayMessageUserID"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield label="User-ID" placeholder="Enter User-ID"
				name="userForm.userId" id="" tooltip="User ID"
				inputPrependIcon="glyphicon glyphicon-search"></s:textfield>



			<center>
				<s:submit value="Fetch Details" id="submit"
					cssClass="btn btn-medium btn-info"></s:submit>
			</center>
		</s:form>

		<s:form action="changeAccountStatusAction" method="post"
			theme="bootstrap" cssClass="well form-horizontal">
			<s:hidden name="hiddenField"></s:hidden>

			<s:textfield label="Customer Name" name="userForm.userName"
				id="nameId" tooltip="Customer's Name"
				inputPrependIcon="glyphicon glyphicon-user" disabled="true"></s:textfield>

			<s:textfield label="Customer Email-Id"
				name="userForm.userContact.userEmailId" id="EmailId"
				tooltip="Customer's Email-Id" inputPrepend="@" disabled="true"></s:textfield>

			<s:textfield label="Mobile Number"
				name="userForm.userContact.userMobileNumber" id="mobileId"
				tooltip="Customer's Mobile Number"
				inputPrependIcon="glyphicon glyphicon-phone" disabled="true"></s:textfield>

			<s:select list="{'LOCKED','ACTIVE'}" label="Change Account Status "
				name="userForm.userAccountStatus" id="statusId" headerKey=""
				headerValue="-- Select Accout Status  --"
				tooltip="Select Type of Account"></s:select>

			<br>
			<br>
			<center>
				<s:submit value="Change Status" id="submit"
					cssClass="btn btn-medium btn-danger"></s:submit>
			</center>


		</s:form>
	</div>
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.8/jquery.validate.min.js"></script>


	<script type="text/javascript">
		$(document).ready(function() {
			$('#changeStatus1Form').validate({
				rules : {
					"userForm.userId" : {
						required : true,
						number : true
					}
				}
			});
		});
	</script>



	<jsp:include page="masterpage/footer.jsp"></jsp:include>