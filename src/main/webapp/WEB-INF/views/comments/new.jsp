<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/main.jsp">
	<c:param name="content">
		<div id="main">
			<h2>コメントを投稿する</h2>
			<form>
				<textarea id="textarea" name="text" placeholder="コメントを書く" class="input-topic-content"></textarea>
				<input id="submit" type="submit" value="コメントを投稿する" class="submit-topic">
			</form>
		</div>
	</c:param>
</c:import>