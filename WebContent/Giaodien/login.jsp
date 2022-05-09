<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập Movies</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="/ASIMJAVA4/Giaodien/Dep/chinh.css">
</head>

<body>
    <header>
        <a href="#" class="logo">
            <i class='bx bxs-movie-play'></i> Movies
        </a>
        <div class="bx bx-menu" id="menu-icon"></div>
        <ul class="navbar">
            <li> <a href="trangchu.jsp" class="home-active"> Home</a> </li>
            <li> <a href="trangchu.jsp"> Movies</a> </li>
            <li> <a href="trangchu.jsp"> Coming</a> </li>
            <li> <a href="trangchu.jsp"> Newsletter</a> </li>
        </ul>
    </header>
    <div class="center">
        <h1> Login</h1>
        <form action="/ASIMJAVA4/dangnhap/login" method="post">
            <div class="txt_field">
                <input name="usid" type="text" required>
                <span></span>
                <label>Username</label>
            </div>
            <div class="txt_field">
                <input name="pass" type="password" required>
                <label>Password</label>
                <span></span>
            </div>
            <div class="pass"> <a href="/ASIMJAVA4/Giaodien/quenpass.jsp"> Forgot Password?</a> </div>
            <input type="submit" formaction="/ASIMJAVA4/dangnhap/login" value="Login">
            <div class="signup_link">
                Not a member? <a href="/ASIMJAVA4/Giaodien/SignUp.jsp"> Sign up</a>
            </div>
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