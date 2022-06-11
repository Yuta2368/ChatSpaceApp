<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/main.jsp">
	<c:param name="content">
		<div id="main">
			<h2>トピックを投稿する</h2>
			<c:if test="${errors != null}">
	    		<div id="errors">
	        		<c:forEach var="error" items="${errors}">
	            		<c:out value="${error}" /><br />
	        		</c:forEach>
	    		</div>
			</c:if>
			<form method="POST" action="${pageContext.request.contextPath}/topics/create">
				<input id="title" type="text" name="title" placeholder="タイトルを書く" class="input-topic-title">
				<textarea id="description" name="description" placeholder="本文を書く" class="input-topic-content"></textarea>
				<input type="hidden" name="_token" value="${_token}" />
				<button type="submit" value="トピックを投稿する" class="submit-topic">トピックを投稿する</button>
			</form>
		</div>
	</c:param>
</c:import>