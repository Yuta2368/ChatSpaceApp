<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/main.jsp">
	<c:param name="content">
		<div id="main">
			<h2>トピック名</h2>
			<a href="#">コメントを投稿</a>
			<ul>
				<li>a</li>
				<li>b</li>
				<li>c</li>
			</ul>
			<form>
				<textarea rows="" cols=""></textarea>
				<button>コメントを投稿する</button>
			</form>
		</div>
	</c:param>
</c:import>