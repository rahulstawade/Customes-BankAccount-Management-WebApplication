<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sb:head />
<title>Welcome Employee</title>
</head>
<body background="woody.jpg">
	<jsp:include page="masterpage/employeeNavBar.jsp"></jsp:include>
	<br>
	<h2
		style="font-family: Lucida Handwriting; font-size: xx-large; color: red;"
		align="center">
		Welcome
		<s:property value="welcomeEmpName" />
		, To Banking Application.
	</h2>
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
	<br>
	<p
		style="color: white; font-family: Bradley Hand ITC; font-size: x-large;"
		align="left">
		<ins>
			<b>Employee Name</b>
		</ins>
		:- &nbsp;
		<s:property value="welcomeEmpName" />
		<br>
		<ins>
			<b>Employee Department</b>
		</ins>
		:- &nbsp;
		<s:property value="welcomeEmpDepartment" />
		<br>
		<ins>
			<b>Employee Contact Number</b>
		</ins>
		:- &nbsp;
		<s:property value="welcomeEmpContact" />

	</p>

	<jsp:include page="masterpage/footer.jsp"></jsp:include>