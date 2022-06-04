<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta content="text/html; charset=UTF-8">
	<title>Chat Space App.</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	<link rel="stylesheet" href="<c:url value='/css/main.css' />">
</head>
<body>
	<div id="header">
		<h1>
			<a href="<c:url value='/topics/index' />">Chat Space App.</a>
		</h1>
	</div>
	<div id="content">
		${param.content}
	</div>
	<div id="footer">
		Chat Space App. All Right Reserved.
	</div>
</body>
</html>