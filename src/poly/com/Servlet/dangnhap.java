package poly.com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.com.DAO.userDAO;
import poly.com.DAO.videoDAO;
import poly.com.JPA.sharehelper;
import poly.com.model.Users;
import poly.com.model.Videos;

/**
 * Servlet implementation class dangnhap
 */
@WebServlet({ "/dangnhap", "/dangnhap/login", "/dangnhap/logout" })
public class dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangnhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if (uri.contains("logout")) {
			sharehelper.users = null;
		}
		request.getRequestDispatcher("/Giaodien/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if (uri.contains("login")) {
			login(request, response);
		}
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String username = request.getParameter("usid");
			String pass = request.getParameter("pass");
			userDAO uDao = new userDAO();
			Users uss = uDao.findByID(username);
			if (uss.getPass().equals(pass)) {
				System.out.print("Đăng nhập thành công");
				sharehelper.users = uss;
				findAll(request, response);
				request.getRequestDispatcher("/trangchu").forward(request, response);
			} else {
				System.out.print("Đăng nhập không thành công");
				request.getRequestDispatcher("/Giaodien/login.jsp").forward(request, response);
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
			request.setAttribute("vid", videos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
