<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script src="./common/js/jquery-3.1.1.js"></script>
<script src="./common/js/angular.js"></script>
<script src="./common/app/controller.js"></script>

</head>
<body ng-app="app" >
	<div ng-controller="mainController">
		<input type="button" value="按钮" ng-click="click()"> 
<!-- 		<a href="test2.jsp">1111111111</a> -->
	</div>
	<div ng-controller="twoController">
		<input type="button" value="按钮" ng-click="click()"> 
<!-- 		<a href="test2.jsp">2222222222</a> -->
	</div>
</body>
</html>
