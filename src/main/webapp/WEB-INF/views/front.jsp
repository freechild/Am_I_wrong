<%@page contentType="text/html; charset=UTF-8" %>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	 <meta http-equiv="Content-Script-Type" content="text/javascript">
	 <meta http-equiv="Content-Style-Type" content="text/css">
 
	<title>Front</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/frontPage.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/login.css" />
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
	<script src="/resources/js/front.js"></script>
</head>
<body>
	<div class="joinForm" id="stylized"></div>	
	<div id="overlay"></div>
	<section class="front">
		<a href="javascript:showPopup('f_btn')" id="f_btn"><img src='/resources/Image/ic_power_settings.png'></a>
		<span></span>
	</section>
</body>
</html>