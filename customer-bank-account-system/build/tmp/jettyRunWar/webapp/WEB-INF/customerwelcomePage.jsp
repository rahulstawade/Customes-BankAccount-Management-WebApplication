<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sb:head />
<title>Welcome Customer</title>

</head>
<body background="stripes-2.jpg">
	<jsp:include page="masterpage/customerNavBar.jsp"></jsp:include>

	<br>
	<h2
		style="font-family: Lucida Handwriting; font-size: xx-large; color: red;"
		align="center">Account Details</h2>

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
		<table align="center" class="table table-hover"
			style="color: red; background-color: white; font-family: Bradley Hand ITC; font-weight: bold;">
			<thead>
				<th
					style="background-color: black; font-family: Copperplate Gothic Bold; font-size: 20px;">
					<center>Account Number</center>
				</th>
				<th
					style="background-color: black; font-family: Copperplate Gothic Bold; font-size: 20px;"><center>Account
						Type</center></th>
				<th
					style="background-color: black; font-family: Copperplate Gothic Bold; font-size: 20px;"><center>Customer
						Balance</center></th>
			</thead>

			<s:iterator value="listOfAccounts" var="accountList">
				<tbody>
					<tr>
						<td style="color: blue;"><center>
								<s:property value="#accountList.accountId" />
							</center></td>
						<td style="color: blue;"><center>
								<s:property value="#accountList.accountType" />
							</center></td>
						<td style="color: blue;"><center>
								<s:property value="#accountList.accountBalance" />
							</center></td>
					</tr>
				</tbody>
			</s:iterator>

		</table>
	</div>

	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.8/jquery.validate.min.js"></script>

	<jsp:include page="masterpage/footer.jsp"></jsp:include>