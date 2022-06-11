<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("newLine", "\n"); %>
<c:import url="../layout/main.jsp">
	<c:param name="content">
		<div id="main">
			<h2><c:out value="${topic.title}" /></h2>
			<h3>
				<c:forEach var="line" items="${fn:split(topic.description, newLine)}">
					<c:out value="${line}" /><br />
				</c:forEach>
				
			</h3>
				<c:forEach var="comment" items="${comments}" varStatus="status">
					<ul>
						<li>
							<div>
								<span><c:out value="${status.count}" /></span>
								<span><fmt:formatDate value='${comment.createdAt}' pattern='yyyy/MM/dd hh:mm:ss' /></span>
								<span>投稿者：<c:out value="${comment.user.name}" /></span>
							</div>
							<p class="comment-content">
								<c:forEach var="line" items="${fn:split(comment.content, newLine)}">
									<c:out value="${line}" /><br />
								</c:forEach>
							</p>
						</li>
					</ul>
				</c:forEach>
			<a class="btn-entry-comment" href="<c:url value='/comments/new?topicId=${topic.id}' />">コメントを投稿する</a>
		</div>
	</c:param>
</c:import>
