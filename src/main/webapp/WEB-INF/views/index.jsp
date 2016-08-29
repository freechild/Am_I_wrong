<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<!-- IE -호환성 문제 해결 -->
 <meta http-equiv="X-UA-Compatible" content="IE=Edge">
 <meta http-equiv="Content-Script-Type" content="text/javascript">
 <meta http-equiv="Content-Style-Type" content="text/css">
 
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/login.css" />
<script src="/resources/js/mainIn.js"></script>
<script src="/resources/js/front.js"></script>

</head>
<body>
	<input type="text" value="${sessionScope.email }" id="scope">
	<input type="text" value="${sessionScope.m_idx }" id="scope_idx">
	<input type="hidden" value="${date.year}" id="year">
	<input type="hidden" value="${date.month }" id="month">
	<input type="hidden" value="${date.firstDay }" id="firstDay">
	<input type="hidden" value="${date.lastDay }" id="lastDay">
	<div class="joinForm" id="stylized"></div>	
	<div id="overlay"></div>
	
	<div class="main-container">
		<!-- HEADER -->
		<header class="block">
		<ul class="header-menu horizontal-list">
			<li><a class="header-menu-tab" id="main" href="main"><span
					class="icon entypo-cog scnd-font-color"></span>Home</a></li>
			<li><a class="header-menu-tab" id="board" href="board"><span
					class="icon fontawesome-user scnd-font-color"></span>Board</a></li>
			<li><a class="header-menu-tab" href="#3"><span
					class="icon fontawesome-envelope scnd-font-color"></span>Messages</a> <a
				class="header-menu-number" href="#4">5</a></li>
			<li><a class="header-menu-tab" href="#5"><span
					class="icon fontawesome-star-empty scnd-font-color"></span>Favorites</a>
			</li>
		</ul>
		<div class="profile-menu">
			<p>
				Me <a href="#26"><span class="entypo-down-open scnd-font-color"></span></a>
			</p>
			<div class="profile-picture small-profile-picture"></div>
		</div>
		</header>
		
		<!-- 왼쪽 메뉴박스-->
		<div class="left-container container">
			<div class="menu-box block">
				<!-- MENU BOX (LEFT-CONTAINER) -->
				<h2 class="titular">MENU BOX</h2>
				<ul class="menu-box-menu">
					<li><a class="menu-box-tab" href="message">
					<span class="icon fontawesome-envelope scnd-font-color"></span>Messages
							<div class="menu-box-number">24</div></a></li>
					<li><a class="menu-box-tab" href="invites"><span
							class="icon entypo-paper-plane scnd-font-color"></span>Invites
							<div class="menu-box-number">3</div></a></li>
					<li><a class="menu-box-tab" href="#10"><span
							class="icon entypo-calendar scnd-font-color"></span>Events
							<div class="menu-box-number">5</div></a></li>
					<li><a class="menu-box-tab" href="#12"><span
							class="icon entypo-cog scnd-font-color"></span>Account Settings</a></li>
					<li><a class="menu-box-tab" href="#13">
					<sapn class="icon entypo-chart-line scnd-font-color"></sapn>Statistics</a>
					</li>
				</ul>
			</div>
			<!-- RIGHT-CONTAINER -->
			<div class="right-container container">
				<!-- 전체 움직이는 로그인부분 테이블 감싸야함 -->
				<div class="calendar-month block">

					<div class="arrow-btn-container"></div>
					<!-- 갤린더 수정부분 -->
					<table class="calendar">
						<thead class="days-week">
							<tr>
								<th>S</th>
								<th>M</th>
								<th>T</th>
								<th>W</th>
								<th>R</th>
								<th>F</th>
								<th>S</th>
							</tr>
						</thead>		
						<tbody class="calendar_N"></tbody>
					</table>
				</div>
				<!-- end calendar-month block -->
			</div>
			<!-- end right-container -->
		</div>
		<!-- end main-container -->

			
		
</body>
</html>
