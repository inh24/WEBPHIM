<!DOCTYPE html>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ÄÄng nháº­p Movies</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="/ASIMJAVA4/Giaodien/Dep/doipass.css">
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
			
		</ul>
	</header>
    <div class="center">
        <h1> Change Password</h1>
        <form action="/ASIMJAVA4/quenpass" method="post">
            <div class="txt_field">
                <input type="text" name="usid" required>
                <span></span>
                <label>Username</label>
            </div>
     
            <div class="txt_field">
                <input type="email"  name="email" required >
                <label> Email</label>
                <span></span>
            </div>
  
            <input type="submit" value="Xác nhận">
        </form>
    </div>
    <!-- Footer -->
    <section class="footer">
        <a href="#" class="logo">
            <i class='bx bxs-movie'></i> Movies
        </a>
        <div class="social">
            <a href="https://www.facebook.com/coderpoly"><i class='bx bxl-facebook-circle'></i></a>
            <a href="https://twitter.com/home"><i class='bx bxl-twitter'></i></a>
            <a href="https://www.instagram.com/"><i class='bx bxl-instagram'></i></a>
            <a href="https://www.tiktok.com/"><i class='bx bxl-tiktok'></i></a>
    </section>
    <!--Copyright-->
    <div class="Copyright">
        <p> CarpoolVenom All Right Reserved</p>
    </div>
     <!-- Swiper JS -->
     <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
     <script src="/ASIMJAVA4/Giaodien/Main/main.js"></script>
 </body>
</body>

</html>