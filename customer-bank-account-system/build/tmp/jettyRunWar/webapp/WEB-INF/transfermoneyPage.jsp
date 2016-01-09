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
<title>Transfer Money</title>
<sb:head />
</head>
<body background="stripes-2.jpg">
	<jsp:include page="masterpage/customerNavBar.jsp"></jsp:include>	
	<h2
		style="font-family: Lucida Handwriting; font-size: xx-large; color: red;"
		align="center">Transfer Money</h2>
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
		<s:form action="transferMoneyAction" method="post" theme="bootstrap"
			cssClass="well form-horizontal" id="transferMoneyForm">


			<p id="displayMessageAccountNo"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:select list="listOfAccountIds" label="Select Your Account ID"
				name="accountId" id="accID" headerKey=""
				headerValue="-- Select Account --"
				tooltip="Account from which you want to transfer money">
			</s:select>


			<s:select list="listOfPayeeAccountIds" label="Select Payee "
				name="payeeId" id="" headerKey="" headerValue="-- Select Payee --"
				tooltip="Select the Payee to which Amount is to be Transferred ">
			</s:select>


			<p id="displayMessageAmount"
				style="color: red; font-family: Eras Light ITC;"></p>
			<s:textfield placeholder="Enter Amount" label="Amount "
				name="userForm.account.amount" id="amountId"
				tooltip="Enter Amount to be Transferred"
				inputPrependIcon="glyphicon glyphicon-asterisk"></s:textfield>


			<s:password placeholder="Enter Current Password" label="Password "
				name="userForm.userPassword" id="passwordcheckId"
				tooltip="Enter Current Password"
				inputPrependIcon="glyphicon glyphicon-star-empty"
				onkeyup="checkPasswordFilled()"></s:password>
			<p id="displayPassword"
				style="color: red; font-family: Eras Light ITC;" align="center"></p>

			<script type="text/javascript">
				function checkPasswordFilled() {
					var password = document.getElementById("passwordcheckId").value;
					if (password == "") {
						document.getElementById("submit").disabled = true;
						document.getElementById("displayPassword").innerHTML = "Please Enter Password To proceed";
					} else {
						document.getElementById("displayPassword").innerHTML = "";
						document.getElementById("submit").disabled = false;
					}
				}
			</script>
			<br>
			<br>
			<center>
				<s:submit value="Transfer" id="submit"
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
			$('#transferMoneyForm').validate({
				rules : {
					"accountId" : {
						required : true
					},
					"payeeId" : {
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