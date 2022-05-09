package poly.com.Servlet;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.com.DAO.favoriteDAO;
import poly.com.DAO.shareDAO;
import poly.com.DAO.userDAO;
import poly.com.DAO.videoDAO;
import poly.com.JPA.sharehelper;
import poly.com.model.Favorite;
import poly.com.model.Share;
import poly.com.model.Users;
import poly.com.model.Videos;

/**
 * Servlet implementation class trangcon
 */
@WebServlet({ "/trangcon", "/trangcon/yeuthich", "/trangcon/share" })
public class trangcon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public trangcon() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (sharehelper.users == null) {
			request.getRequestDispatcher("/Giaodien/login.jsp").forward(request, response);
		} else {
			String duongdan = request.getRequestURI().toString();
			kiemtra(request, response);
			findAll(request, response);
			if (duongdan.contains("yeuthich")) {
				luu(request, response);
			}
			nguoidung(request, response);
			findvideo(request, response);
			request.getRequestDispatcher("/Giaodien/trangcon.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String duonglink = request.getRequestURI().toString();
		kiemtra(request, response);
		findAll(request, response);
		if (duonglink.contains("share")) {
			chiase(request, response);
		}

		nguoidung(request, response);
		findvideo(request, response);
		request.getRequestDispatcher("/Giaodien/trangcon.jsp").forward(request, response);

	}

	protected void nguoidung(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = sharehelper.users.getUsid();
			userDAO dao = new userDAO();
			Users user = dao.findByID(id);
			request.setAttribute("user", user);
			request.setAttribute("vaitro", sharehelper.users.isVaitro());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void findvideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			videoDAO vDao = new videoDAO();
			String id = request.getParameter("vdid");
			if (id != null) {
				Videos videos = vDao.findByID(id);
				sharehelper.videos = videos;
				request.setAttribute("vid", videos);

			} else {
				Videos videos = vDao.findByID(sharehelper.videos.getVdid());
				sharehelper.videos = videos;
				request.setAttribute("vid", videos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void kiemtra(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String usid = sharehelper.users.getUsid();
			String vdid = request.getParameter("vdid");
			boolean like;
			favoriteDAO dao = new favoriteDAO();
			Favorite fv = dao.findByfav(usid, vdid);
			if (fv != null) {
				like = true;
				request.setAttribute("favlike", like);
			} else {
				like = false;
				request.setAttribute("favlike", like);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void luu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("vdid");
			String us = sharehelper.users.getUsid();
			favoriteDAO fDao = new favoriteDAO();

			Favorite favorite = fDao.findByfav(us, id);
			if (favorite != null) {
				fDao.delete(favorite.getIdfv());
				kiemtra(request, response);
			} else {
				Favorite fav = new Favorite();
				Users users = new Users();
				Videos videos = new Videos();
				users.setUsid(us);
				fav.setUsers(users);
				videos.setVdid(id);
				fav.setVideos(videos);
				fav.setLikedate(sharehelper.now());
				fDao.update(fav);
				kiemtra(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void bbb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("vdid");
			String us = sharehelper.users.getUsid();
			shareDAO shDao = new shareDAO();
			Share share = new Share();
			Users users = new Users();
			String email = request.getParameter("email");
			Videos videos = new Videos();
			users.setUsid(us);/* nhajap usid */
			share.setUsers(users);
			videos.setVdid(id);
			share.setVideos(videos);
			share.setEmail(email);
			share.setSharedate(sharehelper.now());
			shDao.update(share);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void chiase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String email = request.getParameter("email");
			String video = sharehelper.videos.getVideo();
			Properties pros = new Properties();
			pros.put("mail.smtp.auth", "true");
			pros.put("mail.smtp.starttls.enable", "true");
			pros.put("mail.smtp.host", "smtp.gmail.com");
			pros.put("mail.smtp.port", 587);

			Session session = Session.getDefaultInstance(pros, new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication("binhtttps18490@fpt.edu.vn", "Binhbinhbinhbinh2411");

				}
			});
			try {
				MimeMessage msg = new MimeMessage(session);
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				msg.setSubject("Chia sẻ video", "utf-8");
				msg.setText("<iframe width=\"968\" height=\"270\" src=\"https://www.youtube.com/embed/" + video
						+ "?fs=0&?autoplay=0&?disablekb=1\"></iframe>");
				Transport.send(msg);
				bbb(request, response);
				System.out.println("Boonggg");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			videoDAO viDao = new videoDAO();
			List<Videos> videos = viDao.findAll();
			request.setAttribute("video", videos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
