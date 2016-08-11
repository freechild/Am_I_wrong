<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html >
<jsp:include page="index.jsp" />

<article>
	name : <c:out value="${vo.name }" /> ,
	ip : <c:out value="vo.ip" /> , 
	likes : <c:out value="${vo.hit }" /><br>
	title : <c:out value="${vo.title }" /> ,
	Date : <fmt:formatDate value="${vo.regdate }"/>   ->
	${category }<hr>
	
	<c:set var ="content1" value="${vo.content } "/>
				<c:set var="content1" value="${fn:replace(content1,'<','&lt;') }"/>
				<c:set var="content1" value="${fn:replace(content1,newLine,br) }"/>
				${content1 }
	<hr>
	<div align="right">	
		<input type="button" value="수정">
		<input type="button" value="삭제">
		<input type="button" value=" 돌아가기 " onclick="history.back()" />
	</div>
	<hr>
	<br>
	<div>
		<c:if test="${empty clist }">
			댓글이 없습니다.${cid }
		</c:if>
		<c:if test="${! empty clist }">
			<c:forEach var="c" items="clist">
				<c:out value="${c.name }" />
				<fmt:formatDate value="${c.regdate }" /> <br>
				<c:set var ="content2" value="${c.content } "/>
				<c:set var="content2" value="${fn:replace(content1,'<','&lt;') }"/>
				<c:set var="content2" value="${fn:replace(content1,newLine,br) }"/>
				${content2 }
			</c:forEach>
		</c:if>		
	</div>
	<hr>
	
</article>

