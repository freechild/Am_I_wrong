<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">

	

</script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styles.css" />
</head>
<body>

	<div class="main-container">

		<!-- HEADER -->
		<header class="block">
		<ul class="header-menu horizontal-list">
			<li><a class="header-menu-tab" href="main"><span
					class="icon entypo-cog scnd-font-color"></span>Home</a></li>
			<li><a class="header-menu-tab" href="board"><span
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
					<li><a class="menu-box-tab" href="#6">
					<span class="icon fontawesome-envelope scnd-font-color"></span>Messages
							<div class="menu-box-number">24</div></a></li>
					<li><a class="menu-box-tab" href="#8"><span
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
				<div class="account block">
					<!-- ACCOUNT (RIGHT-CONTAINER) -->
					<h2 class="titular">SIGN IN TO YOUR ACCOUNT</h2>
					<div class="input-container">
						<input type="text" placeholder="E-mail" id="login"
							class="email text-input">
						<div class="input-icon envelope-icon-acount">
							<span class="fontawesome-envelope scnd-font-color"></span>
						</div>
					</div>
					<div class="input-container">
						<input type="text" placeholder="Password" id="login"
						class="password text-input">
						<div class="input-icon password-icon">
							<span class="fontawesome-lock scnd-font-color"></span>
						</div>
					</div>
					<a class="sign-in button" href="#22">SIGN IN</a>
					<p class="scnd-font-color">Forgot Password?</p>

				</div>


				<div class="calendar-month block">
					<!-- CALENDAR MONTH (RIGHT-CONTAINER) -->
					<div class="arrow-btn-container">
						<a class="arrow-btn left" href="#202"><span
							class="icon fontawesome-angle-left"></span></a>
						<h2 class="titular">APRIL 2013</h2>
						<a class="arrow-btn right" href="#203"><span
							class="icon fontawesome-angle-right"></span></a>
					</div>
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
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><a class="scnd-font-color" href="#100">1</a></td>
							</tr>
							<tr>
								<td><a class="scnd-font-color" href="#101">2</a></td>
								<td><a class="scnd-font-color" href="#102">3</a></td>
								<td><a class="scnd-font-color" href="#103">4</a></td>
								<td><a class="scnd-font-color" href="#104">5</a></td>
								<td><a class="scnd-font-color" href="#105">6</a></td>
								<td><a class="scnd-font-color" href="#106">7</a></td>
								<td><a class="scnd-font-color" href="#107">8</a></td>
							</tr>
							<tr>
								<td><a class="scnd-font-color" href="#108">9</a></td>
								<td><a class="scnd-font-color" href="#109">10</a></td>
								<td><a class="scnd-font-color" href="#110">11</a></td>
								<td><a class="scnd-font-color" href="#111">12</a></td>
								<td><a class="scnd-font-color" href="#112">13</a></td>
								<td><a class="scnd-font-color" href="#113">14</a></td>
								<td><a class="scnd-font-color" href="#114">15</a></td>
							</tr>
							<tr>
								<td><a class="scnd-font-color" href="#115">16</a></td>
								<td><a class="scnd-font-color" href="#116">17</a></td>
								<td><a class="scnd-font-color" href="#117">18</a></td>
								<td><a class="scnd-font-color" href="#118">19</a></td>
								<td><a class="scnd-font-color" href="#119">20</a></td>
								<td><a class="scnd-font-color" href="#120">21</a></td>
								<td><a class="scnd-font-color" href="#121">22</a></td>
							</tr>
							<tr>
								<td><a class="scnd-font-color" href="#122">23</a></td>
								<td><a class="scnd-font-color" href="#123">24</a></td>
								<td><a class="scnd-font-color" href="#124">25</a></td>
								<td><a class="today" href="#125">26</a></td>
								<td><a href="#126">27</a></td>
								<td><a href="#127">28</a></td>
								<td><a href="#128">29</a></td>
							</tr>
							<tr>
								<td><a href="#129">30</a></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- end calendar-month block -->
			</div>
			<!-- end right-container -->
		</div>
		<!-- end main-container -->

			
		
</body>
</html>
