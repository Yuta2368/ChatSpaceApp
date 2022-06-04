<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/main.jsp">
	<c:param name="content">
		<div id="main">
			<h2><c:out value="${topic.description}" /></h2>
				<c:forEach var="comment" items="${comments}">
					<ul>
						<li>
							<div>
								<span><c:out value="${comment.id}" /></span>
								<span><fmt:formatDate value='${comment.createdAt}' pattern='yyyy/MM/dd hh:mm:ss' /></span>
							</div>
							<p><c:out value="${comment.content}" /></p>
						</li>
					</ul>
				</c:forEach>
			<a class="btn-entry-comment" href="<c:url value='/comments/new' />">コメントを投稿する</a>
		</div>
	</c:param>
</c:import>
