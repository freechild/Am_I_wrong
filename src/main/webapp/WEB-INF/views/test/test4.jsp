<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript"src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/include.js"></script>
<script src="${pageContext.request.contextPath}/resources/util.js"></script>
</head>

<body>
	<a href="javascript:;" onclick="javascript:showPopup()">팝업띄우기</a>
	
	<div id="popLayer" style="display:none;">
		<div>팝업 레이어입니다.</div>
	</div>
</body>
</html>
