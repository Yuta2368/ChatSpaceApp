<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/main.jsp">
	<c:param name="content">
		<div id="main">
			<h2>トピックを投稿する</h2>
			<form>
				<input id="title" type="text" name="title" placeholder="タイトルを書く" class="input-topic-title">
				<textarea id="textarea" name="text" placeholder="本文を書く" class="input-topic-content"></textarea>
				<input id="submit" type="submit" value="トピックを投稿する" class="submit-topic">
			</form>
		</div>
	</c:param>
</c:import>