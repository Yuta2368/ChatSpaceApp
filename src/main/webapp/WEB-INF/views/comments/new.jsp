<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/main.jsp">
	<c:param name="content">
		<div id="main">
			<h2>コメントを投稿する</h2>
			<c:if test="${errors != null}">
	    		<div id="errors">
	        		<c:forEach var="error" items="${errors}">
	            		<c:out value="${error}" /><br />
	        		</c:forEach>
	    		</div>
			</c:if>
			<form method="POST" action="${pageContext.request.contextPath}/comments/create">
				<textarea id="textarea" name="content" placeholder="コメントを書く" class="input-topic-content"></textarea>
				<input type="hidden" name="_token" value="${_token}" />
				<input type="hidden" name="topicId" value="${topicId}" />
				<button type="submit" value="コメントを投稿する" class="submit-topic">コメントを投稿する</button>
			</form>
		</div>
	</c:param>
</c:import>