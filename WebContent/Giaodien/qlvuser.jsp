<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản lý User</title>
<link rel="stylesheet" href="/ASIMJAVA4/Giaodien/Dep/video.css ">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
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
	<section class="home" id="home">

		<div class="row">
			<div class="col">
				<form action="/ASIMJAVA4/qlvuser" method="post">
					<div class="form-group">
						<label for="Id">User ID:</label> <input value="${binh1.usid}"
							type="text" name="usid" class="form-control">
					</div>
					<div class="form-group">
						<label for="pass">Password:</label> <input value="${binh1.pass}"
							type="password" name="pass" class="form-control">
					</div>
					<div class="form-group">
						<label for="fullname">FullName:</label> <input
							value="${binh1.hoten}" type="text" name="hoten"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="text" name="email"
							class="form-control" value="${binh1.email}">
					</div>
					<div class="form-check form-check-inline">
						<label for="">Role: </label><br> 
						<label class="ml-2"><input
							${binh1.vaitro?'checked':''} type="radio" name="quyen"
							 required value="true" class="form-check-input">Admin</label><br> <label
							class="ml-2"><input ${!binh1.vaitro?'checked':''}
							type="radio" name="quyen" required value="false" class="form-check-input">User</label>
					</div>
					<div class="form-group">
						<button formaction="/ASIMJAVA4/qlvuser/insert"
							class="btn btn-primary">
							<i class="bx bxs-add-to-queue"></i> Insert
						</button>
						<button formaction="/ASIMJAVA4/qlvuser/update"
							class="btn btn-danger">
							<i class="bx bx-repost"></i>Update
						</button>
						<button formaction="/ASIMJAVA4/qlvuser/reset"
							class="btn btn-primary">
							<i class="bx bxs-news"></i>Reset
						</button>

					</div>

				</form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-stripe">

					<tr>
						<td>User</td>
						<td>Fullname</td>
						<td>Password</td>
						<td>Email</td>
						<td>Role</td>
						<td>Click</td>
					</tr>
					<c:forEach var="binh" items="${user1}">
						<tr>
							<td>${binh.usid}</td>
							<td>${binh.hoten}</td>
							<td>${binh.pass}</td>
							<td>${binh.email}</td>
							<td>${binh.vaitro? 'Admin':'User'}</td>
							<td><a href="/ASIMJAVA4/qlvuser/edit?usid=${binh.usid}">Edit</a>
								<a href="/ASIMJAVA4/qlvuser/delete?usid=${binh.usid}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</section>

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