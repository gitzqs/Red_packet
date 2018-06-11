<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspf/taglibs.jsp" %>
<!doctype html>
<html>
<div class="top_bk">
	<div class="top">
		<img src="${ctx}/img/logo.png">
		<!-- <div class="gl">
			<a href="">超级管理</a>	
		</div>
 -->		<div class="tuichu">
			<c:if test="${user.loginName eq null}">
			    <a href="${ctx}/login/">[登录]</a>
			</c:if>
			<c:if test="${user.loginName ne null}">
			    <a href="${ctx}/logout/">[退出]</a>
			</c:if>
		</div>
		<c:if test="${user.loginName ne null}">
			<div class="huanying">你好，${user.loginName}！</div>
		</c:if>
		<div class="clearfix"></div>
	</div>
</div>


	
</body>
</html>
