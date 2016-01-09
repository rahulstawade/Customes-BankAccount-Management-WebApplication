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
		align="center">Add Account</h2>
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
	<br>
	<div class="container">

		<s:form action="addNewCustAccountAction" method="post"
			theme="bootstrap" cssClass="well form-horizontal" id="addAccForm">

			<p id="displayMessageUId"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield placeholder="Customer's Id" label="Enter Customer Id"
				name="userForm.userId" id="userId" tooltip="Customer's Id"
				inputPrependIcon="glyphicon glyphicon-user"></s:textfield>

			<s:select list="{'SAVING','CURRENT','FD','RECCURING'}"
				label="Account Type " name="userForm.account.accountType" id=""
				headerKey="" headerValue="Select Account Type"
				tooltip="Select Type of Account">
			</s:select>
			<br>
			<br>
			<center>
				<s:submit value="Add Account" id="submit"
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
			$('#addAccForm').validate({
				rules : {
					"userForm.userId" : {
						required : true,
						number : true
					},
					"userForm.account.accountType" : {
						required : true
					}
				}
			});
		});
	</script>

	<jsp:include page="masterpage/footer.jsp"></jsp:include>