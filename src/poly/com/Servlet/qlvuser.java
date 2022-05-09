package poly.com.Servlet;

import java.util.List;
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
 * Servlet implementation class qlvuser
 */
@WebServlet({ "/qlvuser", "/qlvuser/insert", "/qlvuser/update", "/qlvuser/edit", "/qlvuser/delete", "/qlvuser/reset" })
public class qlvuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public qlvuser() {
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
		} else if (sharehelper.users.isVaitro() == false) {
			request.getRequestDispatcher("trangchu").forward(request, response);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String uri = request.getRequestURI().toString();
			if (uri.contains("edit")) {
				edit(request, response);
			}
			if (uri.contains("delete")) {
				delete(request, response);
			}
			if (uri.contains("reset")) {
				request.setAttribute("binh1", new Users());
			}
			filltable(request, response);
			nguoidung(request, response);
			request.getRequestDispatcher("/Giaodien/qlvuser.jsp").forward(request, response);
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
		String uri = request.getRequestURI().toString();
		if (uri.contains("insert")) {
			insert(request, response);
		}
		if (uri.contains("update")) {
			update(request, response);
		}
		filltable(request, response);
		nguoidung(request, response);
		request.getRequestDispatcher("/Giaodien/qlvuser.jsp").forward(request, response);

	}

	protected void filltable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			userDAO dao = new userDAO();
			List<Users> user = dao.findAll();
			request.setAttribute("user1", user);
		} catch (Exception e) {
			e.printStackTrace();

		}
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

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			boolean vaitro = Boolean.valueOf(request.getParameter("quyen"));
			Users users = new Users();
			BeanUtils.populate(users, request.getParameterMap());
			userDAO dao = new userDAO();
			users.setVaitro(vaitro);
			dao.insert(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			boolean vaitro = Boolean.valueOf(request.getParameter("quyen"));
			Users users = new Users();
			BeanUtils.populate(users, request.getParameterMap());
			userDAO dao = new userDAO();
			users.setVaitro(vaitro);
			dao.update(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("usid");
			userDAO dao = new userDAO();
			dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("usid");
			userDAO dao = new userDAO();
			Users us = dao.findByID(id);
			request.setAttribute("binh1", us);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
