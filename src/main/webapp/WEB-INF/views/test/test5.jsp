<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Check Buttons</title>
<style>

/*location & align*/
.loginBtn {
  margin: 80px auto;
  width: 460px;
  text-align: center;
}
/* 버튼간격*/
.loginBtn > .button {
  margin: 0 12px;
}

.loginBtn .button {
  display: inline-block;
  vertical-align: top;
  height: 48px;
  line-height: 46px;
  padding: 0 25px;
  font-family: inherit;
  font-size: 15px;
  color: #bbb;
  text-align: center;
  text-decoration: none;
  text-shadow: 0 0 2px rgba(0, 0, 0, 0.7);
  background-color: #303030;
  background-clip: padding-box;
  border: 1px solid;
  border-color: #202020 #1a1a1a #111;
  border-radius: 25px;
  background-image: -webkit-linear-gradient(top, #3d3d3d, #272727);
  background-image: -moz-linear-gradient(top, #3d3d3d, #272727);
  background-image: -o-linear-gradient(top, #3d3d3d, #272727);
  background-image: linear-gradient(to bottom, #3d3d3d, #272727);
  -webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.09), 0 1px 3px rgba(0, 0, 0, 0.3);
  box-shadow: inset 0 1px rgba(255, 255, 255, 0.09), 0 1px 3px rgba(0, 0, 0, 0.3);
}

.loginBtn .button:active, .button.active {
  line-height: 48px;
  color: #ccc;
  background-color: #b42f32;
  border-color: #1c1c1c #202020 #222;
  background-image: -webkit-linear-gradient(top, #a3161a, #b63335 60%, #bf4749);
  background-image: -moz-linear-gradient(top, #a3161a, #b63335 60%, #bf4749);
  background-image: -o-linear-gradient(top, #a3161a, #b63335 60%, #bf4749);
  background-image: linear-gradient(to bottom, #a3161a, #b63335 60%, #bf4749);
  -webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.09);
  box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.09);
}

</style>
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
  <div class="loginBtn">
    <a href="#" class="button">id 찾기</a>
    
    <a href="#" class="button button-check">OK</a>
  </div>


</body>
</html>
