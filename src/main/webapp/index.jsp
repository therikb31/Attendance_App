<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<%@ include file="./includes/styles.html"%>
<link rel="stylesheet" href="./css/index.css">
</head>
<body>
	<div class="col">
		<div class="row">
			<%@ include file="./includes/homeNav.html"%>
		</div>
		<%@ include file="./includes/login.html"%>
	</div>
	<script src="./js/index.js"></script>
	<%@ include file="./includes/scripts.html"%>
</body>
</html>