<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/main.jsp">
	<c:param name="content">
		<div id="main">
			<h2>トピック一覧</h2>
			<c:forEach var="topic" items="${topics}">
				<ul>
					<li>
						<a href="<c:url value='/topics/show?id=${topic.id}' />">
							<div>
								<span><c:out value="${topic.id}" /></span>
								<span><fmt:formatDate value='${topic.updatedAt}' pattern='yyyy/MM/dd hh:mm:ss' /></span>
								<span>コメント数：<c:out value="${topic.commentNum}" /></span>
							</div>
							<p><c:out value="${topic.description}" /></p>
						</a>
					</li>
				</ul>
			</c:forEach>
			<a class="btn-entry-topic" href="<c:url value='/topics/new' />">トピックを投稿する</a>
		</div>
	</c:param>
</c:import>