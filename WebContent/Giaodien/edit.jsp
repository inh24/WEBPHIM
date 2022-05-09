<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa thông tin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="/ASIMJAVA4/Giaodien/Dep/edit.css">
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
    <div class="center">
        <h1> Edit Profile</h1>
        <form action="/ASIMJAVA4/edit" method="post">
            <div class="txt_field">
                <input type="text" name="usid" required value="${user.usid}">
                <span></span>
                <label>Username</label>
            </div>
            <div class="txt_field">
                <input type="password" name="pass" required value="${user.pass}">
                <label>Password</label>
                <span></span>
            </div>
            <div class="txt_field">
                <input type="text" name="hoten" required value="${user.hoten}">
                <span></span>
                <label>Fullname</label>
            </div>
            <div class="txt_field">
                <input type="Email" name="email" required value="${user.email}">
                <span></span>
                <label>Email Address</label>
            </div>
            <input type="submit"  formaction="/ASIMJAVA4/edit/chinhsua" value="Update">
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