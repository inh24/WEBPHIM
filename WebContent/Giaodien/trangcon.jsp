<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Movie Website</title>
<link rel="stylesheet" href="/ASIMJAVA4/Giaodien/Dep/trangcon.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<!--css-->
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<style>
.butt {
	margin-top: 20px;
}
</style>

</head>

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
	<section class="trangcon" id="trangcon">
		<div class="movies-container">
			<!--box1-->
			<div class="box">
				<h2>${vid.tieude}</h2>
				<div class="box-img">
					<iframe width="968" height="270" src="https://www.youtube.com/embed/${vid.video}?fs=0&?autoplay=0&?disablekb=1"></iframe>
				</div>

				<span> </span>
				<div class="butt">
					<a href="/ASIMJAVA4/trangcon/yeuthich?vdid=${vid.vdid}" class="btn">
						<c:if test="${favlike == false}">
							Thích
						</c:if> 
						<c:if test="${favlike == true}">
							Bỏ Thích
						</c:if>
					</a>
				</div>
			</div>
		</div>

	</section>
	<section class="movies" id="movies">
		<h2 class="heading">Opening This Week</h2>
		<!--Conatiner-->
		<div class="movies-container">
			<c:forEach var="vs" items="${video}">
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
		<h2 class="heading">Coming Soon</h2>
		<!-- Coming Container-->
		<div class="coming-container swiper">
			<div class="swiper-wrapper">
				<!--box1-->
				<c:forEach var="vs" items="${video}">
					<div class="swiper-slide box">
						<div class="box-img">
							<img src="/ASIMJAVA4/Giaodien/image/${vs.hinh}" alt="">
						</div>
						<h3>${vs.tieude }</h3>
						<span> 120 min | Action</span>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!--Coming-->

	<!--NewLetter-->
	<section class="newsletter" id="newsletter">
		<h2>
			Subscribe To Get <br>Newsletter
		</h2>
		<form action="/ASIMJAVA4/trangcon/share?vdid=${vid.vdid}"
			method="post">
			<input type="email" name="email" class="email"
				placeholder=" Enter Email..." required> <input type="submit"
				value="Share" class="btn">
		</form>
	</section>
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