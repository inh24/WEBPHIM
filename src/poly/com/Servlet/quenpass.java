package poly.com.Servlet;

import java.io.IOException;
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

import poly.com.DAO.userDAO;
import poly.com.JPA.sharehelper;
import poly.com.model.Users;

/**
 * Servlet implementation class quenpass
 */
@WebServlet("/quenpass")
public class quenpass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public quenpass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/Giaodien/quenpass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		mail(request, response);
		doGet(request, response);
	}

	protected void mail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String email = request.getParameter("email");
			String usid = request.getParameter("usid");
			userDAO dao = new userDAO();
			Users user = dao.findByID(usid);
			if (!user.getEmail().equals(email)) {
				request.setAttribute("message", "Sai email!");
			} else {
				Properties pros = new Properties();
				pros.put("mail.smtp.auth", "true");
				pros.put("mail.smtp.starttls.enable", "true");
				pros.put("mail.smtp.host", "smtp.gmail.com");
				pros.put("mail.smtp.port", 587);

				Session session = Session.getDefaultInstance(pros, new javax.mail.Authenticator() {
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication("binhtttps18490@fpt.edu.vn",
								"Binhbinhbinhbinh2411");
					}
				});
				try {
					MimeMessage msg = new MimeMessage(session);
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
					msg.setSubject("Xác nhận mật khẩu", "utf-8");
					msg.setText("Tài khoản : "+ user.getUsid() + "\n" +
							"Họ tên : "+ user.getHoten() + "\n" +
					"Mật khẩu là : "+ user.getPass(),"utf-8");
					Transport.send(msg);
					System.out.println("Boonggg");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
