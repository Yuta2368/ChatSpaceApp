<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/main.jsp">
	<c:param name="content">
		<div id="main">
			<h2>ログイン</h2>
			<form method="POST" action="<c:url value='/login' />">
				<input type="text" name="username" placeholder="ユーザ名" value="${userName}" class="input-user-id" />
				<input type="password" name="password" placeholder="パスワード"  value="" class="input-user-password" />
				<c:if test="${IsError}">
					<div id="login-errors">ユーザIDまたはパスワードが誤っています。</div>
				</c:if> 
				<input type="hidden" name="_token" value="${_token}" />
				<button type="submit" value="ログイン" class="submit-login">ログイン</button>
			</form>
		</div>
	</c:param>
</c:import>