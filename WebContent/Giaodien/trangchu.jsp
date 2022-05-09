<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Movie Website</title>
<link rel="stylesheet" href="/ASIMJAVA4/Giaodien/Dep/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<!--css-->
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
</head>
<style>
.navbar>li>a>img {
	width: 35px !important;
	height: 35px !important;
}

</style>
<body>
	<header>
		<a href="/ASIMJAVA4/trangchu" class="logo"> <i class='bx bxs-movie-play'></i> Movies
		</a>
		<div class="bx bx-menu" id="menu-icon"></div>
		<ul class="navbar">
			<li><a href="#home" class="home-active"> Home</a></li>
			<li><a href="#movies"> Movies</a></li>
			<li><a href="#coming"> Coming</a></li>
			<li><a href="#newsletter"> Newsletter</a></li>
			<c:if test="${vaitro == false}">

			</c:if>
			<c:if test="${vaitro == true}">
				<li><a href="/ASIMJAVA4/qlvuser">Quản lý User</a></li>
				<li><a href="/ASIMJAVA4/qlvideo">Quản lý Video</a></li>
			</c:if>
			<li><a href="/ASIMJAVA4/edit?usid=${user.usid}">${user.usid}</a></li>
			<li><a href="/ASIMJAVA4/dangnhap/logout">Đăng xuất</a></li>
		</ul>
	</header>
	<!--home-->
	<section class="home" id="home">
		<div class="swiper-wrapper">

			<div class="swiper-slide conatiner">
				<img src="/ASIMJAVA4/Giaodien/image/wanda-banner.jpg" alt="">
				<div class="home-text">
					<span>Marvel Universe</span>
					<h1>
						Venom: Let There <br> Be Carnage
					</h1>
					<a href="#" class="btn"> WATCH NOW</a> <a href="#" class="play">
						<i class='bx bx-play'></i>
					</a>
				</div>
			</div>

			<!--Xox2-->
			<div class="swiper-slide conatiner">
				<img src="/ASIMJAVA4/Giaodien/image/transformer-banner.jpg" alt="">
				<div class="home-text">
					<span>Marvel Universe</span>
					<h1>
						Avengers: <br> Infinity War
					</h1>
					<a href="#" class="btn"> WATCH NOW</a> <a href="#" class="play">
						<i class='bx bx-play'></i>
					</a>
				</div>
			</div>
			<!--Xox3-->
			<div class="swiper-slide conatiner">
				<img src="/ASIMJAVA4/Giaodien/image/black-banner.png" alt="">
				<div class="home-text">
					<span>Marvel Universe</span>
					<h1>
						Spider-Man: <br> Far form Home
					</h1>
					<a href="#" class="btn"> WATCH NOW</a> <a href="#" class="play">
						<i class='bx bx-play'></i>
					</a>
				</div>
			</div>
		</div>

		<div class="swiper-pagination"></div>
	</section>
	<!--Movies-->
	<section class="movies" id="movies">
		<h2 class="heading">Opening This Week</h2>
		<!--Conatiner-->
		<div class="movies-container">
			<c:forEach var="vs" items="${vid}">
				<a href="/ASIMJAVA4/trangcon?vdid=${vs.vdid }">
					<div class="box">
						<div class="box-img">
							<img src="/ASIMJAVA4/Giaodien/image/${vs.hinh}" alt="">
						</div>
						<h3>${vs.tieude}</h3>
						<span>120 min | Action</span>
					</div>
				</a>

			</c:forEach>


		</div>
	</section>
	<!--Coming-->
	<section class="coming" id="coming">
		<h2 class="heading">My favorites</h2>
		<!-- Coming Container-->
		<div class="coming-container swiper">
			<div class="swiper-wrapper">
				<!--box1-->
				<c:forEach var="vs" items="${yeu}">
					<a href="/ASIMJAVA4/trangcon?vdid=${vs.vdid}">
					<div class="swiper-slide box">
						<div class="box-img">
							<img src="/ASIMJAVA4/Giaodien/image/${vs.hinh}" alt="">
						</div>
						<h3>${vs.tieude}</h3>
						<span> 120 min | Action</span>
					</div>
					</a>
				</c:forEach>
			</div>
		</div>
	</section>
	<!--NewLetter-->
	<!-- Footer -->
	<section class="footer">
		<a href="#" class="logo"> <i class='bx bxs-movie'></i> Movies
		</a>
		<div class="social">
			<a href="https://www.facebook.com/coderpoly"><i
				class='bx bxl-facebook-circle'></i></a> <a
				href="https://twitter.com/home"><i class='bx bxl-twitter'></i></a> <a
				href="https://www.instagram.com/"><i class='bx bxl-instagram'></i></a>
			<a href="https://www.tiktok.com/"><i class='bx bxl-tiktok'></i></a>
	</section>
	<!--Copyright-->
	<div class="Copyright">
		<p>CarpoolVenom All Right Reserved</p>
	</div>

	<!-- Swiper JS -->
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<script src="/ASIMJAVA4/Giaodien/Main/main.js"></script>
</body>

</html>