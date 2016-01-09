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
<title>Manage Acc</title>
<sb:head />
<sj:head jqueryui="true" />
</head>
<body background="woody.jpg">
	<jsp:include page="masterpage/employeeNavBar.jsp"></jsp:include>

	<h2
		style="font-family: Lucida Handwriting; font-size: xx-large; color: red;"
		align="center">Manage Customer Account</h2>
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
		<s:form action="getAccountList" method="post" theme="bootstrap"
			cssClass="well form-horizontal" id="getListForm">

			<p id="displayMessageUserID"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield placeholder="Enter Customer's ID" label="User-ID"
				name="userForm.userId" id="" tooltip="User ID"
				inputPrependIcon="glyphicon glyphicon-user"></s:textfield>
			<br>
			<center>
				<s:submit value="Get Accounts" id="submit"
					cssClass="btn btn-large btn-info"></s:submit>
			</center>

		</s:form>

		<s:form action="manageCustomerAccountAction" method="post" theme="bootstrap"
			cssClass="well form-horizontal" id="manageCustForm">

			<s:select list="listOfAccountIds" label="Select Account "
				name="userForm.account.accountId" id="accountId" headerKey=""
				headerValue="Select Account"
				tooltip="Select Account on which Operetion is to be Performed"
				onchange="callgetBalAction()">
			</s:select>

			<script type="text/javascript">
				function callgetBalAction() {
					var id = document.getElementById("accountId").value;
					alert("Selected account id is :- " + id);
					window.location.href = "getAccountBalance?accid=" + id;
				}
			</script>
			<s:hidden name="hiddenField"></s:hidden>
			<p
				style="color: red; font-family: Bradley Hand ITC; font-weight: bold; padding-left: 25%; font-size: large;">
				Selected Account Id is :
				<s:property value="hiddenField" />
			</p>

			<p id="displayMessageBalance"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield label="Balance" name="balance" id="" tooltip="Balance"
				inputPrependIcon="glyphicon glyphicon-asterisk" disabled="true"></s:textfield>

			<s:select list="{'DEPOSITE','WITHDRAW'}" label="Select Action "
				name="userForm.account.accountOperation" id="" headerKey=""
				headerValue="Select Action"
				tooltip="Select Type of Action you want to perform">
			</s:select>

			<p id="displayMessageAmount"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield label="Amount" name="userForm.account.amount" id=""
				tooltip="Enter Amount"
				inputPrependIcon="glyphicon glyphicon-asterisk" requiredLabel="true"></s:textfield>
			<br>
			<br>
			<center>
				<s:submit value="Update Account" id="submit"
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
			$('#getListForm').validate({
				rules : {
					"userForm.userId" : {
						required : true,
						number : true
					}
				}
			});
		});
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#manageCustForm').validate({
				rules : {
					"userForm.account.accountOperation" : {
						required : true
					},
					"userForm.account.amount" : {
						required : true,
						number : true
					}
				}
			});
		});
	</script>

	<jsp:include page="masterpage/footer.jsp"></jsp:include>