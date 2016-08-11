<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html >
<jsp:include page="index.jsp" />

<article>
	name :${vo.name } , ip :  ${vo.ip } , likes :  ${vo.hit } <br>
	title : ${vo.title } , Date : ${vo.regdate } , ${vo.categoryid }<hr>
	${vo.content }
</article>

