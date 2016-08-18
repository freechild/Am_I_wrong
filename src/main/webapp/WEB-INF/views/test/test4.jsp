<%@page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="kr">
<head>
<meta charset="UTF-8">
	<title>http://www.blueb.co.kr</title>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
	<link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
</head>
<style>

.myform p, h1, form, button{border:0; margin:0; padding:0;}
.spacer{clear:both; height:1px;}

.myform{
	margin:10px;
	width:400px;
	padding:14px;
}

#stylized{
	border:solid 2px #b7ddf2;
	background:#ebf4fb;
}
#stylized h1 {
	font-size:16px;
	font-weight:bold;
	margin-bottom:8px;
	font-family:nanumgothic,dotum;

}
#stylized p{
	font-size:11px;
	color:#666666;
	margin-bottom:20px;
	border-bottom:solid 1px #b7ddf2;
	padding-bottom:10px;
	font-family:dotum;
}
#stylized label{
	display:block;
	font-weight:bold;
	text-align:right;
	width:140px;
	float:left;
	font-family:tahoma;
}
#stylized .small{
	color:#666666;
	display:block;
	font-size:11px;
	font-weight:normal;
	text-align:right;
	width:140px;
	font-family:dotum;
	letter-spacing:-1px;
}
#stylized input{
float:left;
font-size:12px;
padding:4px 2px;
border:solid 1px #aacfe4;
width:200px;
margin:2px 0 20px 10px;
}
#stylized button{
clear:both;
margin-left:150px;
width:125px;
height:31px;
text-align:center;
line-height:31px;
background-color:#000;
color:#FFFFFF;
font-size:11px;
font-weight:bold;
font-family:tahoma;
}
</style>

<body>


<div id="stylized" class="myform">
<form id="form" name="form" method="post" action="board">
<h1>글쓰기 폼</h1>
<p>기본적인 입력폼입니다.</p>

<label>Name
<span class="small">이름 입력</span>
</label>
<input type="text" name="name" id="name" />

<label>Email
<span class="small">이메일주소</span>
</label>
<input type="text" name="email" id="email" />

<label>Password
<span class="small">패스워드 6자 이상</span>
</label>
<input type="text" name="password" id="password" />

<button type="submit">Sign-up</button>
<div class="spacer"></div>

</form>
</div>
</html>
