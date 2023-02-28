<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if(session.getAttribute("user")!=null){%>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<%@ include file="/includes/styles.html"%>
<%@ include file="/includes/homeNav.html" %>
<div class="error-body"><h3>${message}</h3></div>
<div class="redirect-body"><a href="${redirect}">back</a></div>
</body>
<script src="./js/bootstrap.bundle.min.js"></script>
</html>
<%}else{%>
<%@ include file="index.jsp"%>
<%} %>