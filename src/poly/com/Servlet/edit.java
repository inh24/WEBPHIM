package poly.com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.com.DAO.userDAO;
import poly.com.JPA.sharehelper;
import poly.com.model.Users;

/**
 * Servlet implementation class edit
 */
@WebServlet({ "/edit", "/edit/chinhsua" })
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (sharehelper.users == null) {
			request.getRequestDispatcher("/Giaodien/login.jsp").forward(request, response);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			chinhsua(request, response);
			request.getRequestDispatcher("/Giaodien/edit.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if (uri.contains("chinhsua")) {
			update(request, response);
		}
		chinhsua(request, response);
		request.getRequestDispatcher("/Giaodien/edit.jsp").forward(request, response);
	}

	protected void chinhsua(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			userDAO dao = new userDAO();
			Users user = dao.findByID(sharehelper.users.getUsid());
			request.setAttribute("user", user);
			request.setAttribute("vaitro", user.isVaitro());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Users us = new Users();
			BeanUtils.populate(us, request.getParameterMap());
			userDAO dao = new userDAO();
			us.setVaitro(us.isVaitro());
			dao.update(us);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
